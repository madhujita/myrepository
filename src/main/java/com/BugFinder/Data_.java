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
"<PARAMETER_NAME>"
})
public class Data_ {

@JsonProperty("<PARAMETER_NAME>")
private String pARAMETERNAME;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("<PARAMETER_NAME>")
public String getPARAMETERNAME() {
return pARAMETERNAME;
}

@JsonProperty("<PARAMETER_NAME>")
public void setPARAMETERNAME(String pARAMETERNAME) {
this.pARAMETERNAME = pARAMETERNAME;
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