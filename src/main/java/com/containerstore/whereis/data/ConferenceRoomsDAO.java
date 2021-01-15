package com.containerstore.whereis.data;

import java.util.List;

public interface ConferenceRoomsDAO {
	List<String> getAllConferenceRooms();

	String getLocationOf(String roomName);
}
