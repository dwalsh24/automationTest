package com.skybet.automation.framework.json;

import java.util.ArrayList;

import com.google.gson.*;

public class Serialiser {

	public JsonObject serializeStringToJSONObject(String input){
		Gson gson = new Gson();
		
		JsonObject jsonObject = gson.fromJson(input, JsonObject.class);
		return jsonObject;
	}
	
	public ArrayList<JsonObject> serializeStringArrayListToJsonObjectArrayList(ArrayList<String> input){
		ArrayList<JsonObject> jsonObjects = new ArrayList<JsonObject>();
		Gson gson = new Gson();
		JsonObject jsonObject;
		
		for(String s: input){
			if(s.startsWith("{")){
				jsonObject = gson.fromJson(s, JsonObject.class);
				jsonObjects.add(jsonObject);
			}
		}
		return jsonObjects;
	}
}
