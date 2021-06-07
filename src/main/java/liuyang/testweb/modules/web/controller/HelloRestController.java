package liuyang.testweb.modules.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyang(wx)
 * @since 2021/5/22
 */
@RestController
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

}
