
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
    "PRODUCT_ID",
    "SITE_ID",
    "DISPLAY_NAME",
    "PRICE_RANGE_DESCRIP",
    "COLLECTION_FLAG",
    "SWATCH_FLAG",
    "ROLLUP_TYPE_CODE",
    "INTL_RESTRICTED",
    "SCENE7_URL",
    "SEO_URL",
    "BRAND",
    "MEDIUM_IMAGE_ID",
    "VERT_IMAGE_ID",
    "RATINGS",
    "REVIEWS",
    "INCART_FLAG",
    "MX_INCART_FLAG",
    "LOW_PRICE",
    "LOW_PRICE_MX",
    "HIGH_PRICE",
    "HIGH_PRICE_MX",
    "PRICE_RANGE_STRING",
    "PRICE_RANGE_STRING_MX",
    "L3_ID",
    "SKU_ID",
    "CUSTOMIZATION_OFFERED_FLAG",
    "PERSONALIZATION_TYPE",
    "LTL_FLAG",
    "id",
    "SKU_FOR_SWATCH",
    "ATTRIBUTES_JSON",
    "PRICING_LABEL_CODE",
    "WAS_LOW_PRICE",
    "SALE_PRICE_RANGE_STRING",
    "MX_PRICING_LABEL_CODE",
    "WAS_LOW_PRICE_MX",
    "SALE_PRICE_RANGE_STRING_MX"
})
public class Doc {

    @JsonProperty("PRODUCT_ID")
    private String pRODUCTID;
    @JsonProperty("SITE_ID")
    private List<String> sITEID = null;
    @JsonProperty("DISPLAY_NAME")
    private String dISPLAYNAME;
    @JsonProperty("PRICE_RANGE_DESCRIP")
    private String pRICERANGEDESCRIP;
    @JsonProperty("COLLECTION_FLAG")
    private String cOLLECTIONFLAG;
    @JsonProperty("SWATCH_FLAG")
    private String sWATCHFLAG;
    @JsonProperty("ROLLUP_TYPE_CODE")
    private String rOLLUPTYPECODE;
    @JsonProperty("INTL_RESTRICTED")
    private String iNTLRESTRICTED;
    @JsonProperty("SCENE7_URL")
    private String sCENE7URL;
    @JsonProperty("SEO_URL")
    private String sEOURL;
    @JsonProperty("BRAND")
    private String bRAND;
    @JsonProperty("MEDIUM_IMAGE_ID")
    private String mEDIUMIMAGEID;
    @JsonProperty("VERT_IMAGE_ID")
    private String vERTIMAGEID;
    @JsonProperty("RATINGS")
    private Double rATINGS;
    @JsonProperty("REVIEWS")
    private Integer rEVIEWS;
    @JsonProperty("INCART_FLAG")
    private String iNCARTFLAG;
    @JsonProperty("MX_INCART_FLAG")
    private String mXINCARTFLAG;
    @JsonProperty("LOW_PRICE")
    private Double lOWPRICE;
    @JsonProperty("LOW_PRICE_MX")
    private Integer lOWPRICEMX;
    @JsonProperty("HIGH_PRICE")
    private Double hIGHPRICE;
    @JsonProperty("HIGH_PRICE_MX")
    private Integer hIGHPRICEMX;
    @JsonProperty("PRICE_RANGE_STRING")
    private String pRICERANGESTRING;
    @JsonProperty("PRICE_RANGE_STRING_MX")
    private String pRICERANGESTRINGMX;
    @JsonProperty("L3_ID")
    private List<String> l3ID = null;
    @JsonProperty("SKU_ID")
    private List<String> sKUID = null;
    @JsonProperty("CUSTOMIZATION_OFFERED_FLAG")
    private List<String> cUSTOMIZATIONOFFEREDFLAG = null;
    @JsonProperty("PERSONALIZATION_TYPE")
    private List<String> pERSONALIZATIONTYPE = null;
    @JsonProperty("LTL_FLAG")
    private List<String> lTLFLAG = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("SKU_FOR_SWATCH")
    private List<String> sKUFORSWATCH = null;
    @JsonProperty("ATTRIBUTES_JSON")
    private List<String> aTTRIBUTESJSON = null;
    @JsonProperty("PRICING_LABEL_CODE")
    private String pRICINGLABELCODE;
    @JsonProperty("WAS_LOW_PRICE")
    private String wASLOWPRICE;
    @JsonProperty("SALE_PRICE_RANGE_STRING")
    private String sALEPRICERANGESTRING;
    @JsonProperty("MX_PRICING_LABEL_CODE")
    private String mXPRICINGLABELCODE;
    @JsonProperty("WAS_LOW_PRICE_MX")
    private String wASLOWPRICEMX;
    @JsonProperty("SALE_PRICE_RANGE_STRING_MX")
    private String sALEPRICERANGESTRINGMX;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PRODUCT_ID")
    public String getPRODUCTID() {
        return pRODUCTID;
    }

