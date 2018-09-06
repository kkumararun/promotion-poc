
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
    "zkConnected",
    "status",
    "QTime"
})
public class ResponseHeader {

    @JsonProperty("zkConnected")
    private Boolean zkConnected;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("QTime")
    private Integer qTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("zkConnected")
    public Boolean getZkConnected() {
        return zkConnected;
    }

    @JsonProperty("zkConnected")
    public void setZkConnected(Boolean zkConnected) {
        this.zkConnected = zkConnected;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("QTime")
    public Integer getQTime() {
        return qTime;
    }

    @JsonProperty("QTime")
    public void setQTime(Integer qTime) {
        this.qTime = qTime;
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
