<div class="scoresheet-header">
    <div class="row">
        <div class="col-lg-4 text-center">
            <h1 class="teamContainer " id="defendingTeamName">
                ${defendingTeamName }
            </h1>
            <h3 class="sponsor">
                <small>Sponsored By</small>
                ${defendingTeamSponsorName}
            </h3>
        </div>
        <div class="col-lg-4 text-center">
            &nbsp;
        </div>
        <div class="col-lg-4 text-center">
            <h1 class="teamContainer " id="chasingTeamName">
                ${chasingTeamName}
            </h1>
            <h3 class="sponsor">
                <small>Sponsored By</small>
                ${chasingTeamSponsorName}
            </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 text-center">
            <h1 id="defendingTeamScore" class="teamscore">${defendingTeamScore }</h1>
            <c:if test="${not empty defendingTeamSponsorLogoUrl }">
                <div class="sponsorLogo">
                    <img src="${pageContext.request.contextPath}/static_content/images/${defendingTeamSponsorLogoUrl}" class="img-responsive img-rounded" style="height: 70px;">
                 </div>
             </c:if>
        </div>
        <div class="col-lg-4 text-center" style="margin-top: -80px;">
            <h3><span class="glyphicon glyphicon-time icon-big" style="padding:0 10px;"></span>STOPWATCH</h3>
            <div class="stopwatchContainer"><div class="clock clearfix" style="width: 100%;"></div>
            </div>
            <div id="stopwatchBtnPanel" class="panel panel-default" style="position: absolute; display: none; margin: -50px 0px 0px 90px; border: 0;">
                <div class="panel-body" style="background-color: #A033CE;">
                    <div class="btn-group">
                        <button id="startTime" type="button" class="btn btn-warning" style="padding: 0px 10px;">Start</button>
                        <button id="stopTime" type="button" class="btn btn-warning" style="padding: 0px 10px;">Stop</button>
                        <button id="resetTime" type="button" class="btn btn-warning" style="padding: 0px 10px;">Reset</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4 text-center">
            <h1 id="chasingTeamScore" class="teamscore">${chasingTeamScore }</h1>
            <c:if test="${not empty chasingTeamSponsorLogoUrl }">
                <div class="sponsorLogo">
                        <img src="${pageContext.request.contextPath}/static_content/images/${chasingTeamSponsorLogoUrl}" class="img-responsive img-rounded" style="height: 70px;">
                 </div>
             </c:if>
        </div>
    </div>
</div>