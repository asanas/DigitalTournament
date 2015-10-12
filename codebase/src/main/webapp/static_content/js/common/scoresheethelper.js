(function(window, document) {
    window.clock = window.clock || {};
    window.lastWicketTime = window.lastWicketTime || 0;
    window.currentStpWtchTime = window.currentStpWtchTime || 0;
    window.tournamentMatchDetails = window.tournamentMatchDetails || {};
    
    var teamNameClicked = 'team1Name';
    window.clock = $('.clock').FlipClock({
        clockFace : 'MinuteCounter',
        autoStart : false
    });
    
    window.tournamentMatchDetails = {
        "currentInning": ${currentInning},
        "currentTurn" : ${currentTurn},
        "matchId" : ${matchDetails.tournamentMatchId},
        "timeLapsed": ${timeLapsed}
    }
    
    var checkClockStatus = function() {
        if(window.clock.running && window.clock.getTime().time > 540) {
            // alert('Turn closure occured.');
            window.clock.stop();
            // make ajax request to save last players details.
            var queryParam = "";
            $.ajax({
            url: '${pageContext.request.contextPath}/saveTurnClosure',
            data: queryParam,
            type: "POST",
            success: function(data) {
                    if(data == 'success') {
                        alert('Turn closure.');
                    }
                }
            });
            return;
        }
        setTimeout(checkClockStatus, 1000);
    }
    
    var windowLoadActions = function() {
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
    }
    
    if(window.tournamentMatchDetails.timeLapsed && window.tournamentMatchDetails.timeLapsed > 0) {
        window.lastWicketTime = parseInt(window.tournamentMatchDetails.timeLapsed);
        window.clock.setTime(window.tournamentMatchDetails.timeLapsed);
        window.clock.start();
        checkClockStatus();
    }
    
    windowLoadActions();
    $(".clock").click(function() {
        if (window.clock.running) {
            window.clock.stop();
            window.clock.reset();
        } else {
            window.clock.start();
        }
    });

    $(".row.teamrow").hover(function() {
        if (window.clock.running) {
            var rowId = $(this).attr('id');
            var hoverRowId = rowId.substr(8);
            if($("#substitute-row-"+ hoverRowId).length == 0) {
                var loadWicketIconHTML = '<a href="#teamrow-'+ hoverRowId +'" class="wicketIcon" id="icn-out-'+ hoverRowId +'" ><span class="glyphicon glyphicon-hand-up icon-big"></span></a>';
                $("#wicket-icon-row-" + hoverRowId).append($(loadWicketIconHTML));
                 $(".wicketIcon").click(function() {
                     var rowId = $(this).attr('href');
                     var hoverRowId = rowId.substr(9);
                     window.currentStpWtchTime = clock.getTime().time;
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
        var queryParam = 'matchId='+window.tournamentMatchDetails.matchId +'&defenderProfileId='+defenderProfileId+'&chaserProfileId='+chaserProfileId+
        '&symbolId='+symbolId+'&formattedTimePlayed='+$("#timePlayed").text().trim()+'&inning='+window.tournamentMatchDetails.currentInning+'&turn='+window.tournamentMatchDetails.currentTurn+'&runTime='+window.currentStpWtchTime;

        $.ajax({
            url: '${pageContext.request.contextPath}/addMatchPoint',
            data: queryParam,
            type: "POST",
            success: function(data) {
                if(data == 'success') {
                    $("#scoresheetChaser-" + $('#selectedTeamRow').val()).html("<h5>" + $("#chaser").find(":selected").text() + "</h5>");
                    $("#scoresheetSymbol-" + $('#selectedTeamRow').val()).html("<h5>" + $("#symbol").find(":selected").text() + "</h5>");
                    $("#scoresheetTime-" + $('#selectedTeamRow').val()).html("<h5>" + $("#timePlayed").html() + "</h5>");
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
        console.log('expanding second rows');
    	$(this).parent().parent().parent().children( ".secondrow" ).removeClass("hide").addClass("show");
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