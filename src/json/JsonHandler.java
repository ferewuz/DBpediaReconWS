package json;

import java.io.IOException;

import utils.Query;

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

	public static String makeJson() {
	
		return null;
	}
	
	public static Query jsonToObject(String input) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Query query = mapper.readValue(input, Query.class);
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
}
