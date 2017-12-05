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
"errorType",
"code"
})
public class Status {

@JsonProperty("errorType")
private String errorType;
@JsonProperty("code")
private Integer code;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Status() {
}

/**
* 
* @param errorType
* @param code
*/
public Status(String errorType, Integer code) {
super();
this.errorType = errorType;
this.code = code;
}

@JsonProperty("errorType")
public String getErrorType() {
return errorType;
}

@JsonProperty("errorType")
public void setErrorType(String errorType) {
this.errorType = errorType;
}

@JsonProperty("code")
public Integer getCode() {
return code;
}

@JsonProperty("code")
public void setCode(Integer code) {
this.code = code;
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