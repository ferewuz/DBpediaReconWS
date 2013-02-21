package recon;

import java.util.ArrayList;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.vocabulary.RDF;


/**
 * @author Vanc Levstik
 * 
 * Class for reconciling data with DBpedia
 *
 */
public class ReconHandler {
	
	//main method for reconciling and getting result
	public static utils.Result makeQuery(utils.Query queryO) {
		//TODO For now it filters just by first name of query, making query bit faster but still getting results
		String queryString = "SELECT ?s  WHERE { ?s <"+RDF.type+"> " + queryO.getType()+" . FILTER regex(?s, \""+queryO.getQuery().split(" ")[0]+"\", \"i\") }" ;
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString) ;
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
	
		try {
		  ResultSet results = qexec.execSelect() ;
		  ArrayList<utils.Result> resultsAr= new ArrayList<utils.Result>();
		  for ( ; results.hasNext() ; )
		  {
		    QuerySolution soln = results.nextSolution() ;
		    RDFNode nodeRes = soln.get("s") ;       // Get a result variable by name.
		    //Resource r = soln.getResource("VarR") ; // Get a result variable - must be a resource
		    //Literal l = soln.getLiteral("VarL") ;   // Get a result variable - must be a literal
		    utils.Result tempRes = new utils.Result();
		    tempRes.setId(nodeRes.toString());
		    resultsAr.add(tempRes);
		  }
		  
		  return getAdditionalData(MatchingFinder.findMatches(resultsAr, queryO.getQuery()));
		}  catch(Exception e) {
			e.printStackTrace();
		}
		qexec.close() ;
		
		return null;
		
		}
	
	//method for getting full name and maybe later additional data
	private static utils.Result getAdditionalData(utils.Result res) {
		String queryString = "SELECT ?o  WHERE { <"+res.getId()+"> <http://xmlns.com/foaf/0.1/name> ?o }" ;
		System.out.println(queryString);
		Query query = QueryFactory.create(queryString) ;
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
	
		try {
		  ResultSet results = qexec.execSelect() ;
		  ArrayList<utils.Result> resultsAr= new ArrayList<utils.Result>();
		  for ( ; results.hasNext() ; )
		  {
		    QuerySolution soln = results.nextSolution() ;
		    RDFNode nodeRes = soln.get("o") ;       // Get a result variable by name.		    
		    res.setName(nodeRes.toString());
		    return res;
		  }		
		}  catch(Exception e) {
			e.printStackTrace();
		}
		qexec.close() ;
		
		return null;
	}
}