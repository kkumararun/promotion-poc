
package com.bbby.poc.product.response;

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
    "fusion",
    "spellcheck",
    "response",
    "responseHeader",
    "facet_counts"
})
public class FusionResponse {

    @JsonProperty("fusion")
    private Fusion fusion;
    @JsonProperty("spellcheck")
    private Spellcheck spellcheck;
    @JsonProperty("response")
    private Response response;
    @JsonProperty("responseHeader")
    private ResponseHeader responseHeader;
    @JsonProperty("facet_counts")
    private FacetCounts facetCounts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fusion")
    public Fusion getFusion() {
        return fusion;
    }

    @JsonProperty("fusion")
    public void setFusion(Fusion fusion) {
        this.fusion = fusion;
    }

    @JsonProperty("spellcheck")
    public Spellcheck getSpellcheck() {
        return spellcheck;
    }

    @JsonProperty("spellcheck")
    public void setSpellcheck(Spellcheck spellcheck) {
        this.spellcheck = spellcheck;
    }

    @JsonProperty("response")
    public Response getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(Response response) {
        this.response = response;
    }

    @JsonProperty("responseHeader")
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    @JsonProperty("responseHeader")
    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    @JsonProperty("facet_counts")
    public FacetCounts getFacetCounts() {
        return facetCounts;
    }

    @JsonProperty("facet_counts")
    public void setFacetCounts(FacetCounts facetCounts) {
        this.facetCounts = facetCounts;
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
