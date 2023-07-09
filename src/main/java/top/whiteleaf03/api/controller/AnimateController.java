package top.whiteleaf03.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whiteleaf03.api.service.animate.AnimateService;
import top.whiteleaf03.api.util.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/animate")
public class AnimateController {
    private final AnimateService animateService;

    @Autowired
    public AnimateController(AnimateService animateService) {
        this.animateService = animateService;
    }

    @GetMapping("avatar")
    public ResponseResult getAvatar() {
        return animateService.getAvatar();
    }

    @GetMapping("bg/pc")
    public ResponseResult getBackgroundFromPC() {
        return animateService.getBackgroundFromPC();
    }

    @GetMapping("bg/mobile")
    public ResponseResult getBackgroundFromMobile() {
        return animateService.getBackgroundFromPC();
    }
}
