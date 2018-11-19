package com.llena.weather.api;

import com.llena.weather.object.Weather;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    private final String APPID = "0f4af1f43571f85ae974525dad34c722";
    private final String CURRENT_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={appid}";

    @RequestMapping("/weather")
    public String getWeather(@RequestParam("city") String city) {
        return getOpenWeatherResponse(city);
    }

    public String getOpenWeatherResponse(String city)
    {
        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(CURRENT_WEATHER_URL, Weather.class, city, APPID);



        return weather.getWeather() + " " + weather.getDescription();
    }
}
