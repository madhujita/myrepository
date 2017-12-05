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
"inputs",
"user",
"conversation"
})
public class Data {

@JsonProperty("inputs")
private List<Input> inputs = null;
@JsonProperty("user")
private User user;
@JsonProperty("conversation")
private Conversation conversation;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Data() {
}

/**
* 
* @param inputs
* @param conversation
* @param user
*/
public Data(List<Input> inputs, User user, Conversation conversation) {
super();
this.inputs = inputs;
this.user = user;
this.conversation = conversation;
}

@JsonProperty("inputs")
public List<Input> getInputs() {
return inputs;
}

@JsonProperty("inputs")
public void setInputs(List<Input> inputs) {
this.inputs = inputs;
}

@JsonProperty("user")
public User getUser() {
return user;
}

@JsonProperty("user")
public void setUser(User user) {
this.user = user;
}

@JsonProperty("conversation")
public Conversation getConversation() {
return conversation;
}

@JsonProperty("conversation")
public void setConversation(Conversation conversation) {
this.conversation = conversation;
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