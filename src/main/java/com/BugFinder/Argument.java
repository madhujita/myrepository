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
"text_value",
"raw_text",
"name"
})
public class Argument {

@JsonProperty("text_value")
private String textValue;
@JsonProperty("raw_text")
private String rawText;
@JsonProperty("name")
private String name;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Argument() {
}

/**
* 
* @param rawText
* @param name
* @param textValue
*/
public Argument(String textValue, String rawText, String name) {
super();
this.textValue = textValue;
this.rawText = rawText;
this.name = name;
}

@JsonProperty("text_value")
public String getTextValue() {
return textValue;
}

@JsonProperty("text_value")
public void setTextValue(String textValue) {
this.textValue = textValue;
}

@JsonProperty("raw_text")
public String getRawText() {
return rawText;
}

@JsonProperty("raw_text")
public void setRawText(String rawText) {
this.rawText = rawText;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
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