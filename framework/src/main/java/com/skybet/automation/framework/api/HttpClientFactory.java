package com.skybet.automation.framework.api;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientFactory {

	public HttpClient httpClientFactory(){
		return HttpClients.createDefault();
	}
}
