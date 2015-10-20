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
                    <div class="col-lg-1">Sr. No.</div>
                    <div class="col-lg-3">Player Name</div>
                    <div class="col-lg-3">Age</div>
                    <div class="col-lg-3">Weight</div>
                    <div class="col-lg-3">Height</div>
                    <div class="col-lg-3">Role</div>
                    <div class="col-lg-3">Role</div>
                </div>
            </div>
        </div>
    </div>
</header>
<%@include file="../common/footer.jsp"%>