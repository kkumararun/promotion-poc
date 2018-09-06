
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
    "suggestions",
    "correctlySpelled",
    "collations"
})
public class Spellcheck {

    @JsonProperty("suggestions")
    private List<Object> suggestions = null;
    @JsonProperty("correctlySpelled")
    private Boolean correctlySpelled;
    @JsonProperty("collations")
    private List<Object> collations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("suggestions")
    public List<Object> getSuggestions() {
        return suggestions;
    }

    @JsonProperty("suggestions")
    public void setSuggestions(List<Object> suggestions) {
        this.suggestions = suggestions;
    }

    @JsonProperty("correctlySpelled")
    public Boolean getCorrectlySpelled() {
        return correctlySpelled;
    }

    @JsonProperty("correctlySpelled")
    public void setCorrectlySpelled(Boolean correctlySpelled) {
        this.correctlySpelled = correctlySpelled;
    }

    @JsonProperty("collations")
    public List<Object> getCollations() {
        return collations;
    }

    @JsonProperty("collations")
    public void setCollations(List<Object> collations) {
        this.collations = collations;
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
