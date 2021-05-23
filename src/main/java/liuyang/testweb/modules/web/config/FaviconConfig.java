package liuyang.testweb.modules.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 看看这个会不会受默认静态资源配置影响
 * spring.mvc.static-path-pattern
 *
 * 参考文档：
 * 1. https://www.baeldung.com/spring-boot-favicon
 * 2. https://www.javadevjournal.com/spring-boot/spring-boot-favicon/
 *
 * @author liuyang(wx)
 * @since 2021/5/22
 */
//@Configuration
@Slf4j
// TODO 还没调试通
public class FaviconConfig {

    private static final String FAVICON_URL_PATH = "/favicon.ico";
    private static final String FAVICON_LOCATION = "/static/favicon/";// 订制位置

    @Bean
    public SimpleUrlHandlerMapping faviconHandlerMapping(@Qualifier("faviconRequestHandler") ResourceHttpRequestHandler faviconRequestHandler) {
        log.debug("faviconHandlerMapping!!");
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Integer.MIN_VALUE);
        mapping.setUrlMap(Collections.singletonMap(FAVICON_URL_PATH, faviconRequestHandler));
        return mapping;
    }

    @Bean
    public ResourceHttpRequestHandler faviconRequestHandler() {
        log.debug("faviconRequestHandler!!");
        ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
        ClassPathResource classPathResource = new ClassPathResource(FAVICON_LOCATION);
        List<Resource> locations = Arrays.asList(classPathResource);
        requestHandler.setLocations(locations);
        return requestHandler;
    }

}
