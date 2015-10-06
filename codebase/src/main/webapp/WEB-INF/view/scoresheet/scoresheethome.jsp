<%@include file="../common/header.jsp"%>
<header>
	<div class="container" id="scoresheetWrapper">
		<%@include file="scoreboard-header.jsp"%>
        <%@include file="fill-wicket-details-modal.jsp"%>
		<div class="row">
			<div class="col-lg-3 text-left">
				<h4>${defendingTeamName}</h4>
			</div>
			<div class="col-lg-1 text-center" style="width:50px;">&nbsp;</div>
			<div class="col-lg-3 text-center"><h5>Wicket Taken By</h5></div>
			<div class="col-lg-2 text-center"><h5>How</h5></div>
			<div class="col-lg-1 text-center"><h5>Time</h5></div>
		</div>

		<c:forEach items="${ defendingTeam}" var="defendingPlayer" varStatus="lpHandle">
			<div class="row teamrow" id="teamrow-${defendingPlayer.playerProfileId }">
				<div class="col-lg-3 text-left">
					<h4>
					<span id="scoresheetDefender-${defendingPlayer.playerProfileId }">${defendingPlayer.tournamentChaseNumber }.${defendingPlayer.name }</span>
					<c:if test="${lpHandle.count > 9}">
                        <a href="#teamrow-${defendingPlayer.playerProfileId }" onclick="loadSubstituteModal();"><span class="glyphicon glyphicon-random icon-small"></span></a>
                     </c:if>
                     </h4>
				</div>
				<div class="col-lg-1 text-left" id="wicket-icon-row-${defendingPlayer.playerProfileId }" style="width:50px;padding:0px;">
                </div>
				<div class="col-lg-3 text-center" id="scoresheetChaser-${defendingPlayer.playerProfileId }"></div>
				<div class="col-lg-2 text-center" id="scoresheetSymbol-${defendingPlayer.playerProfileId }"></div>
				<div class="col-lg-1 text-center" id="scoresheetTime-${defendingPlayer.playerProfileId }"></div>
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
        .modal-dialog {
        color:black;}
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
		var loadWicketIconHTML = '<a href="#teamrow-'+ hoverRowId +'" class="wicketIcon" id="icn-out-'+ hoverRowId +'" ><span class="glyphicon glyphicon-hand-up icon-big"></span></a>';
		$("#wicket-icon-row-"+hoverRowId).append($(loadWicketIconHTML));
		
		$(".wicketIcon").click(function() {
	        var rowId = $(this).attr('href');
	        var hoverRowId = rowId.substr(9);
	        $('#defender').html($("#scoresheetDefender-"+ hoverRowId).html().split('.')[1]);
	        $('#selectedTeamRow').val(hoverRowId);
	        $("#fillWicketDetailsModal").modal();
	    });
	}, function() {
		$(this).find("a:last").remove();
	});
	
	$("#btnSubmit").click(function() {
		$("#scoresheetChaser-"+$('#selectedTeamRow').val()).html("<h5>"+$("#chaser").val()+"</h5>");
		$("#scoresheetSymbol-"+$('#selectedTeamRow').val()).html("<h5>"+$("#symbol").val()+"</h5>");
		$("#scoresheetTime-"+$('#selectedTeamRow').val()).html("<h5>"+$("#timePlayed").html()+"</h5>");
        
		$("#fillWicketDetailsModal").modal("hide");
    });
	
	
</script>