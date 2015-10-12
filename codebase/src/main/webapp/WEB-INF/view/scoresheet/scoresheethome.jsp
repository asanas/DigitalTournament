<%@include file="../common/header.jsp"%>
<header>
    <div class="container" id="scoresheetWrapper">
        <%@include file="scoreboard-header.jsp"%>
        <%@include file="fill-wicket-details-modal.jsp"%>
        <%@include file="substitute-modal.jsp"%>
        <ul class="nav nav-tabs nav-justified">
          <li id="turn1"><a href="#turn1">Turn 1</a></li>
          <li id="turn2"><a href="#turn2">Turn 2</a></li>
          <li id="turn3"><a href="#turn3">Turn 3</a></li>
          <li id="turn4"><a href="#turn4">Turn 4</a></li>
        </ul>
        <div class="row">
            <div class="col-lg-3 text-left">
                <h4>${defendingTeamName}</h4>
            </div>
            <div class="col-lg-1 text-center" style="width: 50px;">&nbsp;</div>
            <div class="col-lg-3 text-left">
                <h5>Wicket Taken By</h5>
            </div>
            <div class="col-lg-2 text-left">
                <h5>How</h5>
            </div>
            <div class="col-lg-1 text-right">
                <h5>Time</h5>
            </div>
        </div>

        <c:forEach items="${ defendingTeam}" var="defendingPlayer" varStatus="lpHandle">
            <div class="row teamrow" id="teamrow-${defendingPlayer.playerProfileId }">
                <div class="col-lg-3 text-left">
                    <h4>
                        <span id="scoresheetDefender-${defendingPlayer.playerProfileId }">${defendingPlayer.tournamentChaseNumber }.${defendingPlayer.firstName } ${defendingPlayer.lastName }</span>
                        <c:if test="${lpHandle.count > 9}">
                            <a id="substitute-row-${defendingPlayer.playerProfileId }" href="#teamrow-${defendingPlayer.playerProfileId }" class="substitute"><span class="glyphicon glyphicon-random icon-small"></span></a>
                        </c:if>
                    </h4>
                </div>
                <div class="col-lg-1 text-left" id="wicket-icon-row-${defendingPlayer.playerProfileId }" style="width: 25px; padding: 0px;"></div>
                <div class="col-lg-8 text-left">
                    <c:choose>
                        <c:when test="${fn:length(defendingPlayer.matchPointDetailsList) > 0}">
                            <c:forEach items="${defendingPlayer.matchPointDetailsList}" var="matchPoint" varStatus="lpPointHandle">
                                <c:choose>
                                    <c:when test="${lpPointHandle.count == 1 && fn:length(defendingPlayer.matchPointDetailsList) > 1}">
                                        <div class="row">
                                            <div class="col-lg-1 text-center" style="width: 25px; padding:0px;"><a href="javascript:void(0);" class="expandTime"><span class="glyphicon glyphicon-plus"></span></a></div>
                                    </c:when>
                                    <c:when test="${lpPointHandle.count > 1}">
                                        <div class="row secondrow" style="display:none;">
                                            <div class="col-lg-1 text-center" style="width: 25px; padding:0px;">&nbsp;</div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="row performaceDetailsRow" >
                                            <div class="col-lg-1 text-center" style="width: 25px; padding:0px;"><a href="javascript:void(0);" class="expandTime" style="display:none;"><span class="glyphicon glyphicon-minus"></span></a></div>
                                    </c:otherwise>
                                </c:choose>
                                    <div class="col-lg-4 text-left"><h5>${matchPoint.chaserName}</h5></div>
                                    <div class="col-lg-4 text-left" style="padding-left:47px;"><h5>${matchPoint.symbol.description}</h5></div>
                                    <div class="col-lg-2 text-left timePlayed"><h5><kbd>${matchPoint.formattedPerTime}</kbd></h5></div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <!-- Adding blank row to fill first Wicket -->
                            <div class="row performaceDetailsRow">
                                <div class="col-lg-1 text-center" style="width: 25px; padding:0px;"><a href="javascript:void(0);" class="expandTime" style="display:none;"><span class="glyphicon glyphicon-minus"></span></a></div>
                                <div class="col-lg-4 text-left" id="scoresheetChaser-${defendingPlayer.playerProfileId }"></div>
                                <div class="col-lg-4 text-left" id="scoresheetSymbol-${defendingPlayer.playerProfileId }" style="padding-left:47px;"></div>
                                <div class="col-lg-2 text-left timePlayed" id="scoresheetTime-${defendingPlayer.playerProfileId }"></div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </div>
