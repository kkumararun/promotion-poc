
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
    "image_href",
    "channel",
    "image_alt",
    "image_src"
})
public class _0 {

    @JsonProperty("image_href")
    private List<String> imageHref = null;
    @JsonProperty("channel")
    private List<String> channel = null;
    @JsonProperty("image_alt")
    private List<String> imageAlt = null;
    @JsonProperty("image_src")
    private List<String> imageSrc = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("image_href")
    public List<String> getImageHref() {
        return imageHref;
    }

    @JsonProperty("image_href")
    public void setImageHref(List<String> imageHref) {
        this.imageHref = imageHref;
    }

    @JsonProperty("channel")
    public List<String> getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(List<String> channel) {
        this.channel = channel;
    }

    @JsonProperty("image_alt")
    public List<String> getImageAlt() {
        return imageAlt;
    }

    @JsonProperty("image_alt")
    public void setImageAlt(List<String> imageAlt) {
        this.imageAlt = imageAlt;
    }

    @JsonProperty("image_src")
    public List<String> getImageSrc() {
        return imageSrc;
    }

    @JsonProperty("image_src")
    public void setImageSrc(List<String> imageSrc) {
        this.imageSrc = imageSrc;
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
