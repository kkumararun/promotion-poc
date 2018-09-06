
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
    "s_f_Warranty",
    "s_f_binFold_Special_Feature",
    "COLORGROUP_s",
    "ATTRIBUTES_FACET",
    "LOW_PRICE",
    "s_f_Exclusivity",
    "s_f_binProduct_Type",
    "s_f_binMax_Weight",
    "RATINGS",
    "s_f_binWeight_of_Stroller",
    "s_f_binMaximum_Height",
    "BRAND"
})
public class FacetFriendlyNames {

    @JsonProperty("s_f_Warranty")
    private List<String> sFWarranty = null;
    @JsonProperty("s_f_binFold_Special_Feature")
    private List<String> sFBinFoldSpecialFeature = null;
    @JsonProperty("COLORGROUP_s")
    private List<String> cOLORGROUPS = null;
    @JsonProperty("ATTRIBUTES_FACET")
    private List<String> aTTRIBUTESFACET = null;
    @JsonProperty("LOW_PRICE")
    private List<String> lOWPRICE = null;
    @JsonProperty("s_f_Exclusivity")
    private List<String> sFExclusivity = null;
    @JsonProperty("s_f_binProduct_Type")
    private List<String> sFBinProductType = null;
    @JsonProperty("s_f_binMax_Weight")
    private List<String> sFBinMaxWeight = null;
    @JsonProperty("RATINGS")
    private List<String> rATINGS = null;
    @JsonProperty("s_f_binWeight_of_Stroller")
    private List<String> sFBinWeightOfStroller = null;
    @JsonProperty("s_f_binMaximum_Height")
    private List<String> sFBinMaximumHeight = null;
    @JsonProperty("BRAND")
    private List<String> bRAND = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("s_f_Warranty")
    public List<String> getSFWarranty() {
        return sFWarranty;
    }

    @JsonProperty("s_f_Warranty")
    public void setSFWarranty(List<String> sFWarranty) {
        this.sFWarranty = sFWarranty;
    }

    @JsonProperty("s_f_binFold_Special_Feature")
    public List<String> getSFBinFoldSpecialFeature() {
        return sFBinFoldSpecialFeature;
    }

    @JsonProperty("s_f_binFold_Special_Feature")
    public void setSFBinFoldSpecialFeature(List<String> sFBinFoldSpecialFeature) {
        this.sFBinFoldSpecialFeature = sFBinFoldSpecialFeature;
    }

    @JsonProperty("COLORGROUP_s")
    public List<String> getCOLORGROUPS() {
        return cOLORGROUPS;
    }

    @JsonProperty("COLORGROUP_s")
    public void setCOLORGROUPS(List<String> cOLORGROUPS) {
        this.cOLORGROUPS = cOLORGROUPS;
    }

    @JsonProperty("ATTRIBUTES_FACET")
    public List<String> getATTRIBUTESFACET() {
        return aTTRIBUTESFACET;
    }

    @JsonProperty("ATTRIBUTES_FACET")
    public void setATTRIBUTESFACET(List<String> aTTRIBUTESFACET) {
        this.aTTRIBUTESFACET = aTTRIBUTESFACET;
    }

    @JsonProperty("LOW_PRICE")
    public List<String> getLOWPRICE() {
        return lOWPRICE;
    }

    @JsonProperty("LOW_PRICE")
    public void setLOWPRICE(List<String> lOWPRICE) {
        this.lOWPRICE = lOWPRICE;
    }

    @JsonProperty("s_f_Exclusivity")
    public List<String> getSFExclusivity() {
        return sFExclusivity;
    }

    @JsonProperty("s_f_Exclusivity")
    public void setSFExclusivity(List<String> sFExclusivity) {
        this.sFExclusivity = sFExclusivity;
    }

    @JsonProperty("s_f_binProduct_Type")
    public List<String> getSFBinProductType() {
        return sFBinProductType;
    }

    @JsonProperty("s_f_binProduct_Type")
    public void setSFBinProductType(List<String> sFBinProductType) {
        this.sFBinProductType = sFBinProductType;
    }

    @JsonProperty("s_f_binMax_Weight")
    public List<String> getSFBinMaxWeight() {
        return sFBinMaxWeight;
    }

    @JsonProperty("s_f_binMax_Weight")
    public void setSFBinMaxWeight(List<String> sFBinMaxWeight) {
        this.sFBinMaxWeight = sFBinMaxWeight;
    }

    @JsonProperty("RATINGS")
    public List<String> getRATINGS() {
        return rATINGS;
    }

    @JsonProperty("RATINGS")
    public void setRATINGS(List<String> rATINGS) {
        this.rATINGS = rATINGS;
    }

    @JsonProperty("s_f_binWeight_of_Stroller")
    public List<String> getSFBinWeightOfStroller() {
        return sFBinWeightOfStroller;
    }

    @JsonProperty("s_f_binWeight_of_Stroller")
    public void setSFBinWeightOfStroller(List<String> sFBinWeightOfStroller) {
        this.sFBinWeightOfStroller = sFBinWeightOfStroller;
    }

    @JsonProperty("s_f_binMaximum_Height")
    public List<String> getSFBinMaximumHeight() {
        return sFBinMaximumHeight;
    }

    @JsonProperty("s_f_binMaximum_Height")
    public void setSFBinMaximumHeight(List<String> sFBinMaximumHeight) {
        this.sFBinMaximumHeight = sFBinMaximumHeight;
    }

    @JsonProperty("BRAND")
    public List<String> getBRAND() {
        return bRAND;
    }

    @JsonProperty("BRAND")
    public void setBRAND(List<String> bRAND) {
        this.bRAND = bRAND;
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
