package top.whiteleaf03.api.service.weather;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.whiteleaf03.api.modal.dto.CityNameDTO;
import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {
    private final String APP_ID = "75484671";
    private final String APP_SECRET = "7nG9BCwC";
    private final String DAY_API_ADDRESS = "https://v0.yiketianqi.com/free/day?unescape=1";
    private final String WEEK_API_ADDRESS = "https://v0.yiketianqi.com/free/week?unescape=1";

    /**
     * 查询城市实时天气
     *
     * @param cityNameDTO 城市名称
     * @return 返回城市实时天气
     */
    @Override
    public ResponseResult queryCityRealTimeWeather(CityNameDTO cityNameDTO) {
        String url = DAY_API_ADDRESS + "&appid=" + APP_ID + "&appsecret=" + APP_SECRET + "&city=" + cityNameDTO.getCityName();
        String result = HttpRequest.get(url)
                .execute()
                .body();
        return ResponseResult.success(JSONUtil.parseObj(result));
    }

    /**
     * 查询城市未来天气
     *
     * @param cityNameDTO 城市名称
     * @return 返回城市未来一周天气
     */
    @Override
    public ResponseResult queryCityFeatureWeather(CityNameDTO cityNameDTO) {
        String url = WEEK_API_ADDRESS + "&appid=" + APP_ID + "&appsecret=" + APP_SECRET + "&city=" + cityNameDTO.getCityName();
        String result = HttpRequest.get(url)
                .execute()
                .body();
        return ResponseResult.success(JSONUtil.parseObj(result));
    }
}
