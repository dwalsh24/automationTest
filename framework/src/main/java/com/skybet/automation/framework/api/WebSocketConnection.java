package com.skybet.automation.framework.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WebSocketConnection {
	
	public ArrayList<String> getUpdatesFromWebSocket(String sendMessage, int milliseconds) {
		ArrayList<String> responseList = new ArrayList<String>();
		
		try {
			final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://localhost:8889"));

			// add listener
			clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
				public void handleMessage(String message) {
					if(message.startsWith("{")){
						responseList.add(message);
					}
				}
			});

			// send message to websocket
			clientEndPoint.sendMessage(sendMessage);

			// wait 5 seconds for messages from websocket
			Thread.sleep(milliseconds);
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			clientEndPoint.sendMessage("{\"type\": \"subscribe\", \"keys\": [\"m.*\"]}");
//			Thread.sleep(10000);

		} catch (InterruptedException ex) {
			System.err.println("InterruptedException exception: " + ex.getMessage());
		} catch (URISyntaxException ex) {
			System.err.println("URISyntaxException exception: " + ex.getMessage());
		}
		return responseList;
	}
}
