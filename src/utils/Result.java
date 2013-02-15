package utils;


/**
 * @author Vanc Levstik
 * 
 * Result object
 *
 */
public class Result {

	private String id;
	private String name;
	private String type;
	private String score;
	private String match;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
}
