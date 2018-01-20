package com.skybet.automation.framework.json;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.objects.events.Event;
import com.skybet.automation.framework.objects.events.Events;
import com.skybet.automation.framework.objects.markets.*;
import com.skybet.automation.framework.objects.outcomes.Outcome;
import com.skybet.automation.framework.objects.outcomes.Outcomes;

public class ParseJsonToObject {
	
	Gson gson;
	public ParseJsonToObject(){
		gson = new Gson();
	}

	public Events parseJsonToLiveEventsArray(JsonObject eventsObject){
		Events events = new Events();
		events = gson.fromJson(eventsObject, Events.class);
		return events;
	}
	
	public Event parseJsonToFirstLiveEvent(JsonObject eventObject){
		Event event = new Event();
		event = gson.fromJson(eventObject.getAsJsonArray("events").get(0), Event.class);
		return event;
	}
	
	public Markets parseJsonToMarketsArray(JsonObject eventObject, int eventId){
		Markets markets = new Markets();
		ArrayList<Market> marketList = new ArrayList<Market>();
		JsonArray jsonArray = eventObject.get("markets").getAsJsonObject().get(eventId+"").getAsJsonArray();
		System.out.println(jsonArray);
		for (int i = 0; i < jsonArray.size(); i++) {
			marketList.add(gson.fromJson(jsonArray.get(i), Market.class));
		}
		markets.setMarkets(marketList);
		return markets;
	}
	
	public Outcomes parseJsonToOutcomesArray(JsonObject marketObject, int marketId){
		Outcomes outcomes = new Outcomes();
		ArrayList<Outcome> outcomeList = new ArrayList<Outcome>();
		JsonArray jsonArray = marketObject.get("outcomes").getAsJsonObject().get(marketId+"").getAsJsonArray();
		System.out.println(jsonArray);
		for (int i = 0; i < jsonArray.size(); i++) {
			outcomeList.add(gson.fromJson(jsonArray.get(i), Outcome.class));
		}
		outcomes.setOutcomes(outcomeList);
		return outcomes;
	}
}
