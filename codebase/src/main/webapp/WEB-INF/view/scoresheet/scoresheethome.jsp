<%@include file="../common/header.jsp"%>
<header>
	<div class="container" id="scoresheetWrapper">
		<%@include file="scoreboard-header.jsp"%>
        <%@include file="fill-wicket-details-modal.jsp"%>
		<div class="row">
			<div class="col-lg-3 text-left">
				<h3>${defendingTeamName}</h3>
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
					<h4>
					${defendingPlayer.tournamentChaseNumber }.${defendingPlayer.name }
					<c:if test="${lpHandle.count > 9}">
                        <a href="#teamrow-${defendingPlayer.playerProfileId }" onclick="loadSubstituteModal();"><span class="glyphicon glyphicon-random icon-small"></span></a>
                     </c:if>
                     </h4>
				</div>
				<div class="col-lg-1 text-center" id="wicket-icon-row-${defendingPlayer.playerProfileId }">
                </div>
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
        .icon-small {
            font-size: 10px;
            color:black;
        }
        .icon-big {
            font-size: 20px;
            color:black;
            padding-top: 10px;
        }
        .teamscore {
            font-size: 60px;
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
    
    
	$(".row.teamrow").hover(function() {
		var rowId = $(this).attr('id');
		var hoverRowId = rowId.substr(8);
		var loadWicketIconHTML = '<a href="#teamrow-'+ hoverRowId +'" onclick="loadWicketModal();" id="icn-out-'+ hoverRowId +'" ><span class="glyphicon glyphicon-hand-up icon-big"></span></a>';
		$("#wicket-icon-row-"+hoverRowId).append($(loadWicketIconHTML));
	}, function() {
		$(this).find("a:last").remove();
	});
</script>