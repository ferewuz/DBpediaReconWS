package recon;

import java.util.ArrayList;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;


/**
 * @author Vanc Levstik
 * 
 * Class for reconciling data with DBpedia
 *
 */
public class ReconHandler {
	
	public static ArrayList<String> makeQuery(String name) {
		String queryString = "SELECT ?p ?o  WHERE { <http://dbpedia.org/resource/" +  name + "> ?p ?o .}" ;
		Query query = QueryFactory.create(queryString) ;
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
	
		try {
		  ResultSet results = qexec.execSelect() ;
		  ArrayList<String> resultsStr= new ArrayList<String>();
		  for ( ; results.hasNext() ; )
		  {
		    QuerySolution soln = results.nextSolution() ;
		    RDFNode x = soln.get("o") ;       // Get a result variable by name.
		    //Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
		    //Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
		    resultsStr.add(x.toString());
		  }
		  return resultsStr;
		}  catch(Exception e) {
			e.printStackTrace();
		}
		qexec.close() ;
		
		return null;
		
		}
}