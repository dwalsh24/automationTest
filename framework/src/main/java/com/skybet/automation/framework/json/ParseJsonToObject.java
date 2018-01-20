package com.skybet.automation.framework.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.objects.events.Event;
import com.skybet.automation.framework.objects.events.Events;

public class ParseJsonToObject {
	
	Gson gson;
	public ParseJsonToObject(){
		gson = new Gson();
	}

	public Events parseJsonToLiveEventsArray(JsonObject eventsObject){
		Events events = new Events();
//		System.out.println(eventsObject.getAsJsonArray("events").get(0));
		events = gson.fromJson(eventsObject, Events.class);
		return events;
	}
	
	public Event parseJsonToFirstLiveEvent(JsonObject eventObject){
		Event event = new Event();
		event = gson.fromJson(eventObject.getAsJsonArray("events").get(0), Event.class);
		return event;
	}
}
