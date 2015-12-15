package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;


public class JSONSerializer implements ObjectSerializer{
	
	private JsonFactory jsonFactory = new JsonFactory();
	private static final JSONSerializer onlyOne = new JSONSerializer();

	public static JSONSerializer get(){
		return  onlyOne;
	}
	
	public String writeObject(Object o, JsonConfigSetter jsonConfigSetter) throws Exception {
		StringWriter sw = new StringWriter();
		//FileWriter file = new FileWriter()
		JsonGenerator generator = jsonFactory.createJsonGenerator(sw);
		generator.useDefaultPrettyPrinter();
		ObjectMapper objectMapper = new ObjectMapper();
		if (jsonConfigSetter != null) 
			jsonConfigSetter.go(objectMapper);
		objectMapper.writeValue(generator, o);
		return sw.toString();	
	}
	
	public String writeObject(Object o) throws Exception{
		return writeObject(o, null);
	}
	
	public String streamWriteObject(Object o, JsonConfigSetter jsonConfigSetter) throws Exception {
		File fout = File.createTempFile(UUID.randomUUID().toString(), ".txt", new File(System.getProperty("java.io.tmpdir")));
		fout.deleteOnExit();
		FileWriter fw = new FileWriter(fout);
		JsonGenerator generator = jsonFactory.createJsonGenerator(fw);
		generator.useDefaultPrettyPrinter();
		ObjectMapper objectMapper = new ObjectMapper();
		if (jsonConfigSetter != null) 
			jsonConfigSetter.go(objectMapper);
		objectMapper.writeValue(generator, o);
		String jsonString = FileUtils.readFileToString(fout);
		FileUtils.deleteQuietly(fout);
		return jsonString;
	}
	
	public String streamWriteObject(Object o) throws Exception{
		return streamWriteObject(o, null);
	}
	

}
