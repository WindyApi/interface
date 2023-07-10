package top.whiteleaf03.api.service.text;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.whiteleaf03.api.util.ResponseResult;

@Slf4j
@Service
public class TextServiceImpl implements TextService {
    private final String API_ADDRESS = "https://apis.tianapi.com/dujitang/index?";
    private final String KEY = "90c2c7af757d5d01ba5195f682549839";

    /**
     * 获取心灵鸡汤
     *
     * @return 返回结果
     */
    @Override
    public ResponseResult getSoupForSoul() {
        String result = HttpRequest.get(API_ADDRESS + "key=" + KEY)
                .execute()
                .body();
        System.out.println(result);
        result = result.replace("\"code\":200", "\"status\":0");
        result = result.replace("\"msg\":\"success\"", "\"msg\":\"OK\"");
        result = result.replace("\"msg\":\"success\"", "\"msg\":\"OK\"");
        result = result.replace("\"result\"", "\"data\"");
        return JSONUtil.toBean(result, ResponseResult.class);
    }
}
