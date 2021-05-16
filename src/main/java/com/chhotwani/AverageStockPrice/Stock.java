package com.chhotwani.AverageStockPrice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock{ //extends Dto{

    @JsonProperty("Time Series (Daily)")
    private TimeSeries timeSeries;

    public TimeSeries getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }
}
