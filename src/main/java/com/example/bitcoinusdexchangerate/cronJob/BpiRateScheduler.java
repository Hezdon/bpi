package com.example.bitcoinusdexchangerate.cronJob;


import com.example.bitcoinusdexchangerate.dto.BpiHistoryDto;
import com.example.bitcoinusdexchangerate.webClient.BitcoinUsdExchangeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class BpiRateScheduler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BitcoinUsdExchangeClient bitcoinUsdExchangeClient;

    @Scheduled(cron = "${bitcoin.usd.rate.cron.interval}")
    public void ncsScheduleTask() {
        BpiHistoryDto bpiHistoryDto = bitcoinUsdExchangeClient.getBpiCurrentPrice();
        logger.info("bitcoin/usd rate : " + bpiHistoryDto.getBpi().toString());
    }
}
