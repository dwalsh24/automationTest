package com.skybet.automation.framework;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.api.ApiConnection;
import com.skybet.automation.framework.api.HttpClientFactory;
import com.skybet.automation.framework.api.WebSocketConnection;
import com.skybet.automation.framework.json.ParseJsonToObject;
import com.skybet.automation.framework.json.Serialiser;
import com.skybet.automation.framework.objects.events.Event;
import com.skybet.automation.framework.objects.events.Events;
import com.skybet.automation.framework.objects.markets.Markets;
import com.skybet.automation.framework.objects.markets.updates.MarketUpdate;
import com.skybet.automation.framework.objects.outcomes.Outcomes;
import com.skybet.automation.framework.objects.outcomes.updates.OutcomeUpdate;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
//    	HttpClientFactory httpClientFactory = new HttpClientFactory();
//    	HttpClient httpClient = httpClientFactory.createHttpClient();
//    	ApiConnection apiConnection = new ApiConnection();
    	Gson gson = new Gson();
//    	JsonObject jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/football/live");
//    	
//    	ParseJsonToObject parseJsonToObject = new ParseJsonToObject(gson);
//    	Events events = parseJsonToObject.parseJsonToLiveEventsArray(jsonObject);
//    	
//    	System.out.println(events.getEvents().size());
//    	System.out.println(events.getEvents().get(0).getName());
//    	System.out.println(events.getEvents().get(1).getName());
//    	System.out.println("!---------------");
//    	
//    	Event event = parseJsonToObject.parseJsonToFirstLiveEvent(jsonObject);
//    	System.out.println(event.getEventId());
//    	
//    	jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/sportsbook/event/"+event.getEventId());
//    	
//    	Markets markets = parseJsonToObject.parseJsonToMarketsArray(jsonObject, event.getEventId());
//    	for (int i = 0; i < markets.getMarkets().size(); i++) {
//    		System.out.println(markets.getMarkets().get(i).getMarketId());
//		}
//    	jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/sportsbook/market/"+markets.getMarkets().get(0).getMarketId());
//    	
//    	Outcomes outcomes = parseJsonToObject.parseJsonToOutcomesArray(jsonObject, markets.getMarkets().get(0).getMarketId());
//    	for (int i = 0; i < outcomes.getOutcomes().size(); i++) {
//    		System.out.println(outcomes.getOutcomes().get(i).getName());
//		}
    	
    	WebSocketConnection webSocketConnection = new WebSocketConnection();
    	ParseJsonToObject parseJsonToObject = new ParseJsonToObject(gson);
    	Serialiser serialiser = new Serialiser();
    	ArrayList<String> inputs = webSocketConnection.getUpdatesFromWebSocket("{\"type\": \"subscribe\", \"keys\": [\"o.*\"]}", 3000);
    	
    	for(String x: inputs){
    		System.out.println(x);
    	}
    	ArrayList<JsonObject> outcomeUpdates = serialiser.serializeStringArrayListToJsonObjectArrayList(inputs);
    	for(JsonObject x: outcomeUpdates){
    		System.out.println(x);
    	}
    	
    	ArrayList<OutcomeUpdate> outcomes = parseJsonToObject.parseJsonArrayToOutcomeUpdateArray(outcomeUpdates);
    	for (int i = 0; i < outcomes.size(); i++) {
    		System.out.println(outcomes.get(i).getType());
    	}
 System.out.println("------------------------------");
    	
    	ArrayList<String> inputs2 = webSocketConnection.getUpdatesFromWebSocket("{\"type\": \"subscribe\", \"keys\": [\"m.*\"]}", 10000);
		
//		for(String x: inputs2){
//			System.out.println(x);
//		}
    	ArrayList<JsonObject> marketUpdates = serialiser.serializeStringArrayListToJsonObjectArrayList(inputs);
    	for(JsonObject x: marketUpdates){
    		System.out.println(x);
    	}
    	
    	ArrayList<MarketUpdate> markets = parseJsonToObject.parseJsonArrayToMarketUpdateArray(marketUpdates);
    	for (int i = 0; i < markets.size(); i++) {
			System.out.println(markets.get(i).getType());
		}
    }
}
