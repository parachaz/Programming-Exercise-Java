package com.containerstore.whereis.data;

import java.util.List;

import com.containerstore.whereis.domain.ConferenceRoom;

public interface ConferenceRoomsDAO {
	List<String> getAllConferenceRooms();

	String getLocationOf(String roomName);

	List<ConferenceRoom> getConferenceRoomsDetails();
}
