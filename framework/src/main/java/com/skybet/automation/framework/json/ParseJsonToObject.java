package com.skybet.automation.framework.json;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.objects.events.Event;
import com.skybet.automation.framework.objects.events.Events;
import com.skybet.automation.framework.objects.markets.*;
import com.skybet.automation.framework.objects.markets.updates.MarketUpdate;
import com.skybet.automation.framework.objects.outcomes.Outcome;
import com.skybet.automation.framework.objects.outcomes.Outcomes;
import com.skybet.automation.framework.objects.outcomes.updates.OutcomeUpdate;

public class ParseJsonToObject {
	
	Gson gson;
	public ParseJsonToObject(Gson gson){
		this.gson = gson;
	}

	/**
	 * Returns the events listed in /football/live as an Event array
	 * @param eventsObject - JSON obtained from /football/live
	 * @return
	 */
	public Events parseJsonToLiveEventsArray(JsonObject eventsObject){
		Events events = new Events();
		events = gson.fromJson(eventsObject, Events.class);
		return events;
	}
	
	/**
	 * Returns the first event listed in /football/live as an Event object
	 * @param eventObject - JSON obtained from /football/live
	 * @return
	 */
	public Event parseJsonToFirstLiveEvent(JsonObject eventObject){
		Event event = new Event();
		event = gson.fromJson(eventObject.getAsJsonArray("events").get(0), Event.class);
		return event;
	}
	
	/**
	 * Returns the Markets in an array for a given Event object
	 * @param eventObject - JSON obtained from /sportsbook/event/(eventId)
	 * @param eventId - eventId of the event object to find markets for
	 * @return
	 */
	public Markets parseJsonToMarketsArray(JsonObject eventObject, int eventId){
		Markets markets = new Markets();
		ArrayList<Market> marketList = new ArrayList<Market>();
		JsonArray jsonArray = eventObject.get("markets").getAsJsonObject().get(eventId+"").getAsJsonArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			marketList.add(gson.fromJson(jsonArray.get(i), Market.class));
		}
		markets.setMarkets(marketList);
		return markets;
	}
	
	/**
	 * Returns the Outcomes of a given Market object
	 * @param marketObject - JSON obtained from /sportsbook/market/(marketId)
	 * @param marketId - marketId of the market object to find outcomes for
	 * @return
	 */
	public Outcomes parseJsonToOutcomesArray(JsonObject marketObject, int marketId){
		Outcomes outcomes = new Outcomes();
		ArrayList<Outcome> outcomeList = new ArrayList<Outcome>();
		JsonArray jsonArray = marketObject.get("outcomes").getAsJsonObject().get(marketId+"").getAsJsonArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			outcomeList.add(gson.fromJson(jsonArray.get(i), Outcome.class));
		}
		outcomes.setOutcomes(outcomeList);
		return outcomes;
	}
	
	public ArrayList<OutcomeUpdate> parseJsonArrayToOutcomeUpdateArray(ArrayList<JsonObject> jsonObjects){
		ArrayList<OutcomeUpdate> outcomeUpdates = new ArrayList<OutcomeUpdate>();
		for (int i = 0; i < jsonObjects.size(); i++) {
			outcomeUpdates.add(gson.fromJson(jsonObjects.get(i), OutcomeUpdate.class));
		}
		return outcomeUpdates;
	}
	
	public ArrayList<MarketUpdate> parseJsonArrayToMarketUpdateArray(ArrayList<JsonObject> jsonObjects){
		ArrayList<MarketUpdate> marketUpdates = new ArrayList<MarketUpdate>();
		for (int i = 0; i < jsonObjects.size(); i++) {
			marketUpdates.add(gson.fromJson(jsonObjects.get(i), MarketUpdate.class));
		}
		return marketUpdates;
	}
}
