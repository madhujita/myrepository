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
"text",
"attachments"
})
public class Slack {

@JsonProperty("text")
private String text;
@JsonProperty("attachments")
private List<Object> attachments = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("text")
public String getText() {
return text;
}

@JsonProperty("text")
public void setText(String text) {
this.text = text;
}

@JsonProperty("attachments")
public List<Object> getAttachments() {
return attachments;
}

@JsonProperty("attachments")
public void setAttachments(List<Object> attachments) {
this.attachments = attachments;
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