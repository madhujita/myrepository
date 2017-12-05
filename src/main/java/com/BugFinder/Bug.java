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
"assigned_to",
"cases",
"category",
"category_id",
"cf_branch",
"cf_build",
"cf_change",
"cf_corrective_action",
"cf_customer_root_cause",
"cf_documentation_details",
"cf_escalation",
"cf_feature_details",
"cf_other_details",
"cf_overall_update",
"cf_process_details",
"cf_rcca_done",
"cf_rcca_req",
"cf_reported_by",
"cf_test_details",
"component",
"component_id",
"created_ts",
"delta_ts",
"duplicate_of",
"escalation_managers",
"external_severity",
"found_in_phase",
"found_in_product",
"found_in_version",
"id",
"keywords",
"needinfo",
"priority",
"product",
"product_id",
"reporter",
"resolution",
"severity",
"status",
"summary"
})
public class Bug {

@JsonProperty("assigned_to")
private String assignedTo;
@JsonProperty("cases")
private String cases;
@JsonProperty("category")
private String category;
@JsonProperty("category_id")
private Integer categoryId;
@JsonProperty("cf_branch")
private String cfBranch;
@JsonProperty("cf_build")
private Integer cfBuild;
@JsonProperty("cf_change")
private String cfChange;
@JsonProperty("cf_corrective_action")
private String cfCorrectiveAction;
@JsonProperty("cf_customer_root_cause")
private String cfCustomerRootCause;
@JsonProperty("cf_documentation_details")
private Object cfDocumentationDetails;
@JsonProperty("cf_escalation")
private String cfEscalation;
@JsonProperty("cf_feature_details")
private Object cfFeatureDetails;
@JsonProperty("cf_other_details")
private Object cfOtherDetails;
@JsonProperty("cf_overall_update")
private String cfOverallUpdate;
@JsonProperty("cf_process_details")
private String cfProcessDetails;
@JsonProperty("cf_rcca_done")
private Integer cfRccaDone;
@JsonProperty("cf_rcca_req")
private Integer cfRccaReq;
@JsonProperty("cf_reported_by")
private String cfReportedBy;
@JsonProperty("cf_test_details")
private String cfTestDetails;
@JsonProperty("component")
private String component;
@JsonProperty("component_id")
private Integer componentId;
@JsonProperty("created_ts")
private String createdTs;
@JsonProperty("delta_ts")
private String deltaTs;
@JsonProperty("duplicate_of")
private Integer duplicateOf;
@JsonProperty("escalation_managers")
private List<EscalationManager> escalationManagers = null;
@JsonProperty("external_severity")
private String externalSeverity;
@JsonProperty("found_in_phase")
private String foundInPhase;
@JsonProperty("found_in_product")
private String foundInProduct;
@JsonProperty("found_in_version")
private String foundInVersion;
@JsonProperty("id")
private Integer id;
@JsonProperty("keywords")
private String keywords;
@JsonProperty("needinfo")
private String needinfo;
@JsonProperty("priority")
private String priority;
@JsonProperty("product")
private String product;
@JsonProperty("product_id")
private Integer productId;
@JsonProperty("reporter")
private String reporter;
@JsonProperty("resolution")
private String resolution;
@JsonProperty("severity")
private String severity;
@JsonProperty("status")
private String status;
@JsonProperty("summary")
private String summary;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("assigned_to")
public String getAssignedTo() {
return assignedTo;
}

@JsonProperty("assigned_to")
public void setAssignedTo(String assignedTo) {
this.assignedTo = assignedTo;
}

@JsonProperty("cases")
public String getCases() {
return cases;
}

@JsonProperty("cases")
public void setCases(String cases) {
this.cases = cases;
}

@JsonProperty("category")
public String getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(String category) {
this.category = category;
}

@JsonProperty("category_id")
public Integer getCategoryId() {
return categoryId;
}

@JsonProperty("category_id")
public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}

