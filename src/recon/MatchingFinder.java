package recon;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Vanc Levstik
 * 
 * Class for matching and scoring results from queries
 *
 */
public class MatchingFinder {
	
	//TODO simple contains match for now
	public static utils.Result findMatches(ArrayList<utils.Result> result, String query) {
		Iterator<utils.Result> it =result.iterator();
		while(it.hasNext()) {
			utils.Result tempRes = it.next();
			System.out.println(tempRes.getId());
			if(containsStrings(tempRes, query)) {
				tempRes.setScore(1d);
				tempRes.setMatch(true);
				return tempRes;
			}
		}
		return null;
	}
	
	private static boolean containsStrings(utils.Result res, String query) {
		for(String i : query.toLowerCase().split(" ")) {	
			if(!res.getId().toLowerCase().contains(i))
				return false;	
		}
		return true;
	}
}
