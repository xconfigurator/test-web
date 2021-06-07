package liuyang.testweb.modules.web.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 自定义View需要配合BeanNameViewResolver使用
 * Spring Boot环境中在WebMvcAutoConfiguration中已经配置了BeanNameViewResolver Order值越小 优先级越高
 * ????? FAIL
 * @author liuyang
 * @scine 2021/5/25
 */
@Component
public class HelloView implements View {
    @Override
    public String getContentType() {
        return "test/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().println("hello, view: " + new Date());
    }
}
