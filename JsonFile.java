package me.rythem.features.files.json;

import java.io.*;
import java.util.*;
import com.google.gson.*;

public class JsonFile {

	private List<JsonItem> objects = new ArrayList<JsonItem>();
	private List<JsonHeader> headers = new ArrayList<JsonHeader>();
	
	private String name, header, path;
	private File file;
	
    /**
     * Creates a new JSON file
     * @param name The name of the file
     * @param header The header of the objects
     * @param path The path to the file
     * @throws IOException 
     */
	public JsonFile(String name, String header, String path) throws IOException {
		this.name = name;
		this.header = header;
		this.path = path;
		
		this.file = new File(path + "/" + name + ".json");
		
		if(!this.file.exists()) {
			this.file.createNewFile();
		}
	}
	
    /**
     * Saves the contents of the JSON file
     * @throws IOException 
     */
	public void save(String name, boolean pretty) throws IOException {

		JsonObject jsonObject = new JsonObject();
		for(JsonHeader header : getHeaders())
			jsonObject.addProperty(header.getName(), header.getData());
		
		JsonObject objects = new JsonObject();

		for (JsonItem object : getObjects())
			objects.add(object.getName(), object.getData());

		jsonObject.add(header, objects);

		String content = "";
		
		if(pretty) {
			content = new GsonBuilder().setPrettyPrinting().create().toJson(jsonObject);
		}else {
			content = new GsonBuilder().create().toJson(jsonObject);
		}
		
        FileWriter writer = new FileWriter(getFile());
        writer.write(content);
        writer.close();
	}
	
    /**
     * Adds a new Json item
     */
	public void addItem(JsonItem item) {
		this.objects.add(item);
	}
	
    /**
     * Returns a JsonObject containing the JsonFile data
     * @return 
     * @throws FileNotFoundException 
     */
	public JsonObject load() throws FileNotFoundException {
        FileReader reader = new FileReader(getFile());
        JsonParser parser = new JsonParser();
        return (JsonObject) parser.parse(reader);
	}
	
    /**
     * Returns a file object of the JSON file
     */
	public File getFile() {
		return this.file;
	}
	
    /**
     * Returns a string object of the JSON name
     */
	public String getName() {
		return this.name;
	}
	
    /**
     * Returns a string object of the JSON path
     */
	public String getPath() {
		return this.path;
	}
	
    /**
     * Returns a list<JsonItem> of the JSON objects
     */
	public List<JsonItem> getObjects() {
		return this.objects;
	}
	
    /**
     * Returns a list<JsonHeader> of the JSON headers
     */
	public List<JsonHeader> getHeaders() {
		return this.headers;
	}
}
