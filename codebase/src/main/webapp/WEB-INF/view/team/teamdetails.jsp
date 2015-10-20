<%@include file="../common/header.jsp"%>
<header>
    <div class="container">

        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#teamDetails">Team
                    Details</a></li>
            <li><a data-toggle="tab" href="#playersList">Players</a></li>
        </ul>

        <div class="tab-content">
            <div id="teamDetails" class="tab-pane fade in active">
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Team Name:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${team.teamName }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Established In:</h4></div>
                    <div class="col-lg-6 text-left"><h4>--</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Founder Name:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${team.founderName }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>More Information:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${team.description }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Address:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${team.clubAddressLine1 }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Achievements:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${team.achievements }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>City:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${team.city.cityName }</h4></div>
                </div>
            </div>
            <div id="playersList" class="tab-pane fade">
                <div class="row">
                    <div class="col-lg-1 text-right">Sr. No.</div>
                    <div class="col-lg-3 text-left">Player Name</div>
                    <div class="col-lg-1">Age</div>
                    <div class="col-lg-1">Weight</div>
                    <div class="col-lg-1">Height</div>
                    <div class="col-lg-2 text-left">Role</div>
                    <div class="col-lg-2 text-left">Major Skill</div>
                </div>
                <c:forEach items="${ team.playersList}" var="player" varStatus="plHandle">
	                <div class="row">
	                    <div class="col-lg-1 text-right">${plHandle.count }.</div>
	                    <div class="col-lg-3 text-left">${player.firstName} ${player.lastName}</div>
	                    <div class="col-lg-1">20</div>
	                    <div class="col-lg-1">${player.weight}</div>
	                    <div class="col-lg-1">${player.height}</div>
	                    <div class="col-lg-2 text-left">${player.role}</div>
	                    <div class="col-lg-2 text-left">${player.majorSkill}</div>
	                </div>
	            </c:forEach>
            </div>
        </div>
    </div>
</header>

<button id="showTeamList" type="button" class="btn btn-info fixed attach-right" style="padding: 0px 2px 10px;">
    <span class="glyphicon glyphicon-circle-arrow-left icon-big "></span>
</button>

<div class="team-list-panel fixed attach-right">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th colspan="2"> ${chasingTeamName }</th>
                <th colspan="2" class="text-right">
                    <span id="hideTeamList" class="glyphicon glyphicon-circle-arrow-right icon-big" style="color:#D0D0D4; cursor: pointer;"></span>
                </th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${ teamList}" var="teamDetails" varStatus="tdHandle">
             <tr>
                 <td class="text-left"><a href="${pageContext.request.contextPath}/loadTeamDetails/team/${teamDetails.teamId}">${teamDetails.teamName}</a></td>
             </tr>
          </c:forEach>
        </tbody>
  </table>
</div>

<script>
$("#showTeamList").click(function(){
    $(this).hide( "slide", { direction: "left"  }, 500 );
    $(".team-list-panel").show( "slide", { direction: "right"  }, 500);
});

$("#hideTeamList").click(function(){
    $(".team-list-panel").hide( "slide", { direction: "right"  }, 500);
    $("#showTeamList").show( "slide", { direction: "left"  }, 500 );
 });
</script>
<%@include file="../common/footer.jsp"%>