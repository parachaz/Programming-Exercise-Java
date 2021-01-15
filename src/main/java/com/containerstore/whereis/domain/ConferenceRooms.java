package com.containerstore.whereis.domain;

import java.util.List;

public interface ConferenceRooms {
	String locationOf(String query);

	List<String> conferenceRoomsList();
}
