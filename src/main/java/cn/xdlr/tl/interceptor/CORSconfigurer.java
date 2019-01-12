package cn.xdlr.tl.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSconfigurer implements WebMvcConfigurer {
    // 浏览器端跨域访问的处理！！ 该问题需在浏览器端解决~  下面代码可临时应付
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedMethods("*")
//                .allowedHeaders("*");
    }
}
