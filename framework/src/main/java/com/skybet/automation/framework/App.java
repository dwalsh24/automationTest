package com.skybet.automation.framework;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.websocket.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.skybet.automation.framework.api.ApiConnection;
import com.skybet.automation.framework.api.HttpClientFactory;
import com.skybet.automation.framework.api.WebSocketConnection;
import com.skybet.automation.framework.json.ParseJsonToObject;
import com.skybet.automation.framework.objects.events.Event;
import com.skybet.automation.framework.objects.events.Events;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
    	HttpClientFactory httpClientFactory = new HttpClientFactory();
    	HttpClient httpClient = httpClientFactory.httpClientFactory();
    	ApiConnection apiConnection = new ApiConnection();
    	JsonObject jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/football/live");
    	
//    	System.out.println(jsonObject);
    	ParseJsonToObject parseJsonToObject = new ParseJsonToObject();
    	Events events = parseJsonToObject.parseJsonToLiveEventsArray(jsonObject);
    	
    	System.out.println(events.getEvents().length);
    	System.out.println(events.getEvents()[0].getName());
    	System.out.println(events.getEvents()[1].getName());
    	System.out.println("!---------------");
    	
    	Event event = parseJsonToObject.parseJsonToFirstLiveEvent(jsonObject);
    	System.out.println(event.getEventId());
    	
    	jsonObject = apiConnection.getJsonResponseFromAPI(httpClient, "http://localhost:8888/sportsbook/event/"+event.getEventId());
    	
    	
    	
//    	WebSocketConnection webSocketConnection = new WebSocketConnection();
//    	webSocketConnection.connectToWebSocket();
    }
}
