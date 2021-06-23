package com.example.bitcoinusdexchangerate.util;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class Validator {

    public boolean dateValidator(String dateStr){
        DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
