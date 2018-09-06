
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
    "related_searches",
    "banner"
})
public class SearchMap {

    @JsonProperty("related_searches")
    private List<String> relatedSearches = null;
    @JsonProperty("banner")
    private List<Banner> banner = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("related_searches")
    public List<String> getRelatedSearches() {
        return relatedSearches;
    }

    @JsonProperty("related_searches")
    public void setRelatedSearches(List<String> relatedSearches) {
        this.relatedSearches = relatedSearches;
    }

    @JsonProperty("banner")
    public List<Banner> getBanner() {
        return banner;
    }

    @JsonProperty("banner")
    public void setBanner(List<Banner> banner) {
        this.banner = banner;
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
