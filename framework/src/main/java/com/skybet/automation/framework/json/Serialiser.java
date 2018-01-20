package com.skybet.automation.framework.json;

import com.google.gson.*;

public class Serialiser {

	public JsonObject serializeStringToJSONObject(String input){
		Gson gson = new Gson();
		
		JsonObject jsonObject = gson.fromJson(input, JsonObject.class);
		return jsonObject;
	}
}
