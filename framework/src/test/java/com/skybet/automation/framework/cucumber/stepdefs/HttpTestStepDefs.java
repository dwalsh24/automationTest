package com.skybet.automation.framework.cucumber.stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.apache.http.impl.client.CloseableHttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.api.ApiConnection;
import com.skybet.automation.framework.api.HttpClientFactory;
import com.skybet.automation.framework.data.DataReader;
import com.skybet.automation.framework.json.ParseJsonToObject;
import com.skybet.automation.framework.objects.events.Event;
import com.skybet.automation.framework.objects.events.Events;
import com.skybet.automation.framework.objects.markets.Market;
import com.skybet.automation.framework.objects.markets.Markets;
import com.skybet.automation.framework.objects.outcomes.Outcome;
import com.skybet.automation.framework.objects.outcomes.Outcomes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HttpTestStepDefs {

	static Gson gson;
	static HttpClientFactory httpClientFactory;
	static CloseableHttpClient httpClient;
	static ApiConnection apiConnection;
	static ParseJsonToObject parseJsonToObject;
	static String apiUri = "http://192.168.99.100:8888";
	static JsonObject liveFootballJson;
	static Events liveFootballEvents;
	static DataReader dataReader;
	
	static HashMap<String, String> uservariables = new HashMap<String, String>();
	static Event event;
	static Markets markets;
	static Market market;
	static Outcomes outcomes;
	static Outcome outcome;
	
	public HttpTestStepDefs() {
		gson = new Gson();
		apiConnection = new ApiConnection();
		httpClientFactory = new HttpClientFactory();
		parseJsonToObject = new ParseJsonToObject(gson);
		httpClient = httpClientFactory.createHttpClient();
		dataReader = new DataReader();
	}
	
	@Given("user gets live football events")
	public void getLiveFootballEvents() {
		liveFootballJson = apiConnection.getJsonResponseFromAPI(httpClient, apiUri + "/football/live");
		liveFootballEvents = parseJsonToObject.parseJsonToLiveEventsArray(liveFootballJson);
		System.out.println("Retrieved " + liveFootballEvents.getEvents().size() + " football events");
	}
	
	@When("user gets football event \"(.*)\" from live events")
	public void getSingleEventFromLiveFootballEvents(int eventNumber) {
		event = liveFootballEvents.getEvents().get(eventNumber);
		System.out.println("Retrieved event with id: " + event.getEventId());
	}
	
	@Then("user verifies event (eventId|name) = \"(.*)\"")
	public void verifyEventParameterEqualsX(String parameter, String comparison) {
		if(comparison.startsWith("#")) {
			comparison = dataReader.findDataForTestCase(comparison);
		}
		String retreievedParameter = null;
		switch (parameter) {
		case "eventId":
			retreievedParameter = event.getEventId() + "";
			break;
		case "name":
			retreievedParameter = event.getName();
			break;
		default:
			System.out.println("Not impletemented");
			break;
		}
		System.out.println("Verifying " + retreievedParameter + " = " + comparison);
		assertTrue(retreievedParameter.equals(comparison));
	}
	
//	@When("user stores ")
	
	
}
