
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
    "ATTRIBUTES_FACET",
    "COLORGROUP_s",
    "s_f_Exclusivity",
    "LOW_PRICE",
    "s_f_binProduct_Type",
    "s_f_binMaximum_Height",
    "BRAND",
    "s_f_Warranty",
    "RATINGS",
    "s_f_binMax_Weight",
    "s_f_binWeight_of_Stroller",
    "s_f_binFold_Special_Feature"
})
public class FacetFriendlyNamesOrdered {

    @JsonProperty("ATTRIBUTES_FACET")
    private String aTTRIBUTESFACET;
    @JsonProperty("COLORGROUP_s")
    private String cOLORGROUPS;
    @JsonProperty("s_f_Exclusivity")
    private String sFExclusivity;
    @JsonProperty("LOW_PRICE")
    private String lOWPRICE;
    @JsonProperty("s_f_binProduct_Type")
    private String sFBinProductType;
    @JsonProperty("s_f_binMaximum_Height")
    private String sFBinMaximumHeight;
    @JsonProperty("BRAND")
    private String bRAND;
    @JsonProperty("s_f_Warranty")
    private String sFWarranty;
    @JsonProperty("RATINGS")
    private String rATINGS;
    @JsonProperty("s_f_binMax_Weight")
    private String sFBinMaxWeight;
    @JsonProperty("s_f_binWeight_of_Stroller")
    private String sFBinWeightOfStroller;
    @JsonProperty("s_f_binFold_Special_Feature")
    private String sFBinFoldSpecialFeature;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ATTRIBUTES_FACET")
    public String getATTRIBUTESFACET() {
        return aTTRIBUTESFACET;
    }

    @JsonProperty("ATTRIBUTES_FACET")
    public void setATTRIBUTESFACET(String aTTRIBUTESFACET) {
        this.aTTRIBUTESFACET = aTTRIBUTESFACET;
    }

    @JsonProperty("COLORGROUP_s")
    public String getCOLORGROUPS() {
        return cOLORGROUPS;
    }

    @JsonProperty("COLORGROUP_s")
    public void setCOLORGROUPS(String cOLORGROUPS) {
        this.cOLORGROUPS = cOLORGROUPS;
    }

    @JsonProperty("s_f_Exclusivity")
    public String getSFExclusivity() {
        return sFExclusivity;
    }

    @JsonProperty("s_f_Exclusivity")
    public void setSFExclusivity(String sFExclusivity) {
        this.sFExclusivity = sFExclusivity;
    }

    @JsonProperty("LOW_PRICE")
    public String getLOWPRICE() {
        return lOWPRICE;
    }

    @JsonProperty("LOW_PRICE")
    public void setLOWPRICE(String lOWPRICE) {
        this.lOWPRICE = lOWPRICE;
    }

    @JsonProperty("s_f_binProduct_Type")
    public String getSFBinProductType() {
        return sFBinProductType;
    }

    @JsonProperty("s_f_binProduct_Type")
    public void setSFBinProductType(String sFBinProductType) {
        this.sFBinProductType = sFBinProductType;
    }

    @JsonProperty("s_f_binMaximum_Height")
    public String getSFBinMaximumHeight() {
        return sFBinMaximumHeight;
    }

    @JsonProperty("s_f_binMaximum_Height")
    public void setSFBinMaximumHeight(String sFBinMaximumHeight) {
        this.sFBinMaximumHeight = sFBinMaximumHeight;
    }

    @JsonProperty("BRAND")
    public String getBRAND() {
        return bRAND;
    }

    @JsonProperty("BRAND")
    public void setBRAND(String bRAND) {
        this.bRAND = bRAND;
    }

    @JsonProperty("s_f_Warranty")
    public String getSFWarranty() {
        return sFWarranty;
    }

    @JsonProperty("s_f_Warranty")
    public void setSFWarranty(String sFWarranty) {
        this.sFWarranty = sFWarranty;
    }

    @JsonProperty("RATINGS")
    public String getRATINGS() {
        return rATINGS;
    }

    @JsonProperty("RATINGS")
    public void setRATINGS(String rATINGS) {
        this.rATINGS = rATINGS;
    }

    @JsonProperty("s_f_binMax_Weight")
    public String getSFBinMaxWeight() {
        return sFBinMaxWeight;
    }

    @JsonProperty("s_f_binMax_Weight")
    public void setSFBinMaxWeight(String sFBinMaxWeight) {
        this.sFBinMaxWeight = sFBinMaxWeight;
    }

    @JsonProperty("s_f_binWeight_of_Stroller")
    public String getSFBinWeightOfStroller() {
        return sFBinWeightOfStroller;
    }

    @JsonProperty("s_f_binWeight_of_Stroller")
    public void setSFBinWeightOfStroller(String sFBinWeightOfStroller) {
        this.sFBinWeightOfStroller = sFBinWeightOfStroller;
    }

    @JsonProperty("s_f_binFold_Special_Feature")
    public String getSFBinFoldSpecialFeature() {
        return sFBinFoldSpecialFeature;
    }

    @JsonProperty("s_f_binFold_Special_Feature")
    public void setSFBinFoldSpecialFeature(String sFBinFoldSpecialFeature) {
        this.sFBinFoldSpecialFeature = sFBinFoldSpecialFeature;
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
