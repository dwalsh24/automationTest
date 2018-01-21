package com.skybet.automation.framework;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.api.ApiConnection;
import com.skybet.automation.framework.api.HttpClientFactory;
import com.skybet.automation.framework.json.ParseJsonToObject;
import com.skybet.automation.framework.objects.events.Event;
import com.skybet.automation.framework.objects.events.Events;
import com.skybet.automation.framework.objects.markets.Markets;
import com.skybet.automation.framework.objects.outcomes.Outcomes;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
    	HttpClientFactory httpClientFactory = new HttpClientFactory();
    	HttpClient httpClient = httpClientFactory.createHttpClient();
    	ApiConnection apiConnection = new ApiConnection();
    	Gson gson = new Gson();
    	JsonObject jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/football/live");
    	
//    	System.out.println(jsonObject);
    	ParseJsonToObject parseJsonToObject = new ParseJsonToObject(gson);
    	Events events = parseJsonToObject.parseJsonToLiveEventsArray(jsonObject);
    	
    	System.out.println(events.getEvents().size());
    	System.out.println(events.getEvents().get(0).getName());
    	System.out.println(events.getEvents().get(1).getName());
    	System.out.println("!---------------");
    	
    	Event event = parseJsonToObject.parseJsonToFirstLiveEvent(jsonObject);
    	System.out.println(event.getEventId());
    	
    	jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/sportsbook/event/"+event.getEventId());
    	
    	Markets markets = parseJsonToObject.parseJsonToMarketsArray(jsonObject, event.getEventId());
    	for (int i = 0; i < markets.getMarkets().size(); i++) {
    		System.out.println(markets.getMarkets().get(i).getMarketId());
		}
    	jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/sportsbook/market/"+markets.getMarkets().get(0).getMarketId());
    	
    	Outcomes outcomes = parseJsonToObject.parseJsonToOutcomesArray(jsonObject, markets.getMarkets().get(0).getMarketId());
    	for (int i = 0; i < outcomes.getOutcomes().size(); i++) {
    		System.out.println(outcomes.getOutcomes().get(i).getName());
		}
    	
//    	WebSocketConnection webSocketConnection = new WebSocketConnection();
//    	webSocketConnection.connectToWebSocket();
    }
}
