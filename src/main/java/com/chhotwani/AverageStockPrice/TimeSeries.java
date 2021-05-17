package com.chhotwani.AverageStockPrice;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TimeSeries implements Serializable {

    // TreeMap because it preserves sorting order. Reverse order because we only care about the last ndays.
    @JsonProperty
    private Map<String, Day> days = new TreeMap<>(Collections.reverseOrder());

    @JsonAnySetter
    @JsonProperty
    public void setDays(String time, Day value){
        days.put(time,value);
    }

    @JsonAnyGetter
    @JsonProperty
    public Map<String, Day> getData() {
        return days;
    }


    public Collection<Day> getDays(){
        return days.values();
    }
}
