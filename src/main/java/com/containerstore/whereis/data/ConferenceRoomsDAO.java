package com.containerstore.whereis.data;

import java.util.List;

import com.containerstore.whereis.domain.ConferenceRoom;

public interface ConferenceRoomsDAO {
	/**
	 * Get a list of all conference rooms
	 * 
	 * @return List of conference rooms' names.
	 */
	List<String> getAllConferenceRooms();

	/**
	 * Returns location of the given room.
	 * 
	 * @param roomName
	 * @return
	 */

	String getLocationOf(String roomName);

	/**
	 * Get a list of conference rooms with details for each conference room.
	 * 
	 * @return
	 */

	List<ConferenceRoom> getConferenceRoomsDetails();
}
