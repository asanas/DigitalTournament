<%@include file="../common/header.jsp"%>
<header>
    <div class="container" style="padding-top: 100px;">

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
            <div id="selectTourParticipant" class="tab-pane fade" style="margin-left: 15px;">
                  <div class="row rowHeader" style="width:25%">
                       <div class="col-lg-6 text-left">Team Name</div>
                       <!-- <div class="col-lg-6">Sponsored By</div> -->
                   </div>
                   <c:forEach items="${ teamList}" var="team" varStatus="plHandle">
                   <div id="teamrow-${team.teamId}" class="row rowBody" style="width:25%">
                       <div class="col-lg-12 text-left">
                           <label><input id="check-${team.teamId}" type="checkbox">${team.teamName}</label>
                       </div>
                       <!-- <div class="col-lg-6 text-left">&nbsp;</div> -->
                   </div>
                   </c:forEach>
                    <div class="row" style="width:25%; padding-top: 5px;">
                        <div class="col-lg-12 text-right">
                            <button id="addParticipantToTour" type="button" class="btn btn-info" style="margin-right: -15px;">Add Selected Teams</button>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</header>

<script>
(function(window, document) {
    var selectedTeamsArr = [], 
        pageURL = '${pageContext.request.contextPath}'
        tournamentId = '${tournamentDetails.tournamentId}';
    
    $("input[type='checkbox']").click(function() {
        var teamRowId = $(this).parent().parent().parent().attr("id").substring('teamrow-'.length);
        if($(this).is(':checked')) {
             if($.inArray( teamRowId, selectedTeamsArr ) === -1) {
                selectedTeamsArr.push(teamRowId);
             }
        } else {
            if(selectedTeamsArr && $.inArray( teamRowId, selectedTeamsArr ) !== -1) {
                for(var i = selectedTeamsArr.length; i--;) {
                    if(selectedTeamsArr[i] === teamRowId) {
                        selectedTeamsArr.splice(i, 1);
                        break;
                    }
                }
            }
        }
    });

    $("#addParticipantToTour").click(function() {
        if(selectedTeamsArr) {
            var selectedTeams = '';
            for(var i = selectedTeamsArr.length; i--;) {
                selectedTeams =  selectedTeamsArr[i]+ ',' + selectedTeams;
            }
            selectedTeams = selectedTeams.substring(0, selectedTeams.length -1);
            $.ajax({
                url:  pageURL + '/tournament/addParticipants/',
                data: "teams="+ selectedTeams + "&tournamentId=" + tournamentId,
                type: "POST",
                success: function(data) {
                    if(data == 'success') {
                        window.location = pageURL+'/tournament/'+ tournamentId+ '/participants/selectChaseNumbers/'
                    }
                }
            });
        } else {
            alert('Please select teams to add to the tournament.');
        }
    });
})(window, window.document);
</script>
<%@include file="../common/footer.jsp"%>