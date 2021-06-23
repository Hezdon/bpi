package com.example.bitcoinusdexchangerate.api;

import com.example.bitcoinusdexchangerate.util.Validator;
import com.example.bitcoinusdexchangerate.webClient.BitcoinUsdExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/bpi")
public class BpiRestController {

    @Autowired
    BitcoinUsdExchangeClient bitcoinUsdExchangeClient;

    @Autowired
    Validator validator;
    @GetMapping("/history/exchange_rate/{start}/{end}")
    public ResponseEntity bpiHistoryDataByDate(@PathVariable String start, @PathVariable String end){
        Map<String, String> map = new HashMap<>();
        if(!validator.dateValidator(start)){
            map.put("message","Invalid start date");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        if(!validator.dateValidator(end)){
            map.put("message","Invalid end date");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        try{
            return new ResponseEntity<>(bitcoinUsdExchangeClient.getBpiHistoryData(start, end).getBpi(), HttpStatus.OK);
        }
        catch (HttpClientErrorException ex){
            map.put("message",ex.getResponseBodyAsString());
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }


    }



    @GetMapping("/usd/price")
    public ResponseEntity bpiCurrentPrice(){

        return new ResponseEntity<>(bitcoinUsdExchangeClient.getBpiCurrentPrice().getBpi(), HttpStatus.OK);

    }
}
