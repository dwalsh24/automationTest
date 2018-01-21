package com.skybet.automation.framework.objects.events;

import java.util.ArrayList;

public class Events {
	private ArrayList<Event> events;

	public Event getEventByEventId(int eventId) {
		Event event = null;
		for(Event x: events) {
			if(x.getEventId() == eventId) {
				event = x;
				break;
			}
		}
		return event;
	}
	
	public Event getEventByName(String name) {
		Event event = null;
		for(Event x: events) {
			if(x.getName().contains(name)) {
				event = x;
				break;
			}
		}
		return event;
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

}
