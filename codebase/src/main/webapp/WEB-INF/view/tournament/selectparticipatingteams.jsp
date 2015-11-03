<%@include file="../common/header.jsp"%>
<header>
    <div class="container">

        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#teamDetails">Tournament Details</a></li>
            <li><a data-toggle="tab" href="#selectTourParticipant">Tournament Participants</a></li>
        </ul>

        <div class="tab-content">
            <div id="teamDetails" class="tab-pane fade in active">
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Name:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${tournamentDetails.tournamentName }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Description:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${tournamentDetails.description }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Location:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${tournamentDetails.location}</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Start Date:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${tournamentDetails.tournamentStartDate}</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>End Date:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${tournamentDetails.tournamentEndDate }</h4></div>
                </div>
                <div class="row">
                    <div class="col-lg-6 text-right"><h4>Age Group:</h4></div>
                    <div class="col-lg-6 text-left"><h4>${tournamentDetails.ageGroup }</h4></div>
                </div>
            </div>
            <div id="selectTourParticipant" class="tab-pane fade">
                <div class="row rowHeader">
                    <div class="col-lg-1 text-right">&nbsp;</div>
                    <div class="col-lg-3 text-left">Team Name</div>
                    <div class="col-lg-1">Sponsored By</div>
                </div>
                <c:forEach items="${ teamList}" var="team" varStatus="plHandle">
                    <div class="row rowBody">
                        <div class="col-lg-1 text-right">${plHandle.count }.</div>
                        <div class="col-lg-3 text-left">${team.teamName}</div>
                        <div class="col-lg-1">&nbsp;</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</header>

<script>

</script>
<%@include file="../common/footer.jsp"%>