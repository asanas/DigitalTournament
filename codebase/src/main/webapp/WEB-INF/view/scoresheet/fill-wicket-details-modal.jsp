<div class="modal fade" id="fillWicketDetailsModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title text-left">Fill
					Wicket Details</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label class="control-label col-lg-4" for="defender">Defender Name:</label>
						<div class="col-lg-6 text-left" style="padding-top: 10px;">
							<span class="info-text" id="defender">Defender name</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-4" for="chaser">Chaser Name:</label>
						<div class="col-lg-6">
							<select id="chaser" class="form-control">
	                            <option value="NA">None</option>
								<c:forEach items="${ chasingTeam}" var="chasingPlayer" varStatus="lpHandle">
	                                <option value="${chasingPlayer.playerProfileId }">${chasingPlayer.firstName} ${chasingPlayer.lastName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
                        <label class="control-label col-lg-4" for="symbol">Select How:</label>
                        <div class="col-lg-6">
                            <select id="symbol" class="form-control">
                                <option value="1">Simple Touch</option>
                                <option value="2">Out of field</option>
                                <option value="3">Dive</option>
                                <option value="4">Pole Dive</option>
                            </select>
                        </div>
                    </div>
					<div class="form-group">
                        <label class="control-label col-lg-4" for="timePlayed">Time Played:</label>
                        <div class="col-lg-6 text-left" id="timePlayed" style="padding-top: 10px;">
                            2m 10s
                        </div>
                    </div>
				</form>
			</div>
			<div class="modal-footer">
			     <input type="hidden" id="selectedTeamRow" /> 
				<button type="button" class="btn btn-default" id="btnSubmit">Submit</button>
			</div>
		</div>
	</div>
</div>