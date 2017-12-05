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
"raw_inputs",
"intent",
"arguments"
})
public class Input {

@JsonProperty("raw_inputs")
private List<RawInput> rawInputs = null;
@JsonProperty("intent")
private String intent;
@JsonProperty("arguments")
private List<Argument> arguments = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Input() {
}

/**
* 
* @param rawInputs
* @param arguments
* @param intent
*/
public Input(List<RawInput> rawInputs, String intent, List<Argument> arguments) {
super();
this.rawInputs = rawInputs;
this.intent = intent;
this.arguments = arguments;
}

@JsonProperty("raw_inputs")
public List<RawInput> getRawInputs() {
return rawInputs;
}

@JsonProperty("raw_inputs")
public void setRawInputs(List<RawInput> rawInputs) {
this.rawInputs = rawInputs;
}

@JsonProperty("intent")
public String getIntent() {
return intent;
}

@JsonProperty("intent")
public void setIntent(String intent) {
this.intent = intent;
}

@JsonProperty("arguments")
public List<Argument> getArguments() {
return arguments;
}

@JsonProperty("arguments")
public void setArguments(List<Argument> arguments) {
this.arguments = arguments;
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