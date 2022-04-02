package liuyang.testweb.commons.exception;

import liuyang.testweb.commons.util.ref.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 这个错误处理方法是根据ES搜房网的写法来的
 * 不过要注意ErrorController接口中的方法已经被标注为废弃
 * 这个类真的不需要写了，直接在templates/error/下给出响应错误代码页面即可。Spring Boot 2.x已经配置好了。
 *
 * @author liuyang
 * @scine 2021/7/3
 */
@Deprecated
//@Controller
public class AppErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * Web页面错误处理
     */
    /*
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 405:
                return "405";
            case 500:
                return "500";
        }
        return "liuyang_welcome";
    }
     */

    /**
     * Web页面以外的错误处理，比如JSON/XML等
     */
    /*
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errApiHandler(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        // 从RequestAttributes中获取错误信息
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(requestAttributes, false);// error 这个有问题啊
        int status = getStatus(request);
        return ApiResponse.ofMessage(status, String.valueOf(errorAttributes.getOrDefault("message", "error")));
    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }
        return 500;
    }
     */
}
