package liuyang.testweb.modules.web.config;

import liuyang.testweb.modules.web.interceptor.Hello01Interceptor;
import liuyang.testweb.modules.web.interceptor.Hello02Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置Spring MVC的Interceptor
 *
 * @author liuyang
 * @scine 2021/5/25
 */
// @Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    // 加上Interceptor之后：
    // 1. 为什么加上Interceptor之后 默认的首页跳转就没了？（成了404 2021/5/25）
    // 2. /hello还正常
    // 3. 返回字符串若是中文则乱码
    // 基于这些问题，先不加Interceptor了。

    // Spring Interceptor好处:可以使用Spring Framework的IoC服务

    @Autowired
    Hello01Interceptor hello01Interceptor;// 这样interceptor中就可以@Autowired进容器的组件了。

    @Autowired
    Hello02Interceptor hello02Interceptor;// 这样interceptor中就可以@Autowired进容器的组件了。

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // super.addInterceptors(registry);
        // registry.addInterceptor(new Hello01Interceptor()); // 自己new的无法获得容器提供的织入服务
        // registry.addInterceptor(new Hello02Interceptor()); // 自己new的无法获得容器提供的织入服务

        registry.addInterceptor(hello01Interceptor);
        registry.addInterceptor(hello02Interceptor);

        // 更灵活的配置演示
        /*
        registry.addInterceptor(new Hello02Interceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/aa/**", "/sql/**", "/city");
        */
    }
}
