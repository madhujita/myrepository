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
"name",
"parameters",
"lifespan"
})
public class Context {

@JsonProperty("name")
private String name;
@JsonProperty("parameters")
private Parameters_ parameters;
@JsonProperty("lifespan")
private Integer lifespan;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Context() {
}

/**
* 
* @param name
* @param parameters
* @param lifespan
*/
public Context(String name, Parameters_ parameters, Integer lifespan) {
super();
this.name = name;
this.parameters = parameters;
this.lifespan = lifespan;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("parameters")
public Parameters_ getParameters() {
return parameters;
}

@JsonProperty("parameters")
public void setParameters(Parameters_ parameters) {
this.parameters = parameters;
}

@JsonProperty("lifespan")
public Integer getLifespan() {
return lifespan;
}

@JsonProperty("lifespan")
public void setLifespan(Integer lifespan) {
this.lifespan = lifespan;
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