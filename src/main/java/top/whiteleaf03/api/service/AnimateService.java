package top.whiteleaf03.api.service;

import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface AnimateService {
    /**
     * 获取随机动漫头像
     *
     * @return 返回图片URL
     */
    ResponseResult getAvatar();
}
