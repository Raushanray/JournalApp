package com.rcwd.journalApp.service;

import com.rcwd.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private  String apikey;
    private static final String API = "https://api.weatherbit.io/v2.0/forecast/hourly?city=CITY&key=API_KEY";

  @Autowired
  private RestTemplate restTemplate;



    public WeatherResponse getWeather(String city) {
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apikey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        return response.getBody();
    }
    /*
    This method is creating for hit the post call of external api.
     */

//    public WeatherResponse getWeather1(String city) {
//        String finalAPI = API.replace("CITY", city).replace("API_KEY", apikey);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key", "value");
//
//        User user = User.builder().userName("akshitakshit").password("akshit").build();
//        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
//
//        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, httpEntity, WeatherResponse.class);
//        return response.getBody();
//    }
}

