
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
    "LOW_PRICE"
})
public class FacetIntervals {

    @JsonProperty("LOW_PRICE")
    private LOWPRICE lOWPRICE;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("LOW_PRICE")
    public LOWPRICE getLOWPRICE() {
        return lOWPRICE;
    }

    @JsonProperty("LOW_PRICE")
    public void setLOWPRICE(LOWPRICE lOWPRICE) {
        this.lOWPRICE = lOWPRICE;
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
