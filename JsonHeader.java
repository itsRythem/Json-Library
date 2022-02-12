package me.rythem.features.files.json;

public class JsonHeader {

	private String name, data;
	
	public JsonHeader(String name, String data) {
		this.name = name;
		this.data = data;
	}
	
	public String getName() {
		return name;
	}
	
	
	public String getData() {
		return data;
	}
	
}
