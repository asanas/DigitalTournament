(function(window, document) {
    window.clock = window.clock || {};
    window.lastWicketTime = window.lastWicketTime || 0;
    window.currentStpWtchTime = window.currentStpWtchTime || 0;
    window.tournamentMatchDetails = window.tournamentMatchDetails || {};
    window.pageURL = window.pageURL || {};
    var teamNameClicked = 'team1Name';
    window.clock = $(".clock").TimeCircles({
        "start": false,
        "animation": "smooth",
        "bg_width": 1,
        "fg_width": 0.04,
        "circle_bg_color": "#18BC9C",
        "time": {
            "Days": {
                "text": "Days",
                "color": "#FFCC66",
                "show": false
            },
            "Hours": {
                "text": "Hours",
                "color": "#18BC9C",
                "show": false
            },
            "Minutes": {
                "text": "Minutes",
                "color": "#18BC9C",
                "show": true,
                "text-size": "68px"
            },
            "Seconds": {
                "text": "Seconds",
                "color": "#10066b",
                "show": true
            }
        }
    });
    
    
    window.initiateWindowLoadActions = function() {
        console.log('Started executing window load actions.');
        if(window.tournamentMatchDetails.currentInning == 1) {
            if(window.tournamentMatchDetails.currentTurn == 1) {
                $("#turn1").addClass("active");
            } else {
                $("#turn2").addClass("active");
            }
        } else if(window.tournamentMatchDetails.currentInning == 2) {
            if(window.tournamentMatchDetails.currentTurn == 1) {
                $("#turn3").addClass("active");
            } else {
                $("#turn4").addClass("active");
            }
        } else {
            if(window.tournamentMatchDetails.currentTurn == 1) {
                $("#turn5").addClass("active");
            } else {
                $("#turn6").addClass("active");
            }
        }

        if(window.tournamentMatchDetails.turnStatus == 'INPROGRESS' && window.tournamentMatchDetails.timeLapsed 
                && window.tournamentMatchDetails.timeLapsed > 0) {
            window.lastWicketTime = parseInt(window.tournamentMatchDetails.timeLapsed);
            window.clock.start().addTime(-window.tournamentMatchDetails.timeLapsed);
            checkClockStatus();
        }
    }
    
    var checkClockStatus = function() {
        if(window.clock.isRunning() && (-1 * window.clock.getTime()) > 540) {
            // alert('Turn closure occured.');
            window.clock.stop();
            // make ajax request to save last players details.
            window.tournamentMatchDetails.turnStatus = 'COMPLETEDANDLOG';
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
                            alert('Reached turn closure. Please mark player who remained not out.');
                        }
                    }
                }
        });
    }
    
   $("#loadFoulModal").click(function(){
       $(this).hide( "slide", { direction: "left"  }, 500 );
       $(".foul-panel").show( "slide", { direction: "right"  }, 500);
    });

   $("#hideFoulModal").click(function(){
       $(".foul-panel").hide( "slide", { direction: "right"  }, 500);
       $("#loadFoulModal").show( "slide", { direction: "left"  }, 500 );
    });
   
   $(".adjustFoulCount").click(function(){
	   if(window.clock.isRunning()) {
	       var elemId = $(this).attr("id");
	       var substrIndex = 9;
	       var addition = false, makeRequest = true, action = 'minus';
	       if(elemId.indexOf('Plus') != -1) {
	           substrIndex = 8;
	           addition = true;
	           action = 'addition';
	       }
	       var foulCount = parseInt($("#foulCount" + elemId.substr(substrIndex)).html());
	       if(addition) {
	           foulCount = foulCount + 1;           
	       } else {
	           if(foulCount == 0) {
	                return;
	           } 
	           foulCount = foulCount - 1;
	       }
	       $("#foulCount" + elemId.substr(substrIndex)).html(foulCount);
	       var qParam = "matchId="+ window.tournamentMatchDetails.matchId + "&action=" + action + "&inning="+window.tournamentMatchDetails.currentInning + 
	       "&chasingTeamId=" + window.tournamentMatchDetails.chasingTeamId + "&foulId=" + elemId.substr(substrIndex);
	       // make and ajax call to save foul details.
	       $.ajax({
	           url: window.pageURL + '/adjustFoulCount',
	           data: qParam,
	           type: "POST",
	           success: function(data) {
	                   if(data == 'success') {
	                	    
	                   }
	               }
	       });
		   
	   }
   });
    $("#show").click(function(){
       $(".target").show( "slide", {direction: "up" }, 2000 );
    });
     
    $( "#symbol" ).change(function() {
        if('Sudden Attack' == $("#symbol").find(":selected").text() ||
                'Late Entry' == $("#symbol").find(":selected").text()) {
            $("#timePlayed").html('0m 0s');
            return;
        }
        var playerTime = window.currentPlayerTime;
        var minutes = Math.floor(playerTime/60);
        var seconds = playerTime%60;
        $("#timePlayed").html(minutes+'m '+seconds+'s');
    });
    
    $(".turnTab").click(function() {
        // http://localhost:4141/digital-tour/loadScoresheet/match/7/inning/1/turn/1
        var turnHref = $(this).attr('href');
        var gotoTurn = turnHref.substr(turnHref.length- 1), gotoInning = 1;
        if(gotoTurn > 2) {
            if(gotoTurn % 2) {
                gotoInning = Math.floor(gotoTurn/2) + gotoTurn % 2;
                gotoTurn = 1;
            } else {
                gotoInning = gotoTurn/2;
                gotoTurn = 2;
            }
        }
        if(window.clock.isRunning()) {
            alert('Turn'+window.tournamentMatchDetails.currentTurn + ' is on progress, could not load scoresheet data of selected turn.');
            return;
        }
        window.location = window.pageURL + '/loadScoresheet/match/'+window.tournamentMatchDetails.matchId+'/inning/'+ gotoInning +'/turn/'+gotoTurn;
    });
    
    $(".clock").click(function() {
        if(window.tournamentMatchDetails.turnStatus == 'COMPLETED' || window.tournamentMatchDetails.turnStatus == 'ABORTED') {
            alert('This turn is completed. Please click on Turn' + (window.tournamentMatchDetails.currentTurn + 1)+ ' to proceed further.');
        } else {
            if (window.clock.isRunning()) {
                window.clock.stop();
                // window.clock.reset();
                markTurnStatus('ABORTED');
            } else {
                window.clock.addTime(-1 * window.clock.getTime());
                window.clock.start();
                markTurnStatus('INPROGRESS');
                checkClockStatus();
            }
        }
    });

    var validateShowWicketIcon = function(hoverRowId) {
        var resultFlag = false;
        // check if clock is running
        if(window.clock.isRunning() || 'COMPLETEDANDLOG' == window.tournamentMatchDetails.turnStatus) {
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
                         if(window.tournamentMatchDetails.turnStatus == 'COMPLETEDANDLOG') {
                             window.currentStpWtchTime = 540;
                         } else {
                             window.currentStpWtchTime = Math.floor(-1 * clock.getTime());
                         }
                         var playerTime  = window.currentStpWtchTime - window.lastWicketTime;
                         var minutes = Math.floor(playerTime/60);
                         var seconds = playerTime%60;
                         window.currentPlayerTime = playerTime;
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
        var timePlayedMinutes = parseInt(timePlayedArray[0].substr(0, 1)), timePlayedSeconds = parseInt(timePlayedArray[1].substr(0, timePlayedArray[1].length -1));
        var timePlayed = timePlayedMinutes * 60 + timePlayedSeconds;
        var out = true;
        var categories = ['Late Entry', 'Out of field', 'Retired'];
        var found = $.inArray($("#symbol").find(":selected").text(), categories) > -1;
        var chaserName = $("#chaser").find(":selected").text();
        var symbolDesc = $("#symbol").find(":selected").text();
        if(found) {
            chaserName = '--';
            chaserProfileId = 'NA';
            window.currentPlayerTime;
            if('Sudden Attack' == symbolDesc || 'Late Entry' == symbolDesc) {
                timePlayed = 0;
            }
        }
        var queryParam = 'matchId='+window.tournamentMatchDetails.matchId +'&defenderProfileId='+defenderProfileId+'&chaserProfileId='+chaserProfileId+
        '&symbolId='+symbolId+'&timePlayed='+timePlayed+'&inning='+window.tournamentMatchDetails.currentInning+'&turn='+
        window.tournamentMatchDetails.currentTurn+'&runTime='+window.currentStpWtchTime;
        
        if(window.tournamentMatchDetails.turnStatus == 'COMPLETEDANDLOG') {
            out = false;
        }
        queryParam = queryParam + '&out=' + out;
        console.log(queryParam);
        $.ajax({
            url: window.pageURL + '/addMatchPoint',
            data: queryParam,
            type: "POST",
            success: function(data) {
                if(data == 'success') {
                    
                    if('Sudden Attack' != symbolDesc && 'Late Entry' != symbolDesc) {
                        window.lastWicketTime = window.currentStpWtchTime;
                    }
                    
                    if(window.tournamentMatchDetails.turnStatus == 'COMPLETEDANDLOG') {
                        window.tournamentMatchDetails.turnStatus = 'COMPLETE';
                    }
                    window.tournamentMatchDetails.currentInningScore = window.tournamentMatchDetails.currentInningScore + 1;
                    if(window.tournamentMatchDetails.currentInningScore > 9) {
                        var newRowScore = '<div class="row secondrow">' +
                                          '<div class="col-lg-1 text-center" style="width: 25px; padding:0px;">&nbsp;</div>' +
                                          '<div class="col-lg-4 text-left"><h5>'+ chaserName + '</h5></div>' +
                                          '<div class="col-lg-4 text-left" style="padding-left:47px;"><h5>'+ $("#symbol").find(":selected").text()+ '</h5></div>' +
                                          '<div class="col-lg-2 text-left"><h5><kbd>'+ $("#timePlayed").html() +'</kbd></h5></div></div>';
                        $("#teamrow-"+defenderProfileId).children(".col-lg-8").append($(newRowScore));
                        $("#teamrow-"+defenderProfileId).find("a.expandTime").css("display", "block");
                        $(".showWicketIcn").html("true");
                    } else {
                        $("#scoresheetChaser-" + $('#selectedTeamRow').val()).html("<h5>" + chaserName + "</h5>");
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
    
    $("#addInning").click(function() {
        if($("#turn6").length) {
            alert('Cannot add more than three innings.');
            return;
        }
        $.ajax({
            url: window.pageURL + '/addInning',
            data: "matchId="+ window.tournamentMatchDetails.matchId,
            type: "POST",
            success: function(data) {
                    if(data == 'success') {
                        var turnTabs = '<li id="turn5"><a href="#turn5" class="turnTab">Turn 5</a></li>' + 
                                       '<li id="turn6"><a href="#turn6" class="turnTab">Turn 6</a></li>';
                        $(".turnsContainer").append($(turnTabs));
                    }
                }
        });
    });
})(window, window.document);
