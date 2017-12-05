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
"lang",
"status",
"timestamp",
"sessionId",
"result",
"id",
"originalRequest"
})
public class Example {

@JsonProperty("lang")
private String lang;
@JsonProperty("status")
private Status status;
@JsonProperty("timestamp")
private String timestamp;
@JsonProperty("sessionId")
private String sessionId;
@JsonProperty("result")
 Result result;
@JsonProperty("id")
private String id;
@JsonProperty("originalRequest")
private OriginalRequest originalRequest;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Example() {
}

/**
* 
* @param id
* @param timestamp
* @param result
* @param sessionId
* @param status
* @param originalRequest
* @param lang
*/
public Example(String lang, Status status, String timestamp, String sessionId, Result result, String id, OriginalRequest originalRequest) {
super();
this.lang = lang;
this.status = status;
this.timestamp = timestamp;
this.sessionId = sessionId;
this.result = result;
this.id = id;
this.originalRequest = originalRequest;
}

@JsonProperty("lang")
public String getLang() {
return lang;
}

@JsonProperty("lang")
public void setLang(String lang) {
this.lang = lang;
}

@JsonProperty("status")
public Status getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(Status status) {
this.status = status;
}

@JsonProperty("timestamp")
public String getTimestamp() {
return timestamp;
}

@JsonProperty("timestamp")
public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

@JsonProperty("sessionId")
public String getSessionId() {
return sessionId;
}

@JsonProperty("sessionId")
public void setSessionId(String sessionId) {
this.sessionId = sessionId;
}

@JsonProperty("result")
public Result getResult() {
return result;
}

@JsonProperty("result")
public void setResult(Result result) {
this.result = result;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("originalRequest")
public OriginalRequest getOriginalRequest() {
return originalRequest;
}

@JsonProperty("originalRequest")
public void setOriginalRequest(OriginalRequest originalRequest) {
this.originalRequest = originalRequest;
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