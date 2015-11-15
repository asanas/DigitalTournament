<%@include file="../common/header.jsp"%>
<header>
    <div class="container" style="padding-top: 100px">
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
                    <div class="col-lg-6 text-left"><h4>${team.formattedEstablishedIn }</h4></div>
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
                <div class="row rowHeader">
                    <div class="col-lg-1 text-right">Sr. No.</div>
                    <div class="col-lg-5 text-left">Player Name</div>
                    <div class="col-lg-1">Age</div>
                    <c:if test="${isIncludeHeight}"> <div class="col-lg-1">Height(cms)</div></c:if>
                    <c:if test="${isIncludeWeight }"> <div class="col-lg-1">Weight(kg)</div></c:if>
                    <div class="col-lg-2 text-left">Role</div>
                </div>
                <c:forEach items="${ team.playersList}" var="player" varStatus="plHandle">
                    <div class="row rowBody">
                        <div class="col-lg-1 text-right">${plHandle.count }.</div>
                        <div class="col-lg-5 text-left">${player.firstName} ${player.lastName}</div>
                        <div class="col-lg-1">${player.age} </div>
                        <c:if test="${isIncludeHeight}"> <div class="col-lg-1">${player.formattedHeight}</div> </c:if>
                        <c:if test="${isIncludeWeight }"> <div class="col-lg-1">${player.formattedWeight}</div> </c:if>
                        <div class="col-lg-2 text-left">${player.role}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</header>

<button id="showmenteamlist" type="button" class="btn btn-info fixed attach-right team-list-btn" style="padding: 0px 2px 10px;">
    <span class="glyphicon glyphicon-circle-arrow-left icon-big "></span>
</button>

<button id="showwomenteamlist" type="button" class="btn btn-info fixed attach-left team-list-btn" style="padding: 0px 2px 10px;">
    <span class="glyphicon glyphicon-circle-arrow-right icon-big "></span>
</button>

<div id="womenteamlistpanel" class="team-list-panel fixed attach-left">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th colspan="2" style="color: #EFD813;"> Team List(Women)</th>
                <th colspan="2" class="text-right">
                    <span id="hidewomenteamlistpanel" class="glyphicon glyphicon-circle-arrow-left icon-big" style="color:#D0D0D4; cursor: pointer;"></span>
                </th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${ womenTeamList}" var="teamDetails" varStatus="tdHandle">
             <tr>
                 <td class="text-left"><a href="${pageContext.request.contextPath}/loadTeamDetails/team/${teamDetails.teamId}/weight/true/height/true/tournament/0">${teamDetails.displayName}</a></td>
             </tr>
          </c:forEach>
        </tbody>
  </table>
</div>

<div id="menteamlistpanel" class="team-list-panel fixed attach-right">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th colspan="2" style="color: #EFD813;"> Team List(Men)</th>
                <th colspan="2" class="text-right">
                    <span id="hidementeamlistpanel" class="glyphicon glyphicon-circle-arrow-right icon-big " style="color:#D0D0D4; cursor: pointer;"></span>
                </th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${ menTeamList}" var="teamDetails" varStatus="tdHandle">
             <tr>
                 <td class="text-left"><a href="${pageContext.request.contextPath}/loadTeamDetails/team/${teamDetails.teamId}/weight/true/height/true/tournament/0">${teamDetails.displayName}</a></td>
             </tr>
          </c:forEach>
        </tbody>
  </table>
</div>

<script>
$(".team-list-btn").click(function(){
    $(this).fadeOut();
    var id = $(this).attr('id');
    $("#" + id.substr(4) + "panel").fadeIn();
});

$("#hidementeamlistpanel, #hidewomenteamlistpanel").click(function(){
    var id = $(this).attr('id');
    $("#" + id.substr(4)).fadeOut();
    $("#show"+ id.substr(4, id.indexOf('panel') -4)).fadeIn();
});

</script>
<%@include file="../common/footer.jsp"%>