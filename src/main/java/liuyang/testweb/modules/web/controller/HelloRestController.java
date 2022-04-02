package liuyang.testweb.modules.web.controller;

import liuyang.testweb.commons.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author liuyang(wx)
 * @since 2021/5/22
 */
@RestController
@Slf4j
public class HelloRestController {
    /*@RequestMapping("/")
    public String hello() {
        return "hello";
    }*/

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/bug.jpg")
    public String testStatic() {
        return "动态资源路由规则优先。";
    }

    @PostMapping("/testpost")
    public R testPost(@Valid String cityId){
        log.info(cityId);
        return R.ok().put("cityId", cityId);
    }

}
