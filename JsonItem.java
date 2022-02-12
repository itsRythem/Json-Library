package me.rythem.features.files.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonItem {

	private String name;
	private JsonObject data;
	
	public JsonItem(String name) {
		this.name = name;
	}

	public JsonObject getData() {
		return data;
	}
	
	public void setData(JsonObject object) {
		data = object;
	}

	public String getName() {
		return name;
	}
	
}
