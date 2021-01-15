package com.containerstore.whereis.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ConferenceRoomsDAOImpl implements ConferenceRoomsDAO {

	private Map<String, String> conferenceRooms;

	@Override
	public List<String> getAllConferenceRooms() {
		return conferenceRooms.keySet().stream().sorted().collect(Collectors.toList());
	}

	public String locationOf1(String query) {
		String location;

		switch (query.trim().toLowerCase()) {
		case "":
			location = "";
			break;
		case "perfect product presentation":
		case "main and main":
			location = "at the north end of the Information Systems area";
			break;
		case "1 great = 3 good":
		case "intuition does not come to an unprepared mind":
			location = "off the atrium, behind reception";
			break;
		case "gumby":
			location = "where gumby has always been located...c'mon!";
			break;
		case "contain yourself":
			location = "upstairs, south end, adjacent to CSD";
			break;
		case "we love our employees":
			location = "upstairs, south end, adjacent to CSD (seating area in front of Contain Yourself)";
			break;
		case "all eyes on elfa":
			location = "upstairs, southwest corner";
			break;
		case "service = selling":
		case "fun and functional":
			location = "upstairs, southwest corner, adjacent to loss prevention";
			break;
		case "communication is leadership":
			location = "upstairs, northwest corner, adjacent to the executive suite";
			break;
		case "we sell the hard stuff":
		case "blue sky":
			location = "up the stairs, turn right (adjacent to merchandising)";
			break;
		default:
			location = "somewhere, but I don't know where";
			break;
		}

		return String.format("%s is located %s", query, location);
	}

	@PostConstruct
	private void buildConferenceRoomsMap() {
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

}
