package com.chhotwani.AverageStockPrice;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TimeSeries implements Serializable {

    // TreeMap because it preserves sorting order
    //@JsonIgnore
    @JsonProperty
    private Map<String, Day> days = new TreeMap<>(Collections.reverseOrder());

    @JsonAnySetter
    @JsonProperty
    public void setDays(String time, Day value){
        //days = new TreeMap<>(Collections.reverseOrder());
        days.put(time,value);
    }

    @JsonAnyGetter
    @JsonProperty
    public Map<String, Day> getData() {
        return days;
    }

    // add getDays() if you need only values
    // and if you need list, can use new ArrayList(days.values())
    //@JsonIgnore
    public Collection<Day> getDays(){
        return days.values();
    }
}
