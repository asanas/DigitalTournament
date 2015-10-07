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
						<span id="scoresheetDefender-${defendingPlayer.playerProfileId }">${defendingPlayer.tournamentChaseNumber }.${defendingPlayer.firstName }</span>
						<c:if test="${lpHandle.count > 9}">
							<a href="#teamrow-${defendingPlayer.playerProfileId }"
								onclick="loadSubstituteModal();"><span
								class="glyphicon glyphicon-random icon-small"></span></a>
						</c:if>
					</h4>
				</div>
				<div class="col-lg-1 text-left" id="wicket-icon-row-${defendingPlayer.playerProfileId }" style="width: 50px; padding: 0px;"></div>
				<div class="col-lg-8 text-left">
					<div class="row">
						<div class="col-lg-4 text-left" id="scoresheetChaser-${defendingPlayer.playerProfileId }"></div>
						<div class="col-lg-4 text-left" id="scoresheetSymbol-${defendingPlayer.playerProfileId }" style="padding-left:47px;"></div>
						<div class="col-lg-2 text-left" id="scoresheetTime-${defendingPlayer.playerProfileId }"></div>
					</div>
				</div>
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

$(function() {
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
    var clock = $('.clock').FlipClock({
        clockFace : 'MinuteCounter',
        autoStart : false
    });
    
    $(".clock").click(function() {
        if (clock.running) {
            clock.stop();
            clock.reset();
        } else {
            clock.start();
        }
    });

    $(".row.teamrow").hover(function() {
         var rowId = $(this).attr('id');
         var hoverRowId = rowId.substr(8);
         var loadWicketIconHTML = '<a href="#teamrow-'+ hoverRowId +'" class="wicketIcon" id="icn-out-'+ hoverRowId +'" ><span class="glyphicon glyphicon-hand-up icon-big"></span></a>';
         $("#wicket-icon-row-" + hoverRowId).append($(loadWicketIconHTML));

         $(".wicketIcon").click(function() {
            var rowId = $(this).attr('href');
            var hoverRowId = rowId.substr(9);
            $('#defender').html($("#scoresheetDefender-"+ hoverRowId).html().split('.')[1]);
            $('#selectedTeamRow').val(hoverRowId);
            $("#chaser").val('NA');
            $("#symbol").val('1');
            $("#fillWicketDetailsModal").modal();
        });
     }, function() {
         $(this).find("a.wicketIcon:last").remove();
     });

    $("#btnSubmit").click(function() {
        // TODO: Ajax call to save wicket details...
        
        var chaserProfileId = $("#chaser").find(":selected").val();
        var symbolId = $("#symbol").find(":selected").val();
        var timePlayed = $("#timePlayed").html();
        
        // var queryParam = 'defender='+team1Id+'&team2Id='+team2Id+'&tossWonBy='+$('input[name=tossWonTeam]:checked').val()+'&electedTo='+$('input[name=electedTo]:checked').val();
    
        $("#scoresheetChaser-" + $('#selectedTeamRow').val()).html("<h5>" + $("#chaser").find(":selected").text() + "</h5>");
        $("#scoresheetSymbol-" + $('#selectedTeamRow').val()).html("<h5>" + $("#symbol").find(":selected").text() + "</h5>");
        $("#scoresheetTime-" + $('#selectedTeamRow').val()).html("<h5>" + $("#timePlayed").html() + "</h5>");
        /*$.ajax({
            url: '${pageContext.request.contextPath}/startQuickMatch',
            data: queryParam,
            type: "POST",
            success: function(data) {
                if(data == 'success') {
                	$("#scoresheetChaser-" + $('#selectedTeamRow').val()).html("<h5>" + $("#chaser").val() + "</h5>");
                    $("#scoresheetSymbol-" + $('#selectedTeamRow').val()).html("<h5>" + $("#symbol").val() + "</h5>");
                    $("#scoresheetTime-" + $('#selectedTeamRow').val()).html("<h5>" + $("#timePlayed").html() + "</h5>");
                    /*var chasingTeamScore = parseInt($("#chasingTeamScore").html()) + 1;
                    $("#chasingTeamScore").html(chasingTeamScore+1);
                }
            }
        });*/
        $("#fillWicketDetailsModal").modal("hide");
    });
});
	
</script>