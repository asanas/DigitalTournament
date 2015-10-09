<div class="modal fade" id="makePlayerSubstitutionModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title text-left">Select Player To Substitute:</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="control-label col-lg-4" for="defender">Player Out:</label>
                        <div class="col-lg-6 text-left" style="padding-top: 10px;">
                            <span class="info-text" id="defenderNameGoingOut">Player Out:</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-4" for="chaser">Player In:</label>
                        <div class="col-lg-6">
                            <select id="defenderComingIn" class="form-control">
                                <c:forEach items="${ defendingTeam}" var="defendingPlayer" varStatus="lpHandle">
                                    <option value="${defendingPlayer.playerProfileId }">${defendingPlayer.firstName} ${defendingPlayer.lastName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                 <input type="hidden" id="defenderGoingOut" /> 
                <button type="button" class="btn btn-default" id="btnMkSubst">Make Substitution</button>
            </div>
        </div>
    </div>
</div>