package com.BugFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
"messages",
"speech"
})
public class Fulfillment {

@JsonProperty("messages")
private List<Message> messages = null;
@JsonProperty("speech")
private String speech;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Fulfillment() {
}

/**
* 
* @param speech
* @param messages
*/
public Fulfillment(List<Message> messages, String speech) {
super();
this.messages = messages;
this.speech = speech;
}

@JsonProperty("messages")
public List<Message> getMessages() {
return messages;
}

@JsonProperty("messages")
public void setMessages(List<Message> messages) {
this.messages = messages;
}

@JsonProperty("speech")
public String getSpeech() {
return speech;
}

@JsonProperty("speech")
public void setSpeech(String speech) {
this.speech = speech;
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