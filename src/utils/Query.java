package utils;

import java.util.List;


/**
 * @author Vanc Levstik
 * 
 *Query object
 */
public class Query {

private String query;
private String limit;
private String type;
private String type_strict;
private List<Property> properties;

public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public String getLimit() {
	return limit;
}
public void setLimit(String limit) {
	this.limit = limit;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getType_strict() {
	return type_strict;
}
public void setType_strict(String type_strict) {
	this.type_strict = type_strict;
}
public List<Property> getProperties() {
	return properties;
}
public void setProperties(List<Property> properties) {
	this.properties = properties;
}


}

class Property {
	
	private String p;
	private String pid;
	private String[] v;
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String[] getV() {
		return v;
	}
	public void setV(String[] v) {
		this.v = v;
	}
	
}
