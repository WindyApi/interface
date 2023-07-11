package top.whiteleaf03.api.service.email;

import top.whiteleaf03.api.modal.dto.EmailInfoDTO;
import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface EmailService {
    /**
     * 发送邮件
     *
     * @param emailInfoDTO 邮件信息
     * @return 返回结果
     */
    ResponseResult sentEmail(EmailInfoDTO emailInfoDTO);
}