    @JsonProperty("PRODUCT_ID")
    public void setPRODUCTID(String pRODUCTID) {
        this.pRODUCTID = pRODUCTID;
    }

    @JsonProperty("SITE_ID")
    public List<String> getSITEID() {
        return sITEID;
    }

    @JsonProperty("SITE_ID")
    public void setSITEID(List<String> sITEID) {
        this.sITEID = sITEID;
    }

    @JsonProperty("DISPLAY_NAME")
    public String getDISPLAYNAME() {
        return dISPLAYNAME;
    }

    @JsonProperty("DISPLAY_NAME")
    public void setDISPLAYNAME(String dISPLAYNAME) {
        this.dISPLAYNAME = dISPLAYNAME;
    }

    @JsonProperty("PRICE_RANGE_DESCRIP")
    public String getPRICERANGEDESCRIP() {
        return pRICERANGEDESCRIP;
    }

    @JsonProperty("PRICE_RANGE_DESCRIP")
    public void setPRICERANGEDESCRIP(String pRICERANGEDESCRIP) {
        this.pRICERANGEDESCRIP = pRICERANGEDESCRIP;
    }

    @JsonProperty("COLLECTION_FLAG")
    public String getCOLLECTIONFLAG() {
        return cOLLECTIONFLAG;
    }

    @JsonProperty("COLLECTION_FLAG")
    public void setCOLLECTIONFLAG(String cOLLECTIONFLAG) {
        this.cOLLECTIONFLAG = cOLLECTIONFLAG;
    }

    @JsonProperty("SWATCH_FLAG")
    public String getSWATCHFLAG() {
        return sWATCHFLAG;
    }

    @JsonProperty("SWATCH_FLAG")
    public void setSWATCHFLAG(String sWATCHFLAG) {
        this.sWATCHFLAG = sWATCHFLAG;
    }

    @JsonProperty("ROLLUP_TYPE_CODE")
    public String getROLLUPTYPECODE() {
        return rOLLUPTYPECODE;
    }

    @JsonProperty("ROLLUP_TYPE_CODE")
    public void setROLLUPTYPECODE(String rOLLUPTYPECODE) {
        this.rOLLUPTYPECODE = rOLLUPTYPECODE;
    }

    @JsonProperty("INTL_RESTRICTED")
    public String getINTLRESTRICTED() {
        return iNTLRESTRICTED;
    }

    @JsonProperty("INTL_RESTRICTED")
    public void setINTLRESTRICTED(String iNTLRESTRICTED) {
        this.iNTLRESTRICTED = iNTLRESTRICTED;
    }

    @JsonProperty("SCENE7_URL")
    public String getSCENE7URL() {
        return sCENE7URL;
    }

    @JsonProperty("SCENE7_URL")
    public void setSCENE7URL(String sCENE7URL) {
        this.sCENE7URL = sCENE7URL;
    }

    @JsonProperty("SEO_URL")
    public String getSEOURL() {
        return sEOURL;
    }

    @JsonProperty("SEO_URL")
    public void setSEOURL(String sEOURL) {
        this.sEOURL = sEOURL;
    }

    @JsonProperty("BRAND")
    public String getBRAND() {
        return bRAND;
    }

    @JsonProperty("BRAND")
    public void setBRAND(String bRAND) {
        this.bRAND = bRAND;
    }

    @JsonProperty("MEDIUM_IMAGE_ID")
    public String getMEDIUMIMAGEID() {
        return mEDIUMIMAGEID;
    }

    @JsonProperty("MEDIUM_IMAGE_ID")
    public void setMEDIUMIMAGEID(String mEDIUMIMAGEID) {
        this.mEDIUMIMAGEID = mEDIUMIMAGEID;
    }

