# Read Me First
This is a Bitcoin Price Index Application which enable users to get current bitcoin to USD exchange rate. Also, users are allowed to get range of prices with a given period of days.

# Getting Started
The application was compiled with JDK 11. In order to run the jar, simply download the [zip file](https://github.com/Hezdon/bpi/blob/dev/bitcoin-usd-exchange-rate-0.0.1-SNAPSHOT.zip)  and run the command below and you are good to go - just make sure you have Java
running on your system. The application runs on port 8082 but of course you can change the port in the ***application.properties*** file in the resources folder.
 ```
java -jar bitcoin-usd-exchange-rate-0.0.1-SNAPSHOT.jar
```

# Getting Current Bitcoin to USD Rate
GET METHOD, [url](http://localhost:8082/api/v1/bpi/usd/price) 

# Getting Bitcoin to USD Rate between a given period
GET METHOD, [url](http://localhost:8082/api/v1/bpi/history/exchange_rate/2021-06-10/2021-06-23) 


