package webservice;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import json.JsonHandler;

import recon.ReconHandler;
import utils.Query;
	
/**
 * @author Vanc Levstik
 *
 *Class for handling JAX-RS webservice
 */
@Path("/rest")
public class ReconWSResource {
	
	@GET	
	@Path("/reconcile")
	@Produces(MediaType.APPLICATION_JSON)	
	public String getMessage(@QueryParam("query") String q) {

		System.out.println(q);		
		try {
			JsonHandler js = new JsonHandler();
			Query query = js.jsonToObject(q);
			utils.Result result = ReconHandler.makeQuery(query);
			String res = js.objectToJson(result);
			return res;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
		
    }
}