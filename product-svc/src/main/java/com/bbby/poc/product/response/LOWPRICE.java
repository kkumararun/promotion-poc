
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
    "[0,25.99]",
    "[26,50.99]",
    "[51,100.99]",
    "[101,200.99]",
    "[201,300.99]",
    "[301,400.99]",
    "[401,500.99]",
    "[501,600.99]",
    "[601,700.99]",
    "[701,800.99]",
    "[801,1000.99]",
    "[1001,1500.99]",
    "[1501,2000.99]",
    "[2001,3000.99]",
    "[3001,100000]"
})
public class LOWPRICE {

    @JsonProperty("[0,25.99]")
    private Integer _02599;
    @JsonProperty("[26,50.99]")
    private Integer _265099;
    @JsonProperty("[51,100.99]")
    private Integer _5110099;
    @JsonProperty("[101,200.99]")
    private Integer _10120099;
    @JsonProperty("[201,300.99]")
    private Integer _20130099;
    @JsonProperty("[301,400.99]")
    private Integer _30140099;
    @JsonProperty("[401,500.99]")
    private Integer _40150099;
    @JsonProperty("[501,600.99]")
    private Integer _50160099;
    @JsonProperty("[601,700.99]")
    private Integer _60170099;
    @JsonProperty("[701,800.99]")
    private Integer _70180099;
    @JsonProperty("[801,1000.99]")
    private Integer _801100099;
    @JsonProperty("[1001,1500.99]")
    private Integer _1001150099;
    @JsonProperty("[1501,2000.99]")
    private Integer _1501200099;
    @JsonProperty("[2001,3000.99]")
    private Integer _2001300099;
    @JsonProperty("[3001,100000]")
    private Integer _3001100000;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("[0,25.99]")
    public Integer get02599() {
        return _02599;
    }

    @JsonProperty("[0,25.99]")
    public void set02599(Integer _02599) {
        this._02599 = _02599;
    }

    @JsonProperty("[26,50.99]")
    public Integer get265099() {
        return _265099;
    }

    @JsonProperty("[26,50.99]")
    public void set265099(Integer _265099) {
        this._265099 = _265099;
    }

    @JsonProperty("[51,100.99]")
    public Integer get5110099() {
        return _5110099;
    }

    @JsonProperty("[51,100.99]")
    public void set5110099(Integer _5110099) {
        this._5110099 = _5110099;
    }

    @JsonProperty("[101,200.99]")
    public Integer get10120099() {
        return _10120099;
    }

    @JsonProperty("[101,200.99]")
    public void set10120099(Integer _10120099) {
        this._10120099 = _10120099;
    }

    @JsonProperty("[201,300.99]")
    public Integer get20130099() {
        return _20130099;
    }

    @JsonProperty("[201,300.99]")
    public void set20130099(Integer _20130099) {
        this._20130099 = _20130099;
    }

    @JsonProperty("[301,400.99]")
    public Integer get30140099() {
        return _30140099;
    }

    @JsonProperty("[301,400.99]")
    public void set30140099(Integer _30140099) {
        this._30140099 = _30140099;
    }

    @JsonProperty("[401,500.99]")
    public Integer get40150099() {
        return _40150099;
    }

    @JsonProperty("[401,500.99]")
    public void set40150099(Integer _40150099) {
        this._40150099 = _40150099;
    }

    @JsonProperty("[501,600.99]")
    public Integer get50160099() {
        return _50160099;
    }

    @JsonProperty("[501,600.99]")
    public void set50160099(Integer _50160099) {
        this._50160099 = _50160099;
    }

    @JsonProperty("[601,700.99]")
    public Integer get60170099() {
        return _60170099;
    }

    @JsonProperty("[601,700.99]")
    public void set60170099(Integer _60170099) {
        this._60170099 = _60170099;
    }

    @JsonProperty("[701,800.99]")
    public Integer get70180099() {
        return _70180099;
    }

    @JsonProperty("[701,800.99]")
    public void set70180099(Integer _70180099) {
        this._70180099 = _70180099;
    }

    @JsonProperty("[801,1000.99]")
    public Integer get801100099() {
        return _801100099;
    }

    @JsonProperty("[801,1000.99]")
    public void set801100099(Integer _801100099) {
        this._801100099 = _801100099;
    }

    @JsonProperty("[1001,1500.99]")
    public Integer get1001150099() {
        return _1001150099;
    }

    @JsonProperty("[1001,1500.99]")
    public void set1001150099(Integer _1001150099) {
        this._1001150099 = _1001150099;
    }

    @JsonProperty("[1501,2000.99]")
    public Integer get1501200099() {
        return _1501200099;
    }

    @JsonProperty("[1501,2000.99]")
    public void set1501200099(Integer _1501200099) {
        this._1501200099 = _1501200099;
    }

    @JsonProperty("[2001,3000.99]")
    public Integer get2001300099() {
        return _2001300099;
    }

    @JsonProperty("[2001,3000.99]")
    public void set2001300099(Integer _2001300099) {
        this._2001300099 = _2001300099;
    }

    @JsonProperty("[3001,100000]")
    public Integer get3001100000() {
        return _3001100000;
    }

    @JsonProperty("[3001,100000]")
    public void set3001100000(Integer _3001100000) {
        this._3001100000 = _3001100000;
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
