package com.digitour.app.manager;

import org.springframework.web.multipart.MultipartFile;

import com.digitour.app.db.model.Team;

public interface PlayerProfileManager {

	void addPlayersListToTeam(Team newTeam, MultipartFile playersList);

}
