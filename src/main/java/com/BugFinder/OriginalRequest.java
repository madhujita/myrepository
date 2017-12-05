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
"source",
"data"
})
public class OriginalRequest {

@JsonProperty("source")
private String source;
@JsonProperty("data")
private Data data;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public OriginalRequest() {
}

/**
* 
* @param source
* @param data
*/
public OriginalRequest(String source, Data data) {
super();
this.source = source;
this.data = data;
}

@JsonProperty("source")
public String getSource() {
return source;
}

@JsonProperty("source")
public void setSource(String source) {
this.source = source;
}

@JsonProperty("data")
public Data getData() {
return data;
}

@JsonProperty("data")
public void setData(Data data) {
this.data = data;
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