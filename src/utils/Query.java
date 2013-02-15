package utils;


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
private String properties;

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
public String getProperties() {
	return properties;
}
public void setProperties(String properties) {
	this.properties = properties;
}


}
