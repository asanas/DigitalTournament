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

<script src="${pageContext.request.contextPath}/static_content/js/common/scoresheethelper.js"></script>

<script type="text/javascript">
(function(window, document) {
    window.clock = window.clock || {};
    window.lastWicketTime = window.lastWicketTime || 0;
    window.currentStpWtchTime = window.currentStpWtchTime || 0;
    window.tournamentMatchDetails = window.tournamentMatchDetails || {};
    window.pageURL = '${pageContext.request.contextPath}';
    window.tournamentMatchDetails = {
        "currentInning": ${turnDetails.inningNumber},
        "currentTurn" : ${turnDetails.turnNumber},
        "turnStatus" : '${turnDetails.status}',
        "matchId" : ${matchDetails.tournamentMatchId},
        "timeLapsed": ${timeLapsed},
        "currentInningScore": ${currentInningScore}
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
})(window, window.document);
</script>