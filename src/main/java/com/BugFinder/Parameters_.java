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
"type",
"type.original",
"area.original",
"area"
})
public class Parameters_ {

@JsonProperty("type")
 String type;
@JsonProperty("type.original")
private String typeOriginal;
@JsonProperty("area.original")
private String areaOriginal;
@JsonProperty("area")
private String area;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Parameters_() {
}

/**
* 
* @param area
* @param areaOriginal
* @param typeOriginal
* @param type
*/

public Parameters_(Parameters_ p){
	this.type = p.type;
	this.typeOriginal = p.typeOriginal;
	this.areaOriginal = p.areaOriginal;
	this.area = p.area;
}

public Parameters_(String type, String typeOriginal, String areaOriginal, String area) {
super();
this.type = type;
this.typeOriginal = typeOriginal;
this.areaOriginal = areaOriginal;
this.area = area;
}

@JsonProperty("type")
public String gettype() {
return type;
}

@JsonProperty("type")
public void settype(String type) {
this.type = type;
}

@JsonProperty("type.original")
public String gettypeOriginal() {
return typeOriginal;
}

@JsonProperty("type.original")
public void settypeOriginal(String typeOriginal) {
this.typeOriginal = typeOriginal;
}

@JsonProperty("area.original")
public String getareaOriginal() {
return areaOriginal;
}

@JsonProperty("area.original")
public void setareaOriginal(String areaOriginal) {
this.areaOriginal = areaOriginal;
}

@JsonProperty("area")
public String getarea() {
return area;
}

@JsonProperty("area")
public void setarea(String area) {
this.area = area;
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