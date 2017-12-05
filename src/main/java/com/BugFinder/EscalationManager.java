package com.BugFinder;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"esc_name",
"type"
})
public class EscalationManager {

@JsonProperty("esc_name")
private String escName;
@JsonProperty("type")
private String type;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("esc_name")
public String getEscName() {
return escName;
}

@JsonProperty("esc_name")
public void setEscName(String escName) {
this.escName = escName;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
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