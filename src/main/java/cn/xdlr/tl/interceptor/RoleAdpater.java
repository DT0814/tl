package cn.xdlr.tl.interceptor;

import cn.xdlr.tl.service.ClientAcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class RoleAdpater implements WebMvcConfigurer {
    @Autowired
    private ClientAcodeService service;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new RoleInterceptor(service))
                .addPathPatterns("/user/**")
                .addPathPatterns("/token/**")
                .addPathPatterns("/Exhibition/**");
    }
}
