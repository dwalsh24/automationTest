package com.skybet.automation.framework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skybet.automation.framework.api.WebSocketConnection;
import com.skybet.automation.framework.json.ParseJsonToObject;
import com.skybet.automation.framework.json.Serialiser;

public class WebSocketTestSet {

	/*
	 * Basic message templates:
	 * subscribe to all market activity - {\"type\": \"subscribe\", \"keys\": [\"m.*\"]}
	 * subscribe to all outcome activity - {\"type\": \"subscribe\", \"keys\": [\"o.*\"]}
	 * 
	 * uri on desktop: ws://localhost:8889
	 * uri on macbook: http://192.168.99.100:8889
	 */
	
	static Gson gson;
	static WebSocketConnection webSocketConnection;
	static ParseJsonToObject parseJsonToObject;
	static Serialiser serialiser = new Serialiser();
	String uri = "ws://localhost:8889";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gson = new Gson();
		webSocketConnection = new WebSocketConnection();
		parseJsonToObject = new ParseJsonToObject(gson);
		serialiser = new Serialiser();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tc_01_AssertUserCanReceiveMarketSubscriptionFromWebSocketServer() {
		ArrayList<String> jsonResponses = webSocketConnection.getUpdatesFromWebSocket(uri, "{\"type\": \"subscribe\", \"keys\": [\"m.*\"]}", 10000);
		ArrayList<JsonObject> jsonObjects = serialiser.serializeStringArrayListToJsonObjectArrayList(jsonResponses);
		
		assertTrue(jsonObjects.get(0) != null);
	}

}
