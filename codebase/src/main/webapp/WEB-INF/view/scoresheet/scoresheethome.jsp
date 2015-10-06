<%@include file="../common/header.jsp"%>
<header>
	<div class="container" id="scoresheetWrapper">
		<%@include file="scoreboard-header.jsp"%>
        <%@include file="fill-wicket-details-modal.jsp"%>
		<div class="row">
			<div class="col-lg-3 text-left">
				<h2>${defendingTeamName}</h2>
			</div>
			<div class="col-lg-1 text-center">&nbsp;</div>
			<div class="col-lg-3 text-center">Wicket Taken By</div>
			<div class="col-lg-2 text-center">How</div>
			<div class="col-lg-1 text-center">Assist</div>
			<div class="col-lg-1 text-center">Time</div>
		</div>

		<c:forEach items="${ defendingTeam}" var="defendingPlayer" varStatus="lpHandle">
			<div class="row teamrow" id="teamrow-${defendingPlayer.playerProfileId }">
				<div class="col-lg-3 text-left">
					<h4>${defendingPlayer.tournamentChaseNumber }.${defendingPlayer.name }</h4>
				</div>
				<div class="col-lg-1 text-center">&nbsp;</div>
				<div class="col-lg-3 text-center">&nbsp;</div>
				<div class="col-lg-2 text-center">&nbsp;</div>
				<div class="col-lg-1 text-center">&nbsp;</div>
				<div class="col-lg-1 text-center">&nbsp;</div>
			</div>
		</c:forEach>
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

</style>
<script type="text/javascript">
    var teamNameClicked = 'team1Name';
    var clock = $('.clock').FlipClock({
        clockFace : 'MinuteCounter',
        autoStart : false
    });
    $(".clock").click(function() {
        if(clock.running) {
            clock.stop();
            clock.reset();
        } else {
            clock.start();
        }
        
    });
</script>