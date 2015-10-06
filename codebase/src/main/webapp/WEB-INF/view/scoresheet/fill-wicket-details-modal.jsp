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
							<input type="text" class="form-control" id="chaser" placeholder="Chaser name">
						</div>
					</div>
					<div class="form-group">
                        <label class="control-label col-lg-4" for="symbol">Symbol:</label>
                        <div class="col-lg-6">
                            <input type="text" class="form-control" id="symbol" placeholder="Symbol">
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