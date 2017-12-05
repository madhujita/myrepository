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
"speech",
"type"
})
public class Message {

@JsonProperty("speech")
private String speech;
@JsonProperty("type")
private Integer type;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Message() {
}

/**
* 
* @param speech
* @param type
*/
public Message(String speech, Integer type) {
super();
this.speech = speech;
this.type = type;
}

@JsonProperty("speech")
public String getSpeech() {
return speech;
}

@JsonProperty("speech")
public void setSpeech(String speech) {
this.speech = speech;
}

@JsonProperty("type")
public Integer getType() {
return type;
}

@JsonProperty("type")
public void setType(Integer type) {
this.type = type;
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