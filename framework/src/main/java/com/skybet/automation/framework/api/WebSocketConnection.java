package com.skybet.automation.framework.api;

import java.net.URI;
import java.net.URISyntaxException;

public class WebSocketConnection {
	public void connectToWebSocket() {

		try {
			final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("ws://localhost:8889"));

			// add listener
			clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
				public void handleMessage(String message) {
					System.out.println(message);
				}
			});

			// send message to websocket
//			clientEndPoint.sendMessage("{\"type\": \"subscribe\", \"keys\": [\"e.*\"]}");
			clientEndPoint.sendMessage("{\"type\": \"subscribe\", \"keys\": [\"o.*\"]}");
//			clientEndPoint.sendMessage("{\"type\": \"subscribe\", \"keys\": [\"m.*\"]}");

			// wait 5 seconds for messages from websocket
			Thread.sleep(15000);

		} catch (InterruptedException ex) {
			System.err.println("InterruptedException exception: " + ex.getMessage());
		} catch (URISyntaxException ex) {
			System.err.println("URISyntaxException exception: " + ex.getMessage());
		}
	}
}
