package top.whiteleaf03.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whiteleaf03.api.modal.dto.CityNameDTO;
import top.whiteleaf03.api.service.weather.WeatherService;
import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("day")
    public ResponseResult queryCityRealTimeWeather(CityNameDTO cityNameDTO) {
        return weatherService.queryCityRealTimeWeather(cityNameDTO);
    }

    @GetMapping("week")
    public ResponseResult queryCityFeatureWeather(CityNameDTO cityNameDTO) {
        return weatherService.queryCityFeatureWeather(cityNameDTO);
    }
}