    @JsonProperty("VERT_IMAGE_ID")
    public String getVERTIMAGEID() {
        return vERTIMAGEID;
    }

    @JsonProperty("VERT_IMAGE_ID")
    public void setVERTIMAGEID(String vERTIMAGEID) {
        this.vERTIMAGEID = vERTIMAGEID;
    }

    @JsonProperty("RATINGS")
    public Double getRATINGS() {
        return rATINGS;
    }

    @JsonProperty("RATINGS")
    public void setRATINGS(Double rATINGS) {
        this.rATINGS = rATINGS;
    }

    @JsonProperty("REVIEWS")
    public Integer getREVIEWS() {
        return rEVIEWS;
    }

    @JsonProperty("REVIEWS")
    public void setREVIEWS(Integer rEVIEWS) {
        this.rEVIEWS = rEVIEWS;
    }

    @JsonProperty("INCART_FLAG")
    public String getINCARTFLAG() {
        return iNCARTFLAG;
    }

    @JsonProperty("INCART_FLAG")
    public void setINCARTFLAG(String iNCARTFLAG) {
        this.iNCARTFLAG = iNCARTFLAG;
    }

    @JsonProperty("MX_INCART_FLAG")
    public String getMXINCARTFLAG() {
        return mXINCARTFLAG;
    }

    @JsonProperty("MX_INCART_FLAG")
    public void setMXINCARTFLAG(String mXINCARTFLAG) {
        this.mXINCARTFLAG = mXINCARTFLAG;
    }

    @JsonProperty("LOW_PRICE")
    public Double getLOWPRICE() {
        return lOWPRICE;
    }

    @JsonProperty("LOW_PRICE")
    public void setLOWPRICE(Double lOWPRICE) {
        this.lOWPRICE = lOWPRICE;
    }

    @JsonProperty("LOW_PRICE_MX")
    public Integer getLOWPRICEMX() {
        return lOWPRICEMX;
    }

    @JsonProperty("LOW_PRICE_MX")
    public void setLOWPRICEMX(Integer lOWPRICEMX) {
        this.lOWPRICEMX = lOWPRICEMX;
    }

    @JsonProperty("HIGH_PRICE")
    public Double getHIGHPRICE() {
        return hIGHPRICE;
    }

    @JsonProperty("HIGH_PRICE")
    public void setHIGHPRICE(Double hIGHPRICE) {
        this.hIGHPRICE = hIGHPRICE;
    }

    @JsonProperty("HIGH_PRICE_MX")
    public Integer getHIGHPRICEMX() {
        return hIGHPRICEMX;
    }

    @JsonProperty("HIGH_PRICE_MX")
    public void setHIGHPRICEMX(Integer hIGHPRICEMX) {
        this.hIGHPRICEMX = hIGHPRICEMX;
    }

    @JsonProperty("PRICE_RANGE_STRING")
    public String getPRICERANGESTRING() {
        return pRICERANGESTRING;
    }

    @JsonProperty("PRICE_RANGE_STRING")
    public void setPRICERANGESTRING(String pRICERANGESTRING) {
        this.pRICERANGESTRING = pRICERANGESTRING;
    }

    @JsonProperty("PRICE_RANGE_STRING_MX")
    public String getPRICERANGESTRINGMX() {
        return pRICERANGESTRINGMX;
    }

    @JsonProperty("PRICE_RANGE_STRING_MX")
    public void setPRICERANGESTRINGMX(String pRICERANGESTRINGMX) {
        this.pRICERANGESTRINGMX = pRICERANGESTRINGMX;
    }

    @JsonProperty("L3_ID")
    public List<String> getL3ID() {
        return l3ID;
    }

    @JsonProperty("L3_ID")
    public void setL3ID(List<String> l3ID) {
        this.l3ID = l3ID;
    }

    @JsonProperty("SKU_ID")
    public List<String> getSKUID() {
        return sKUID;
    }

    @JsonProperty("SKU_ID")
    public void setSKUID(List<String> sKUID) {
        this.sKUID = sKUID;
    }

    @JsonProperty("CUSTOMIZATION_OFFERED_FLAG")
    public List<String> getCUSTOMIZATIONOFFEREDFLAG() {
        return cUSTOMIZATIONOFFEREDFLAG;
    }

