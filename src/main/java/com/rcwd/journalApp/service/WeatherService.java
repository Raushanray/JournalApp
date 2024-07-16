package com.rcwd.journalApp.service;

import com.rcwd.journalApp.api.response.WeatherResponse;
import com.rcwd.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    private static final String apikey = "d1e2f84a435e45f6a03d17cd48b80042";
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

