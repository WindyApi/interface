package top.whiteleaf03.api.service.weather;

import top.whiteleaf03.api.modal.dto.CityNameDTO;
import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface WeatherService {
    /**
     * 查询城市实时天气
     *
     * @param cityNameDTO 城市名称
     * @return 返回城市实时天气
     */
    ResponseResult queryCityRealTimeWeather(CityNameDTO cityNameDTO);

    /**
     * 查询城市未来天气
     *
     * @param cityNameDTO 城市名称
     * @return 返回城市未来一周天气
     */
    ResponseResult queryCityFeatureWeather(CityNameDTO cityNameDTO);
}
