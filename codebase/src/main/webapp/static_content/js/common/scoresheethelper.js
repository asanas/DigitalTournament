(function(window, document) {
    window.clock = window.clock || {};
    window.lastWicketTime = window.lastWicketTime || 0;
    window.currentStpWtchTime = window.currentStpWtchTime || 0;
    window.tournamentMatchDetails = window.tournamentMatchDetails || {};
    window.pageURL = window.pageURL || {};
    var teamNameClicked = 'team1Name';
    window.clock = $('.clock').FlipClock({
        clockFace : 'MinuteCounter',
        autoStart : false
    });
    
    window.initiateWindowLoadActions = function() {
        console.log('Started executing window load actions.');
        if(window.tournamentMatchDetails.currentInning == 1) {
            if(window.tournamentMatchDetails.currentTurn == 1) {
                $("#turn1").addClass("active");
            } else {
                $("#turn2").addClass("active");
            }
        } else {
            if(window.tournamentMatchDetails.currentTurn == 1) {
                $("#turn3").addClass("active");
            } else {
                $("#turn4").addClass("active");
            }
        }
        if(window.tournamentMatchDetails.turnStatus == 'INPROGRESS' && window.tournamentMatchDetails.timeLapsed 
                && window.tournamentMatchDetails.timeLapsed > 0) {
            window.lastWicketTime = parseInt(window.tournamentMatchDetails.timeLapsed);
            window.clock.setTime(window.tournamentMatchDetails.timeLapsed);
            window.clock.start();
            checkClockStatus();
        }
    }
    
    var checkClockStatus = function() {
        if(window.clock.running && window.clock.getTime().time > 540) {
            // alert('Turn closure occured.');
            window.clock.stop();
            // make ajax request to save last players details.
            markTurnStatus('COMPLETED');
            return;
        }
        setTimeout(checkClockStatus, 1000);
    }
    
    var markTurnStatus = function(turnStatus) {
        var queryParam = 'matchId='+window.tournamentMatchDetails.matchId + '&inning='+
        window.tournamentMatchDetails.currentInning+'&turn='+window.tournamentMatchDetails.currentTurn+'&turnStatus='+turnStatus;
        console.log('Query param: ' + queryParam);
        $.ajax({
            url: window.pageURL + '/markTurnStatus',
            data: queryParam,
            type: "POST",
            success: function(data) {
                    if(data == 'success') {
                        if(turnStatus == 'COMPLETED') {
                            window.tournamentMatchDetails.turnStatus = 'COMPLETEDANDLOG';
                            alert('Reached turn closure. Please mark player who remained not out.');
                        }
                    }
                }
        });
    }
    
    
    $(".turnTab").click(function() {
        // http://localhost:4141/digital-tour/loadScoresheet/match/7/inning/1/turn/1
        var turnHref = $(this).attr('href');
        var gotoTurn = turnHref.substr(turnHref.length- 1), gotoInning = 1;
        if(gotoTurn > 2) {
            gotoInning = 2;
            gotoTurn = Math.floor(gotoTurn/2);
        }
        
        if(window.clock.running) {
            alert('Turn'+window.tournamentMatchDetails.currentTurn + ' is on progress, could not load scoresheet data of selected turn.');
            return;
        }
        window.location = window.pageURL + '/loadScoresheet/match/'+window.tournamentMatchDetails.matchId+'/inning/'+ gotoInning +'/turn/'+gotoTurn;
    });
    
    $(".clock").click(function() {
        if(window.tournamentMatchDetails.turnStatus == 'COMPLETED' || window.tournamentMatchDetails.turnStatus == 'ABORTED') {
            alert('This turn is completed. Please click on Turn' + (window.tournamentMatchDetails.currentTurn + 1)+ ' to proceed further.');
        } else {
            if (window.clock.running) {
                window.clock.stop();
                window.clock.reset();
                markTurnStatus('ABORTED');
            } else {
                window.clock.start();
                markTurnStatus('INPROGRESS');
                checkClockStatus();
            }
        }
        
    });

    var validateShowWicketIcon = function(hoverRowId) {
        var resultFlag = false;
        // check if clock is running
        if(window.clock.running || 'COMPLETEDANDLOG' == window.tournamentMatchDetails.turnStatus) {
            // And team row does not have details for the performance and current turn total wickets are less than 9
            if($("#teamrow-"+hoverRowId).find('.timePlayed').html() == '' && window.tournamentMatchDetails.currentInningScore < 9) {
                resultFlag = true;
            // And team row does have details for the performance but current turn total wickets are more than 8
            } else if($("#teamrow-"+hoverRowId).find('.timePlayed').html() != '' && window.tournamentMatchDetails.currentInningScore >= 9) {
                resultFlag = true;
            }
        }
        return resultFlag;
    }
    
    $(".row.teamrow").hover(function() {
        // if(window.clock.running) {
            var rowId = $(this).attr('id');
            var hoverRowId = rowId.substr(8);
            
            // check if player is not a substitute and turn status is either NOTSTARTED/INPROGRESS.
            if($("#substitute-row-"+ hoverRowId).length == 0 && 
                    (window.tournamentMatchDetails.turnStatus == 'INPROGRESS' || window.tournamentMatchDetails.turnStatus == 'NOTSTARTED' || 
                            window.tournamentMatchDetails.turnStatus == 'COMPLETEDANDLOG')) {
                var loadWicketIconHTML = '<a href="#teamrow-'+ hoverRowId +'" class="wicketIcon" id="icn-out-'+ hoverRowId +'" ><span class="glyphicon glyphicon-hand-up icon-big"></span></a>';
                if(validateShowWicketIcon(hoverRowId)) {
                     $("#wicket-icon-row-" + hoverRowId).append($(loadWicketIconHTML));
                     $(".wicketIcon").click(function() {
                         var rowId = $(this).attr('href');
                         var hoverRowId = rowId.substr(9);
                         window.currentStpWtchTime = clock.getTime().time -1;
                         var playerTime  = window.currentStpWtchTime - window.lastWicketTime;
                         var minutes = Math.floor(playerTime/60);
                         var seconds = playerTime%60;
                         $('#defender').html($("#scoresheetDefender-"+ hoverRowId).html().split('.')[1]);
                         $('#selectedTeamRow').val(hoverRowId);
                         $("#chaser").val('NA');
                         $("#symbol").val('1');
                         $("#timePlayed").html(minutes+'m '+seconds+'s');
                         $("#fillWicketDetailsModal").modal();
                    }); 
                 }
             }
        // }
     }, function() {
         $(this).find("a.wicketIcon:last").remove();
     });

    var openSubstituteModal = function(element) {
        var rowId = $(element).attr('href');
        var hoverRowId = rowId.substr(9);
        $(".alert-warning").removeClass("show").addClass("hide");
        $('#defenderNameGoingOut').html($("#scoresheetDefender-"+ hoverRowId).html().split('.')[1]);
        $('#defenderGoingOut').val(hoverRowId);
        $("#makePlayerSubstitutionModal").modal();
   }

    $("#btnSubmit").click(function() {
        var defenderProfileId = $("#selectedTeamRow").val();
        var chaserProfileId = $("#chaser").find(":selected").val();
        var symbolId = $("#symbol").find(":selected").val();
        var timePlayedArray = $("#timePlayed").text().split(' ');
        var timePlayedMinutes = parseInt(timePlayedArray[0].substr(0, 1)), timePlayedSeconds = parseInt(timePlayedArray[1].substr(0, timePlayedArray[1].length()-1));
        var timePlayed = timePlayedMinutes * 60 + timePlayedSeconds;
        console.log('Time played ::: ' + timePlayed);
        var out = true;
        var queryParam = 'matchId='+window.tournamentMatchDetails.matchId +'&defenderProfileId='+defenderProfileId+'&chaserProfileId='+chaserProfileId+
        '&symbolId='+symbolId+'&timePlayed='+timePlayed+'&inning='+window.tournamentMatchDetails.currentInning+'&turn='+
        window.tournamentMatchDetails.currentTurn+'&runTime='+window.currentStpWtchTime;
        
        if(window.tournamentMatchDetails.turnStatus == 'COMPLETEDANDLOG') {
            out = false;
        }
        queryParam = queryParam + '&out=' + out;
        $.ajax({
            url: window.pageURL + '/addMatchPoint',
            data: queryParam,
            type: "POST",
            success: function(data) {
                if(data == 'success') {
                    window.lastWicketTime = window.currentStpWtchTime;
                    if(window.tournamentMatchDetails.turnStatus == 'COMPLETEDANDLOG') {
                        window.tournamentMatchDetails.turnStatus = 'COMPLETE';
                    }
                    window.tournamentMatchDetails.currentInningScore = window.tournamentMatchDetails.currentInningScore + 1;
                    if(window.tournamentMatchDetails.currentInningScore > 9) {
                        var newRowScore = '<div class="row secondrow">' +
                                          '<div class="col-lg-1 text-center" style="width: 25px; padding:0px;">&nbsp;</div>' +
                                          '<div class="col-lg-4 text-left"><h5>'+ $("#chaser").find(":selected").text()+ '</h5></div>' +
                                          '<div class="col-lg-4 text-left" style="padding-left:47px;"><h5>'+ $("#symbol").find(":selected").text()+ '</h5></div>' +
                                          '<div class="col-lg-2 text-left"><h5><kbd>'+ $("#timePlayed").html() +'</kbd></h5></div></div>';
                        $("#teamrow-"+defenderProfileId).children(".col-lg-8").append($(newRowScore));
                        $("#teamrow-"+defenderProfileId).find("a.expandTime").css("display", "block");
                        $(".showWicketIcn").html("true");
                    } else {
                        $("#scoresheetChaser-" + $('#selectedTeamRow').val()).html("<h5>" + $("#chaser").find(":selected").text() + "</h5>");
                        $("#scoresheetSymbol-" + $('#selectedTeamRow').val()).html("<h5>" + $("#symbol").find(":selected").text() + "</h5>");
                        $("#scoresheetTime-" + $('#selectedTeamRow').val()).html("<h5><kbd>" + $("#timePlayed").html() + "</kbd></h5>");
                        $("#teamrow-"+defenderProfileId).find(".showWicketIcn").html("false");
                    }
                    $("#fillWicketDetailsModal").modal("hide");
                    var chasingTeamScore = parseInt($("#chasingTeamScore").html()) + 1;
                    $("#chasingTeamScore").html(chasingTeamScore);
                }
            }
        });
    });

    $(".substitute").bind("click", function(){
        openSubstituteModal(this);
    });
    
    $(".expandTime").click(function() {
        if($(this).children("span").hasClass("glyphicon-plus")) {
            $(this).parent().parent().parent().children(".secondrow").slideDown("slow");
            $(this).children("span").removeClass("glyphicon-plus").addClass("glyphicon-minus");
        } else {
            $(this).parent().parent().parent().children(".secondrow").slideUp("slow");
            $(this).children("span").removeClass("glyphicon-minus").addClass("glyphicon-plus");
        }
    });

    $("#btnMkSubst").click(function() {
        var defenderProfileIdGoingOut = $("#defenderGoingOut").val();
        var defenderProfileIdComingIn = $("#defenderComingIn").find(":selected").val();

        if($("#substitute-row-" + defenderProfileIdComingIn).length == 0) {
            $("#substitute-row-" + defenderProfileIdGoingOut).remove();
            $("#makePlayerSubstitutionModal").modal("hide");
            var substIconHtml = '<a id="substitute-row-'+ defenderProfileIdComingIn +'" href="#teamrow-'+ defenderProfileIdComingIn +'" class="substitute"><span class="glyphicon glyphicon-random icon-small"></span></a>';
            $("#teamrow-" + defenderProfileIdComingIn+">div>h4").append($(substIconHtml));
    
            $("#substitute-row-" + defenderProfileIdComingIn).bind("click", function(){
                openSubstituteModal(this);
            });
        } else {
            $(".alert-warning").removeClass("hide").addClass("show");
        }
    });
})(window, window.document);