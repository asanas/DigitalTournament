<div class="modal fade" id="loadTournamentListModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title text-left">Available Tournaments</h4>
            </div>
            <div class="modal-body">

            <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>Tournament name</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Prize</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ tournamentList}" var="tournament" varStatus="lpHandle">
                        <tr>
                          <td>${tournament.tournamentName }</td>
                          <td>${tournament.tournamentStartDate }</td>
                          <td>${tournament.tournamentEndDate }</td>
                          <td>${tournament.prize }</td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
            </div>
            <div class="modal-footer">
                 <input type="hidden" id="selectedTeamRow" /> 
                <button type="button" class="btn btn-default" id="btnSubmit">Submit</button>
            </div>
        </div>
    </div>
</div>