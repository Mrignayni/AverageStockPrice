package com.chhotwani.AverageStockPrice;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
//import java.util.HashMap;

@JsonIgnoreProperties(value = { "Meta Data" })
public class Stock implements Serializable { //extends Dto{

//    @JsonProperty("Meta Data")
//    @JsonIgnore
//    private HashMap<String, String> metaData;

    @JsonProperty("Time Series (Daily)")
    private TimeSeries timeSeries;


    @JsonAnyGetter
    @JsonProperty("Time Series (Daily)")
    public TimeSeries getTimeSeries() {
        return timeSeries;
    }

    @JsonAnySetter
    @JsonProperty("Time Series (Daily)")
    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }
}
