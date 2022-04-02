package liuyang.testweb.modules.web.controller;

import liuyang.testweb.commons.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuyang
 * @scine 2021/5/25
 */
@Controller
@Slf4j
public class HelloController {

    @RequestMapping("/helloview")
    public String helloView() {
        log.info("helloView()");
        return "helloView";// 组件支撑：BeanNameViewResolver 自定义View参见HelloView
    }

}
