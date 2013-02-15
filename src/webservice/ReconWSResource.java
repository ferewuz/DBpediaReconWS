package webservice;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import recon.ReconHandler;
	
/**
 * @author Vanc Levstik
 *
 *Class for handling JAX-RS webservice
 */
@Path("/helloworld")
public class ReconWSResource {
	@Path("{name}")
	@GET
    @Produces(MediaType.APPLICATION_JSON )
    public String getMessage(@PathParam("name") String name) {
        ArrayList<String> result = ReconHandler.makeQuery(name);
        String resString="";
        Iterator<String> it= result.iterator();
        while(it.hasNext()) {
        	resString = resString + "\n" + it.next();
        }
        return resString;
    }
}