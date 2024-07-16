package com.rcwd.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {


    private List<Data> data;

    @Getter
    @Setter
    public static class Data {
        @JsonProperty("app_temp")
        private double appTemp;
    }
}