    @JsonProperty("CUSTOMIZATION_OFFERED_FLAG")
    public void setCUSTOMIZATIONOFFEREDFLAG(List<String> cUSTOMIZATIONOFFEREDFLAG) {
        this.cUSTOMIZATIONOFFEREDFLAG = cUSTOMIZATIONOFFEREDFLAG;
    }

    @JsonProperty("PERSONALIZATION_TYPE")
    public List<String> getPERSONALIZATIONTYPE() {
        return pERSONALIZATIONTYPE;
    }

    @JsonProperty("PERSONALIZATION_TYPE")
    public void setPERSONALIZATIONTYPE(List<String> pERSONALIZATIONTYPE) {
        this.pERSONALIZATIONTYPE = pERSONALIZATIONTYPE;
    }

    @JsonProperty("LTL_FLAG")
    public List<String> getLTLFLAG() {
        return lTLFLAG;
    }

    @JsonProperty("LTL_FLAG")
    public void setLTLFLAG(List<String> lTLFLAG) {
        this.lTLFLAG = lTLFLAG;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("SKU_FOR_SWATCH")
    public List<String> getSKUFORSWATCH() {
        return sKUFORSWATCH;
    }

    @JsonProperty("SKU_FOR_SWATCH")
    public void setSKUFORSWATCH(List<String> sKUFORSWATCH) {
        this.sKUFORSWATCH = sKUFORSWATCH;
    }

    @JsonProperty("ATTRIBUTES_JSON")
    public List<String> getATTRIBUTESJSON() {
        return aTTRIBUTESJSON;
    }

    @JsonProperty("ATTRIBUTES_JSON")
    public void setATTRIBUTESJSON(List<String> aTTRIBUTESJSON) {
        this.aTTRIBUTESJSON = aTTRIBUTESJSON;
    }

    @JsonProperty("PRICING_LABEL_CODE")
    public String getPRICINGLABELCODE() {
        return pRICINGLABELCODE;
    }

    @JsonProperty("PRICING_LABEL_CODE")
    public void setPRICINGLABELCODE(String pRICINGLABELCODE) {
        this.pRICINGLABELCODE = pRICINGLABELCODE;
    }

    @JsonProperty("WAS_LOW_PRICE")
    public String getWASLOWPRICE() {
        return wASLOWPRICE;
    }

    @JsonProperty("WAS_LOW_PRICE")
    public void setWASLOWPRICE(String wASLOWPRICE) {
        this.wASLOWPRICE = wASLOWPRICE;
    }

    @JsonProperty("SALE_PRICE_RANGE_STRING")
    public String getSALEPRICERANGESTRING() {
        return sALEPRICERANGESTRING;
    }

    @JsonProperty("SALE_PRICE_RANGE_STRING")
    public void setSALEPRICERANGESTRING(String sALEPRICERANGESTRING) {
        this.sALEPRICERANGESTRING = sALEPRICERANGESTRING;
    }

    @JsonProperty("MX_PRICING_LABEL_CODE")
    public String getMXPRICINGLABELCODE() {
        return mXPRICINGLABELCODE;
    }

    @JsonProperty("MX_PRICING_LABEL_CODE")
    public void setMXPRICINGLABELCODE(String mXPRICINGLABELCODE) {
        this.mXPRICINGLABELCODE = mXPRICINGLABELCODE;
    }

    @JsonProperty("WAS_LOW_PRICE_MX")
    public String getWASLOWPRICEMX() {
        return wASLOWPRICEMX;
    }

    @JsonProperty("WAS_LOW_PRICE_MX")
    public void setWASLOWPRICEMX(String wASLOWPRICEMX) {
        this.wASLOWPRICEMX = wASLOWPRICEMX;
    }

    @JsonProperty("SALE_PRICE_RANGE_STRING_MX")
    public String getSALEPRICERANGESTRINGMX() {
        return sALEPRICERANGESTRINGMX;
    }

    @JsonProperty("SALE_PRICE_RANGE_STRING_MX")
    public void setSALEPRICERANGESTRINGMX(String sALEPRICERANGESTRINGMX) {
        this.sALEPRICERANGESTRINGMX = sALEPRICERANGESTRINGMX;
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
