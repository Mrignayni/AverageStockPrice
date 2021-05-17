package com.chhotwani.AverageStockPrice;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;


@JsonIgnoreProperties(value = { "Meta Data" })
public class Stock implements Serializable {


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
