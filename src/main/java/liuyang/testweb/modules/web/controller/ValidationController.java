package liuyang.testweb.modules.web.controller;

import liuyang.testweb.commons.util.R;
import liuyang.testweb.modules.web.vo.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author liuyang
 * @scine 2021/6/22
 */
@RestController
@RequestMapping("/valid")
@Slf4j
// @Validatedb
public class ValidationController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/dept")
    public R dept() {
        log.info("dept");
        return R.ok("dept");
    }

    @PostMapping("/department")
    public R department(
            @RequestBody
            @Valid
            Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("校验失败");
            log.error(bindingResult.getModel().toString());
            return R.error("校验失败");
        }

        log.info("department 校验成功");
        return R.ok("校验成功");
    }
}
