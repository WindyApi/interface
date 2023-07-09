package top.whiteleaf03.api.service.animate;

import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 *
 * API支持：www.loliapi.com
 */
public interface AnimateService {
    /**
     * 获取随机动漫头像
     *
     * @return 返回图片URL
     */
    ResponseResult getAvatar();

    /**
     * 获取PC动漫背景
     *
     * @return 返回图片URL
     */
    ResponseResult getBackgroundFromPC();

    /**
     * 获取PC动漫背景
     *
     * @return 返回图片URL
     */
    ResponseResult getBackgroundFromMobile();
}
