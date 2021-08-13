package dev.ant04x.pruebatecnicateralco.configurations;

import dev.ant04x.pruebatecnicateralco.controllers.interceptors.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorsConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Logger(1)).addPathPatterns("/price/**");
        registry.addInterceptor(new Logger(2)).addPathPatterns("/cars/**");
        super.addInterceptors(registry);
    }
}
