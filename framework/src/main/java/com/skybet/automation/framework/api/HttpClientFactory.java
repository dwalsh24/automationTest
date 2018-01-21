package com.skybet.automation.framework.api;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientFactory {

	public CloseableHttpClient createHttpClient(){
		return HttpClients.createDefault();
	}
}
