package top.whiteleaf03.api.service.email;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.whiteleaf03.api.modal.dto.EmailInfoDTO;
import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送邮件
     *
     * @param emailInfoDTO 邮件信息
     * @return 返回结果
     */
    @Override
    public ResponseResult sentEmail(EmailInfoDTO emailInfoDTO) {
        sent(emailInfoDTO);
        return ResponseResult.success();
    }

    @RabbitListener(queues = "email")
    public void sentEmail(String emailInfo) {
        EmailInfoDTO emailInfoDTO = JSONUtil.toBean(emailInfo, EmailInfoDTO.class);
        sent(emailInfoDTO);
    }

    void sent(EmailInfoDTO emailInfoDTO) {
        javaMailSender.send(new SimpleMailMessage() {{
            setSubject("[WindyApi开放平台]");
            setText(emailInfoDTO.getMessage());
            setFrom("windyapi@163.com");
            setTo(emailInfoDTO.getTarget());
        }});
    }
}
