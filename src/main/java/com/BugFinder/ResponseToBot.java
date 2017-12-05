package com.BugFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"speech",
"displayText",
"data",
"contextOut",
"source",
"followupEvent"
})
public class ResponseToBot {

@JsonProperty("speech")
private String speech;
@JsonProperty("displayText")
private String displayText;
@JsonProperty("data")
private Data data;
@JsonProperty("contextOut")
private List<Object> contextOut = null;
@JsonProperty("source")
private String source;
@JsonProperty("followupEvent")
private FollowupEvent followupEvent;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("speech")
public String getSpeech() {
return speech;
}

@JsonProperty("speech")
public void setSpeech(String speech) {
this.speech = speech;
}

@JsonProperty("displayText")
public String getDisplayText() {
return displayText;
}

@JsonProperty("displayText")
public void setDisplayText(String displayText) {
this.displayText = displayText;
}

@JsonProperty("data")
public Data getData() {
return data;
}

@JsonProperty("data")
public void setData(Data data) {
this.data = data;
}

@JsonProperty("contextOut")
public List<Object> getContextOut() {
return contextOut;
}

@JsonProperty("contextOut")
public void setContextOut(List<Object> contextOut) {
this.contextOut = contextOut;
}

@JsonProperty("source")
public String getSource() {
return source;
}

@JsonProperty("source")
public void setSource(String source) {
this.source = source;
}

@JsonProperty("followupEvent")
public FollowupEvent getFollowupEvent() {
return followupEvent;
}

@JsonProperty("followupEvent")
public void setFollowupEvent(FollowupEvent followupEvent) {
this.followupEvent = followupEvent;
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