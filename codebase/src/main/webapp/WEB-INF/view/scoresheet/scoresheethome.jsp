<%@include file="../common/header.jsp"%>
<header>
	<div class="container" id="scoresheetWrapper">
		<%@include file="scoreboard-header.jsp"%>
		<%@include file="fill-wicket-details-modal.jsp"%>
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
			<div class="row teamrow"
				id="teamrow-${defendingPlayer.playerProfileId }">
				<div class="col-lg-3 text-left">
					<h4>
						<span id="scoresheetDefender-${defendingPlayer.playerProfileId }">${defendingPlayer.tournamentChaseNumber }.${defendingPlayer.firstName } ${defendingPlayer.lastName }</span>
						<c:if test="${lpHandle.count > 9}">
							<a href="#teamrow-${defendingPlayer.playerProfileId }"
								onclick="loadSubstituteModal();"><span
								class="glyphicon glyphicon-random icon-small"></span></a>
						</c:if>
					</h4>
				</div>
				<div class="col-lg-1 text-left" id="wicket-icon-row-${defendingPlayer.playerProfileId }" style="width: 50px; padding: 0px;"></div>
				<div class="col-lg-8 text-left">
				    <c:choose>
				        <c:when test="${fn:length(defendingPlayer.matchPointDetailsList) > 0}">
				            <c:forEach items="${defendingPlayer.matchPointDetailsList}" var="matchPoint" varStatus="lpPointHandle">
	                            <div class="row">
	                                <div class="col-lg-4 text-left" id="scoresheetChaser-${defendingPlayer.playerProfileId }-${matchPoint.matchPointId}"><h5>${matchPoint.chaserName}</h5></div>
	                                <div class="col-lg-4 text-left" id="scoresheetSymbol-${defendingPlayer.playerProfileId }" style="padding-left:47px;"><h5>${matchPoint.symbol.description}</h5></div>
	                                <div class="col-lg-2 text-left" id="scoresheetTime-${defendingPlayer.playerProfileId }"><h5>${matchPoint.formattedPerTime}</h5></div>
	                            </div>
	                        </c:forEach>
					    </c:when>
				        <c:otherwise>
					        <div class="row">
		                        <div class="col-lg-4 text-left" id="scoresheetChaser-${defendingPlayer.playerProfileId }"></div>
		                        <div class="col-lg-4 text-left" id="scoresheetSymbol-${defendingPlayer.playerProfileId }" style="padding-left:47px;"></div>
		                        <div class="col-lg-2 text-left" id="scoresheetTime-${defendingPlayer.playerProfileId }"></div>
		                       </div>
				        </c:otherwise>
			        </c:choose>
				</div>
			</div>
		</c:forEach>
		
		<input type="hidden" id="matchId" value="${matchId }"> 
	</div>
</header>
<%@include file="../common/footer.jsp"%>
<style>
/*#scoresheetWrapper {
    border: 5px solid blue;
}*/

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
</style>
<script type="text/javascript">

(function(window, document) {
	window.clock = window.clock || {};
	window.lastWicketTime = window.lastWicketTime || 0;
	window.currentStpWtchTime = window.currentStpWtchTime || 0;
	var currentURL = window.location.pathname; // /digital-tour/loadScoresheet/match/6/inning/1/turn/1
	var currentTurn = currentURL.substr(currentURL.indexOf('turn')+5, 1);
	var currentInning = currentURL.substr(currentURL.indexOf('inning')+7, 1);
	if(currentInning == 1) {
		if(currentTurn == 1) {
			$("#turn1").addClass("active");
		} else {
			$("#turn2").addClass("active");
		}
	} else {
		if(currentTurn == 1) {
            $("#turn3").addClass("active");
        } else {
            $("#turn4").addClass("active");
        }
	}
	var teamNameClicked = 'team1Name';
	window.clock = $('.clock').FlipClock({
        clockFace : 'MinuteCounter',
        autoStart : false
    });
    
    if('${timeLapsed}' && '${timeLapsed}' > 0) {
    	window.lastWicketTime = parseInt('${timeLapsed}');
    	window.clock.setTime(${timeLapsed});
    	window.clock.start();
    } 

    $(".clock").click(function() {
        if (window.clock.running) {
            window.clock.stop();
            window.clock.reset();
        } else {
            window.clock.start();
        }
    });

    $(".row.teamrow").hover(function() {
         var rowId = $(this).attr('id');
         var hoverRowId = rowId.substr(8);
         var loadWicketIconHTML = '<a href="#teamrow-'+ hoverRowId +'" class="wicketIcon" id="icn-out-'+ hoverRowId +'" ><span class="glyphicon glyphicon-hand-up icon-big"></span></a>';
         $("#wicket-icon-row-" + hoverRowId).append($(loadWicketIconHTML));

         $(".wicketIcon").click(function() {
              if(clock.running) {
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
              } else {
                alert('Please start the stopwatch to add wicket details.');
             }
        });
     }, function() {
         $(this).find("a.wicketIcon:last").remove();
     });

    $("#btnSubmit").click(function() {
        var defenderProfileId = $("#selectedTeamRow").val();
        var chaserProfileId = $("#chaser").find(":selected").val();
        var symbolId = $("#symbol").find(":selected").val();
        var queryParam = 'matchId='+$('#matchId').val() +'&defenderProfileId='+defenderProfileId+'&chaserProfileId='+chaserProfileId+
        '&symbolId='+symbolId+'&formattedTimePlayed='+$("#timePlayed").text().trim()+'&inning='+currentInning+'&turn='+currentTurn+'&runTime='+window.currentStpWtchTime;

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
                    /*var chasingTeamScore = parseInt($(".chasingTeamScore").html()) + 1;
                    $("#chasingTeamScore").html(chasingTeamScore+1);*/
                }
            }
        });
        
    });
})(window, window.document);
	
</script>