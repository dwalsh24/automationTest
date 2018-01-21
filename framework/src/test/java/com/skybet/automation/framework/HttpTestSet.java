package com.skybet.automation.framework;

import static org.junit.Assert.*;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.*;
import org.junit.runners.MethodSorters;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.api.*;
import com.skybet.automation.framework.json.ParseJsonToObject;
import com.skybet.automation.framework.objects.events.*;
import com.skybet.automation.framework.objects.markets.Market;
import com.skybet.automation.framework.objects.markets.Markets;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HttpTestSet {
	
	/*
	 * uri on desktop: http://localhost:8888
	 * uri on macbook: http://192.168.99.100:8888
	 */
	
	static Gson gson;
	static HttpClientFactory httpClientFactory;
	static CloseableHttpClient httpClient;
	static ApiConnection apiConnection;
	static ParseJsonToObject parseJsonToObject;
	static String apiUri = "http://192.168.99.100:8888";
	
	JsonObject liveFootballJson;
	Events liveFootballEvents;
	
	@BeforeClass
	public static void setUpClass() throws Exception{
		gson = new Gson();
		apiConnection = new ApiConnection();
		httpClientFactory = new HttpClientFactory();
		parseJsonToObject = new ParseJsonToObject(gson);
		httpClient = httpClientFactory.createHttpClient();
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception{
		httpClient.close();
	}
	
	@Before
	public void setUp() throws Exception {
		liveFootballJson = apiConnection.getJsonResponseFromAPI(httpClient, apiUri + "/football/live");
		liveFootballEvents = parseJsonToObject.parseJsonToLiveEventsArray(liveFootballJson);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tc_01_AssertEventNameOfFirstEvenIsNotNull() {
		Event event = liveFootballEvents.getEvents().get(0);
		assertNotNull(event.getName());
	}
	
	@Test
	public void tc_02_AssertEventNameOfFirstEventIsNotEmpty() {
		Event event = liveFootballEvents.getEvents().get(0);
		assertTrue(!event.getName().equals(""));
	}
	
	@Test
	public void tc_03_AssertEventIdOfFirstEventIsNotZero() {
		Event event = liveFootballEvents.getEvents().get(0);
		assertTrue(event.getEventId() != 0);
	}
	
	@Test
	public void tc_04_AssertEventHasLinkedMarkets(){
		JsonObject eventJson = apiConnection.getJsonResponseFromAPI(httpClient, apiUri + "/sportsbook/event/" + liveFootballEvents.getEvents().get(0).getEventId());
		Markets markets = parseJsonToObject.parseJsonToMarketsArray(eventJson, liveFootballEvents.getEvents().get(0).getEventId());
		Market market = null;
		for(int i = 0; i < markets.getMarkets().size(); i++){
			if(markets.getMarkets().get(i).getEventId() == liveFootballEvents.getEvents().get(0).getEventId()){
				market = markets.getMarkets().get(i);
			}
		}
		assertNotNull(market);
	}

}
