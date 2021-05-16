package com.chhotwani.AverageStockPrice;

import com.fasterxml.jackson.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class TimeSeries {

    // TreeMap because it preserves sorting order
    @JsonIgnore
    private Map<String, Day> days = new TreeMap<>();

    @JsonAnySetter
    public void setDays(String time, Day value){
        days.put(time,value);
    }

    @JsonAnyGetter
    public Map<String, Day> getData() {
        return days;
    }

    // add getDays() if you need only values
    // and if you need list, can use new ArrayList(days.values())
    @JsonIgnore
    public Map<String, Day> getDays(){
        return days;
    }
}