@JsonProperty("cf_branch")
public String getCfBranch() {
return cfBranch;
}

@JsonProperty("cf_branch")
public void setCfBranch(String cfBranch) {
this.cfBranch = cfBranch;
}

@JsonProperty("cf_build")
public Integer getCfBuild() {
return cfBuild;
}

@JsonProperty("cf_build")
public void setCfBuild(Integer cfBuild) {
this.cfBuild = cfBuild;
}

@JsonProperty("cf_change")
public String getCfChange() {
return cfChange;
}

@JsonProperty("cf_change")
public void setCfChange(String cfChange) {
this.cfChange = cfChange;
}

@JsonProperty("cf_corrective_action")
public String getCfCorrectiveAction() {
return cfCorrectiveAction;
}

@JsonProperty("cf_corrective_action")
public void setCfCorrectiveAction(String cfCorrectiveAction) {
this.cfCorrectiveAction = cfCorrectiveAction;
}

@JsonProperty("cf_customer_root_cause")
public String getCfCustomerRootCause() {
return cfCustomerRootCause;
}

@JsonProperty("cf_customer_root_cause")
public void setCfCustomerRootCause(String cfCustomerRootCause) {
this.cfCustomerRootCause = cfCustomerRootCause;
}

@JsonProperty("cf_documentation_details")
public Object getCfDocumentationDetails() {
return cfDocumentationDetails;
}

@JsonProperty("cf_documentation_details")
public void setCfDocumentationDetails(Object cfDocumentationDetails) {
this.cfDocumentationDetails = cfDocumentationDetails;
}

@JsonProperty("cf_escalation")
public String getCfEscalation() {
return cfEscalation;
}

@JsonProperty("cf_escalation")
public void setCfEscalation(String cfEscalation) {
this.cfEscalation = cfEscalation;
}

@JsonProperty("cf_feature_details")
public Object getCfFeatureDetails() {
return cfFeatureDetails;
}

@JsonProperty("cf_feature_details")
public void setCfFeatureDetails(Object cfFeatureDetails) {
this.cfFeatureDetails = cfFeatureDetails;
}

@JsonProperty("cf_other_details")
public Object getCfOtherDetails() {
return cfOtherDetails;
}

@JsonProperty("cf_other_details")
public void setCfOtherDetails(Object cfOtherDetails) {
this.cfOtherDetails = cfOtherDetails;
}

@JsonProperty("cf_overall_update")
public String getCfOverallUpdate() {
return cfOverallUpdate;
}

@JsonProperty("cf_overall_update")
public void setCfOverallUpdate(String cfOverallUpdate) {
this.cfOverallUpdate = cfOverallUpdate;
}

@JsonProperty("cf_process_details")
public String getCfProcessDetails() {
return cfProcessDetails;
}

@JsonProperty("cf_process_details")
public void setCfProcessDetails(String cfProcessDetails) {
this.cfProcessDetails = cfProcessDetails;
}

@JsonProperty("cf_rcca_done")
public Integer getCfRccaDone() {
return cfRccaDone;
}

@JsonProperty("cf_rcca_done")
public void setCfRccaDone(Integer cfRccaDone) {
this.cfRccaDone = cfRccaDone;
}

@JsonProperty("cf_rcca_req")
public Integer getCfRccaReq() {
return cfRccaReq;
}

@JsonProperty("cf_rcca_req")
public void setCfRccaReq(Integer cfRccaReq) {
this.cfRccaReq = cfRccaReq;
}

@JsonProperty("cf_reported_by")
public String getCfReportedBy() {
return cfReportedBy;
}

@JsonProperty("cf_reported_by")
public void setCfReportedBy(String cfReportedBy) {
this.cfReportedBy = cfReportedBy;
}

@JsonProperty("cf_test_details")
public String getCfTestDetails() {
return cfTestDetails;
}

