package liuyang.testweb.modules.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.util.UrlPathHelper;

/**
 * Spring Boot环境中的默认配置，参见WebMvcAutoConfiguration.java
 *
 * @author liuyang(wx)
 * @since 2021/5/22
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 自定义主页
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 配置直接转发的映射
        // 联想XML配置方法
        // <mvc:view-controller path="/" view-name="liuyang_welcome.html"/>
        // 需要配合<mvc:annotation-driven/>标签一起使用，保证@RequestMapping有效。
        //
        registry.addViewController("/").setViewName("liuyang_welcome.html");
    }

    // 自定义RESTful风格表单提交时隐藏域的参数名。 默认未_mehtod
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }

    // 开启矩阵变量支持（默认情况下Spring Boot配置是不支持矩阵变量的）
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);// Spring Boot默认给出配置的UrlPathHelper是true。
        configurer.setUrlPathHelper(urlPathHelper);
    }

    // 自定义视图
    // 虽在WebMvcAutoConfiguration中已经配置了BeanNameViewResolver，但优先级太低，低于了Thymeleaf的ViewResolver
    // 所以干脆注入一个高优先级的
    @Bean
    public BeanNameViewResolver beanNameViewResolver() {
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        resolver.setOrder(10);
        return resolver;
    }


}
