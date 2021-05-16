package com.chhotwani.AverageStockPrice;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AverageStockPriceController {

    RestTemplate restTemplate = new RestTemplate();
    private static final String GET_STOCK_TIME_SERIES = "https://www.alphavantage.co/query?apikey={apikey}&function=TIME_SERIES_DAILY_ADJUSTED&symbol={ticker}";

    //delete this method - this is a debugging helper method
    @RequestMapping(method = RequestMethod.GET, path = "/time")
    public String displayCurrentDateTime(){
        return LocalDateTime.now().toString();
    }


    @RequestMapping(value = "/AverageStockPrice/ticker/{ticker}/ndays/{ndays}", method = RequestMethod.GET)
    public Stock averageStockPrice(@PathVariable String ticker, @PathVariable int ndays){

        Stock stock = getStockData(ticker);
        return stock;
        //return new String(ticker + " " + Integer.toString(ndays));
    }

    public Stock getStockData(String ticker){
        String apiKey = System.getenv().getOrDefault("API_KEY", "demo");
        apiKey = apiKey == null ? "demo" : apiKey;
        Map<String, String> param = new HashMap<>();
        param.put("apikey", apiKey);
        param.put("ticker", ticker);

        Stock stockJson = restTemplate.getForObject(GET_STOCK_TIME_SERIES, Stock.class, param );

        return stockJson;

    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String getFallback() {
        return "The correct syntax to access this API is \"/AverageStockPrice/ticker/{ticker}/ndays/{ndays}\"";
    }



}
