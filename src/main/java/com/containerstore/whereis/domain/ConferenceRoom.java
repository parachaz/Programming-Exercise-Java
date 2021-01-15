package com.containerstore.whereis.domain;

/**
 * Java object to represent a conference room *
 * 
 * @author Zaheer
 *
 */
public class ConferenceRoom {
	String name;
	String location;
	int capacity;

	public ConferenceRoom(String name, String location) {
		super();
		this.name = name;
		this.location = location;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
