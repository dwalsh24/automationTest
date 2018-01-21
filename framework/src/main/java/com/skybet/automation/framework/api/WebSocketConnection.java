package com.skybet.automation.framework.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WebSocketConnection {
	
	public ArrayList<String> getUpdatesFromWebSocket(String uri, String sendMessage, int milliseconds) {
		ArrayList<String> responseList = new ArrayList<String>();
		
		try {
			final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(uri));

			clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
				public void handleMessage(String message) {
					if(message.startsWith("{")){
						responseList.add(message);
					}
				}
			});

			clientEndPoint.sendMessage(sendMessage);
			Thread.sleep(milliseconds);
			
		} catch (InterruptedException ex) {
			System.err.println("InterruptedException exception: " + ex.getMessage());
		} catch (URISyntaxException ex) {
			System.err.println("URISyntaxException exception: " + ex.getMessage());
		}
		return responseList;
	}
}
