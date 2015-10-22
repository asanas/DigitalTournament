package com.digitour.app.db.model.support.enums;

public enum TurnStatus {
    NOTSTARTED("Not Started"), INPROGRESS("In Progress"), ABORTED("Aborted"), COMPLETED("Completed");
	private String txtTurnStatus;
	private TurnStatus(String txtTurnStatus) {
		this.txtTurnStatus = txtTurnStatus;
	}
}
