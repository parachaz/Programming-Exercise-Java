package com.containerstore.whereis.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.containerstore.whereis.domain.ConferenceRoom;

@Repository
public class ConferenceRoomsDAOImpl implements ConferenceRoomsDAO {

	/*
	 * select o.id ORDER_ID, o.order_date ORDER_DATE, c.name CUSTOMER_NAME, s.name
	 * STORE_NAME from orders o, customers c, stores s where o.customer_id=c.id and
	 * o.pickup_store_id != c.nearest_store_id and o.pickup_store_id = s.id;
	 * 
	 * select c.name NAME, c.phone PHONE, COALESCE(l.account,"Not Enrolled")
	 * LOYALTY_ACCOUNT, COALESCE(l.enroll_date,"") ENROLL_DATE from customers c left
	 * join loyalty l on c.id = l.customer_id where c.id not in (select customer_id
	 * from orders);
	 * 
	 * select store_number STORE_NUMBER, abbreviation STORE_ABBREVIATION, state
	 * STATE from stores where id not in ( select nearest_store_id from customers)
	 * group by state
	 */
	private Map<String, String> conferenceRooms;

	@Override
	public List<String> getAllConferenceRooms() {
		System.out.println("Returing list of  conference rooms");
		List<String> rooms = conferenceRooms.keySet().stream().sorted().collect(Collectors.toList());
		for (String room : rooms) {
			System.out.println(room);
		}
		return rooms;
	}

	@PostConstruct
	private void buildConferenceRoomsMap() {
		System.out.println("Building list of  conference rooms");
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

		List<ConferenceRoom> roomsLocation = new ArrayList<>();
		conferenceRooms.keySet().stream().forEach(room -> {
			roomsLocation.add(new ConferenceRoom(room, conferenceRooms.get(room)));
		});
		return roomsLocation;
	}

}
