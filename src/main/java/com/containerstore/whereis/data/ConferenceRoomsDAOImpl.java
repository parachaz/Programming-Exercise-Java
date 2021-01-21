package com.containerstore.whereis.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.containerstore.whereis.domain.ConferenceRoom;

/**
 * This class mocks implementation of repository object. In a real-world
 * application the class will retrieve data from a database. In this mock
 * implementation we have hard-coded the data. The data is stored in a Map, that
 * facilitates the lookup of a conference room by its name.
 * 
 * @author Zaheer
 *
 */
@Repository
public class ConferenceRoomsDAOImpl implements ConferenceRoomsDAO {

	/**
	 * Map to hold conference rooms and their locations
	 */
	private Map<String, String> conferenceRooms;
	private Log logger = LogFactory.getLog(ConferenceRoomsDAOImpl.class);

	@Override
	public List<String> getAllConferenceRooms() {

		logger.debug("Returing list of conference rooms");
		List<String> rooms = conferenceRooms.keySet().stream().sorted().collect(Collectors.toList());
		// list all rooms for debugging purposes
		for (String room : rooms) {
			logger.debug(room);
		}
		return rooms;
	}

	/**
	 * Populate the map with conference rooms details. This is our data store.
	 */
	@PostConstruct
	private void buildConferenceRoomsMap() {
		logger.debug("Building list of  conference rooms");
		conferenceRooms = new HashMap<>();
		conferenceRooms.put("fill their baskets", "in the vendor conference area (off of reception)");
		conferenceRooms.put("service selection price", "in the vendor conference area (off of reception)");
		conferenceRooms.put("man in the desert", "in the vendor conference area (off of reception)");
		conferenceRooms.put("air of excitement", "in the vendor conference area (off of reception)");
		conferenceRooms.put("data central", "in the Information Systems area");
		conferenceRooms.put("perfect product presentation", "at the north end of the Information Systems area");
		conferenceRooms.put("main and main", "at the north end of the Information Systems area");
		conferenceRooms.put("1 great = 3 good", "off the atrium, behind reception");
		conferenceRooms.put("intuition does not come to an unprepared mind", "off the atrium, behind reception");
		conferenceRooms.put("gumby", "where gumby has always been located...c'mon!");
		conferenceRooms.put("contain yourself", "upstairs, south end, adjacent to CSD");
		conferenceRooms.put("we love our employees",
				"upstairs, south end, adjacent to CSD (seating area in front of Contain Yourself)");
		conferenceRooms.put("all eyes on elfa", "upstairs, southwest corner");
		conferenceRooms.put("service = selling", "upstairs, southwest corner, adjacent to loss prevention");
		conferenceRooms.put("fun and functional", "upstairs, southwest corner, adjacent to loss prevention");
		conferenceRooms.put("communication is leadership",
				"upstairs, northwest corner, adjacent to the executive suite");
		conferenceRooms.put("we sell the hard stuff", "up the stairs, turn right (adjacent to merchandising)");
		conferenceRooms.put("blue sky", "up the stairs, turn right (adjacent to merchandising)");
	}

	@Override
	public String getLocationOf(String roomName) {
		return String.format("%s is located %s", roomName,
				conferenceRooms.getOrDefault(roomName, "somewhere, but I don't know where"));
	}

	@Override
	public List<ConferenceRoom> getConferenceRoomsDetails() {
		logger.debug("Get conference rooms details");
		List<ConferenceRoom> roomsLocation = new ArrayList<>();
		// Build a list of conference rooms from conferenceRooms map.
		conferenceRooms.keySet().stream().forEach(room -> {
			roomsLocation.add(new ConferenceRoom(room, conferenceRooms.get(room)));
		});
		logger.debug("Returning list of " + roomsLocation.size() + " rooms.");
		return roomsLocation;
	}

}
