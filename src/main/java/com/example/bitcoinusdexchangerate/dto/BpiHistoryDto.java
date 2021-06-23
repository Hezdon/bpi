package com.example.bitcoinusdexchangerate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties
@NoArgsConstructor
public class BpiHistoryDto {
    Object bpi, time;
    String disclaimer;

}
