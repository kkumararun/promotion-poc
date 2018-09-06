
package com.bbby.poc.product.response;

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
    "mm",
    "q",
    "main_q",
    "queryX",
    "applicable_rules_ids",
    "facet_friendly_names_ordered",
    "qaf_applied",
    "facet_order",
    "qaf",
    "search_map",
    "facet_friendly_names"
})
public class Fusion {

    @JsonProperty("mm")
    private String mm;
    @JsonProperty("q")
    private String q;
    @JsonProperty("main_q")
    private String mainQ;
    @JsonProperty("queryX")
    private Object queryX;
    @JsonProperty("applicable_rules_ids")
    private List<String> applicableRulesIds = null;
    @JsonProperty("facet_friendly_names_ordered")
    private FacetFriendlyNamesOrdered facetFriendlyNamesOrdered;
    @JsonProperty("qaf_applied")
    private String qafApplied;
    @JsonProperty("facet_order")
    private List<String> facetOrder = null;
    @JsonProperty("qaf")
    private String qaf;
    @JsonProperty("search_map")
    private SearchMap searchMap;
    @JsonProperty("facet_friendly_names")
    private FacetFriendlyNames facetFriendlyNames;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("mm")
    public String getMm() {
        return mm;
    }

    @JsonProperty("mm")
    public void setMm(String mm) {
        this.mm = mm;
    }

    @JsonProperty("q")
    public String getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(String q) {
        this.q = q;
    }

    @JsonProperty("main_q")
    public String getMainQ() {
        return mainQ;
    }

    @JsonProperty("main_q")
    public void setMainQ(String mainQ) {
        this.mainQ = mainQ;
    }

    @JsonProperty("queryX")
    public Object getQueryX() {
        return queryX;
    }

    @JsonProperty("queryX")
    public void setQueryX(Object queryX) {
        this.queryX = queryX;
    }

    @JsonProperty("applicable_rules_ids")
    public List<String> getApplicableRulesIds() {
        return applicableRulesIds;
    }

    @JsonProperty("applicable_rules_ids")
    public void setApplicableRulesIds(List<String> applicableRulesIds) {
        this.applicableRulesIds = applicableRulesIds;
    }

    @JsonProperty("facet_friendly_names_ordered")
    public FacetFriendlyNamesOrdered getFacetFriendlyNamesOrdered() {
        return facetFriendlyNamesOrdered;
    }

    @JsonProperty("facet_friendly_names_ordered")
    public void setFacetFriendlyNamesOrdered(FacetFriendlyNamesOrdered facetFriendlyNamesOrdered) {
        this.facetFriendlyNamesOrdered = facetFriendlyNamesOrdered;
    }

    @JsonProperty("qaf_applied")
    public String getQafApplied() {
        return qafApplied;
    }

    @JsonProperty("qaf_applied")
    public void setQafApplied(String qafApplied) {
        this.qafApplied = qafApplied;
    }

    @JsonProperty("facet_order")
    public List<String> getFacetOrder() {
        return facetOrder;
    }

    @JsonProperty("facet_order")
    public void setFacetOrder(List<String> facetOrder) {
        this.facetOrder = facetOrder;
    }

    @JsonProperty("qaf")
    public String getQaf() {
        return qaf;
    }

    @JsonProperty("qaf")
    public void setQaf(String qaf) {
        this.qaf = qaf;
    }

    @JsonProperty("search_map")
    public SearchMap getSearchMap() {
        return searchMap;
    }

    @JsonProperty("search_map")
    public void setSearchMap(SearchMap searchMap) {
        this.searchMap = searchMap;
    }

    @JsonProperty("facet_friendly_names")
    public FacetFriendlyNames getFacetFriendlyNames() {
        return facetFriendlyNames;
    }

    @JsonProperty("facet_friendly_names")
    public void setFacetFriendlyNames(FacetFriendlyNames facetFriendlyNames) {
        this.facetFriendlyNames = facetFriendlyNames;
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
