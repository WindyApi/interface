package top.whiteleaf03.api.service;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.whiteleaf03.api.util.ResponseResult;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class AnimateServiceImpl implements AnimateService {
    /**
     * 获取随机动漫头像
     *
     * @return 返回图片URL
     */
    @Override
    public ResponseResult getAvatar() {
        String redirectUrl;
        try {
            redirectUrl = getRedirectUrl("https://www.loliapi.com/acg/pp/");
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
        log.info(redirectUrl);
        return ResponseResult.success(redirectUrl);
    }

    /**
     * 获取PC动漫背景
     *
     * @return 返回图片URL
     */
    @Override
    public ResponseResult getBackgroundFromPC() {
        String redirectUrl;
        try {
            redirectUrl = getRedirectUrl("https://www.loliapi.com/acg/pc/");
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
        log.info(redirectUrl);
        return ResponseResult.success(redirectUrl);
    }

    /**
     * 获取PC动漫背景
     *
     * @return 返回图片URL
     */
    @Override
    public ResponseResult getBackgroundFromMobile() {
        String redirectUrl;
        try {
            redirectUrl = getRedirectUrl("https://www.loliapi.com/acg/pe/");
        } catch (Exception e) {
            return ResponseResult.error(e.getMessage());
        }
        log.info(redirectUrl);
        return ResponseResult.success(redirectUrl);
    }

    private String getRedirectUrl(String path) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(path)
                .openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setConnectTimeout(5000);
        return conn.getHeaderField("Location");
    }
}