</header>
<%@include file="../common/footer.jsp"%>
<style>
/*#scoresheetWrapper {
    border: 5px solid blue;
}*

/*.container .row.teamrow :nth-child(even){
  background-color: #dcdcdc;
}
.container .row.teamrow :nth-child(odd){
  background-color: #aaaaaa;
}*/
.teamrow {
    border-bottom: 1px solid lightgray;
}

.icon-small {
    font-size: 10px;
    color: black;
}

.icon-big {
    font-size: 20px;
    color: black;
    padding-top: 10px;
}

.teamscore {
    font-size: 60px;
}

.modal-dialog {
    color: black;
}
a>span.glyphicon-plus, a>span.glyphicon-minus {
    color:blue;
    margin-top: 10.5px;
}
</style>

<script type="text/javascript">

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
        "currentInning": ${turnDetails.inningNumber},
        "currentTurn" : ${turnDetails.turnNumber},
        "turnStatus" : '${turnDetails.status}',
        "matchId" : ${matchDetails.tournamentMatchId},
        "timeLapsed": ${timeLapsed},
        "currentInningScore": ${currentInningScore}
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
            url: '${pageContext.request.contextPath}/markTurnStatus',
            data: queryParam,
            type: "POST",
            success: function(data) {
                    if(data == 'success') {
                        if(turnStatus == 'COMPLETED') {
                            window.tournamentMatchDetails.turnStatus = 'COMPLETEDANDLOG';
                        }
                    }
                }
        });
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

        if(window.tournamentMatchDetails.turnStatus == 'INPROGRESS' && window.tournamentMatchDetails.timeLapsed 
                && window.tournamentMatchDetails.timeLapsed > 0) {
            window.lastWicketTime = parseInt(window.tournamentMatchDetails.timeLapsed);
            window.clock.setTime(window.tournamentMatchDetails.timeLapsed);
            window.clock.start();
            checkClockStatus();
        }
    }
    
    
    windowLoadActions();
    $(".clock").click(function() {
        if (window.clock.running) {
            window.clock.stop();
            window.clock.reset();
            markTurnStatus('ABORTED');
        } else {
            window.clock.start();
            markTurnStatus('INPROGRESS');
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
        var queryParam = 'matchId='+window.tournamentMatchDetails.matchId +'&defenderProfileId='+defenderProfileId+'&chaserProfileId='+chaserProfileId+
        '&symbolId='+symbolId+'&formattedTimePlayed='+$("#timePlayed").text().trim()+'&inning='+window.tournamentMatchDetails.currentInning+'&turn='+window.tournamentMatchDetails.currentTurn+'&runTime='+window.currentStpWtchTime;

        $.ajax({
            url: '${pageContext.request.contextPath}/addMatchPoint',
            data: queryParam,
            type: "POST",
            success: function(data) {
                if(data == 'success') {
                    if(turnStatus == 'COMPLETEDANDLOG') {
                        window.tournamentMatchDetails.turnStatus = 'COMPLETE';
                    }
                    window.tournamentMatchDetails.currentInningScore = window.tournamentMatchDetails.currentInningScore + 1;
                    if(window.tournamentMatchDetails.currentInningScore > 9) {
                        var newRowScore = '<div class="row secondrow">' +
                                          '<div class="col-lg-1 text-center" style="width: 25px; padding:0px;">&nbsp;</div>' +
                                          '<div class="col-lg-4 text-left"><h5>'+ $("#chaser").find(":selected").text()+ '</h5></div>' +
                                          '<div class="col-lg-4 text-left" style="padding-left:47px;"><h5>'+ $("#symbol").find(":selected").text()+ '</h5></div>' +
                                          '<div class="col-lg-2 text-left"><h5>'+ $("#timePlayed").html() +'</h5></div></div>';
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
</script>