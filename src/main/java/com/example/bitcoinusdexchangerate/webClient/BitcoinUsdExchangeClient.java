package com.example.bitcoinusdexchangerate.webClient;

import com.example.bitcoinusdexchangerate.dto.BpiHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class BitcoinUsdExchangeClient {

    @Value("${coindesk.api.url}")
    private String coindeskUrl;

    @Autowired
    RestTemplate restTemplate;

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd-HH-mm-ss").create();

    public BpiHistoryDto getBpiHistoryData(String start, String end) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = coindeskUrl+"/historical/close.json?start="+start+"&end="+end;
        String bpiHistoryData = restTemplate.getForObject(url, String.class);
        BpiHistoryDto response = gson.fromJson(bpiHistoryData, BpiHistoryDto.class);

        return response;
    }



    public BpiHistoryDto getBpiCurrentPrice() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = coindeskUrl+"/currentprice/USD.json";

        String bpiHistoryData = restTemplate.getForObject(url, String.class);

        BpiHistoryDto response = gson.fromJson(bpiHistoryData, BpiHistoryDto.class);

        return response;
    }
}
