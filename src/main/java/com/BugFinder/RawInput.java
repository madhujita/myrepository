package com.BugFinder;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
"query",
"input_type"
})
public class RawInput {

@JsonProperty("query")
private String query;
@JsonProperty("input_type")
private Integer inputType;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public RawInput() {
}

/**
* 
* @param query
* @param inputType
*/
public RawInput(String query, Integer inputType) {
super();
this.query = query;
this.inputType = inputType;
}

@JsonProperty("query")
public String getQuery() {
return query;
}

@JsonProperty("query")
public void setQuery(String query) {
this.query = query;
}

@JsonProperty("input_type")
public Integer getInputType() {
return inputType;
}

@JsonProperty("input_type")
public void setInputType(Integer inputType) {
this.inputType = inputType;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}