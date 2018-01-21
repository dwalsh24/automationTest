package com.skybet.automation.framework.api;

import java.io.IOException;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.skybet.automation.framework.json.Serialiser;

public class ApiConnection {

	public JsonObject getJsonResponseFromAPI(HttpClient httpClient, String uri) {
		Serialiser serialiser = new Serialiser();
		HttpGet getRequest = new HttpGet(uri);
		HttpResponse response;
		String apiOutput = null;
		try {
			response = httpClient.execute(getRequest);
			HttpEntity httpEntity = response.getEntity();

			apiOutput = EntityUtils.toString(httpEntity);
			System.out.println("Response from API at "+ uri + " : " + apiOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		getRequest.releaseConnection();
		return serialiser.serializeStringToJSONObject(apiOutput);
	}
}