@JsonProperty("cf_test_details")
public void setCfTestDetails(String cfTestDetails) {
this.cfTestDetails = cfTestDetails;
}

@JsonProperty("component")
public String getComponent() {
return component;
}

@JsonProperty("component")
public void setComponent(String component) {
this.component = component;
}

@JsonProperty("component_id")
public Integer getComponentId() {
return componentId;
}

@JsonProperty("component_id")
public void setComponentId(Integer componentId) {
this.componentId = componentId;
}

@JsonProperty("created_ts")
public String getCreatedTs() {
return createdTs;
}

@JsonProperty("created_ts")
public void setCreatedTs(String createdTs) {
this.createdTs = createdTs;
}

@JsonProperty("delta_ts")
public String getDeltaTs() {
return deltaTs;
}

@JsonProperty("delta_ts")
public void setDeltaTs(String deltaTs) {
this.deltaTs = deltaTs;
}

@JsonProperty("duplicate_of")
public Integer getDuplicateOf() {
return duplicateOf;
}

@JsonProperty("duplicate_of")
public void setDuplicateOf(Integer duplicateOf) {
this.duplicateOf = duplicateOf;
}

@JsonProperty("escalation_managers")
public List<EscalationManager> getEscalationManagers() {
return escalationManagers;
}

@JsonProperty("escalation_managers")
public void setEscalationManagers(List<EscalationManager> escalationManagers) {
this.escalationManagers = escalationManagers;
}

@JsonProperty("external_severity")
public String getExternalSeverity() {
return externalSeverity;
}

@JsonProperty("external_severity")
public void setExternalSeverity(String externalSeverity) {
this.externalSeverity = externalSeverity;
}

@JsonProperty("found_in_phase")
public String getFoundInPhase() {
return foundInPhase;
}

@JsonProperty("found_in_phase")
public void setFoundInPhase(String foundInPhase) {
this.foundInPhase = foundInPhase;
}

@JsonProperty("found_in_product")
public String getFoundInProduct() {
return foundInProduct;
}

@JsonProperty("found_in_product")
public void setFoundInProduct(String foundInProduct) {
this.foundInProduct = foundInProduct;
}

@JsonProperty("found_in_version")
public String getFoundInVersion() {
return foundInVersion;
}

@JsonProperty("found_in_version")
public void setFoundInVersion(String foundInVersion) {
this.foundInVersion = foundInVersion;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("keywords")
public String getKeywords() {
return keywords;
}

@JsonProperty("keywords")
public void setKeywords(String keywords) {
this.keywords = keywords;
}

@JsonProperty("needinfo")
public String getNeedinfo() {
return needinfo;
}

@JsonProperty("needinfo")
public void setNeedinfo(String needinfo) {
this.needinfo = needinfo;
}

@JsonProperty("priority")
public String getPriority() {
return priority;
}

@JsonProperty("priority")
public void setPriority(String priority) {
this.priority = priority;
}

@JsonProperty("product")
public String getProduct() {
return product;
}

@JsonProperty("product")
public void setProduct(String product) {
this.product = product;
}

@JsonProperty("product_id")
public Integer getProductId() {
return productId;
}

@JsonProperty("product_id")
public void setProductId(Integer productId) {
this.productId = productId;
}

@JsonProperty("reporter")
public String getReporter() {
return reporter;
}

@JsonProperty("reporter")
public void setReporter(String reporter) {
this.reporter = reporter;
}

@JsonProperty("resolution")
public String getResolution() {
return resolution;
}

@JsonProperty("resolution")
public void setResolution(String resolution) {
this.resolution = resolution;
}

@JsonProperty("severity")
public String getSeverity() {
return severity;
}

@JsonProperty("severity")
public void setSeverity(String severity) {
this.severity = severity;
}

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("summary")
public String getSummary() {
return summary;
}

@JsonProperty("summary")
public void setSummary(String summary) {
this.summary = summary;
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