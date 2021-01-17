package com.containerstore.whereis.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.containerstore.whereis.data.ConferenceRoomsDAO;

@Component
public class ConferenceRoomsImpl implements ConferenceRooms {
	@Autowired
	ConferenceRoomsDAO conferenceRoomsDAO;

	@Override
	public String locationOf(String query) {
		return conferenceRoomsDAO.getLocationOf(query);
	}

	@Override
	public List<String> conferenceRoomsList() {
		return conferenceRoomsDAO.getAllConferenceRooms();
	}

	@Override
	public List<ConferenceRoom> conferenceRoomsDetails() {
		return conferenceRoomsDAO.getConferenceRoomsDetails();
	}

}
