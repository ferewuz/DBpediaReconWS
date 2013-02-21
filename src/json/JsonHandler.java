package json;

import java.io.IOException;

import utils.Query;
import utils.Result;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * @author Vanc Levstik
 *
 *Class for handling conversions between Java and JSON objects
 *
 */
public class JsonHandler {
	ObjectMapper mapper;
	
	public JsonHandler(){
		mapper= new ObjectMapper();
	}
	
	public  Query jsonToObject(String input) {
		try {
			Query query = mapper.readValue(input, utils.Query.class);
			return query;
		
		} catch (JsonGenerationException e) {
			 
			e.printStackTrace();
			return null;
			
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
			return null;
		} catch (IOException e) {
	 
			e.printStackTrace();
			return null;
		}
	}
	
	public String objectToJson(Result result) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String res = mapper.writeValueAsString(result);
			return res;
		
		} catch (JsonGenerationException e) {
			 
			e.printStackTrace();
			return null;
			
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
			return null;
		} catch (IOException e) {
	 
			e.printStackTrace();
			return null;
		}
	}
}
