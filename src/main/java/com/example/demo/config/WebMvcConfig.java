package com.example.demo.config;

import com.example.demo.filter.RequestParamaFilter;
import com.example.demo.interceptor.RequestViewInterceptor;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${server.http.port}")
    private Integer httpPort;
    @Autowired
    private RequestViewInterceptor requestViewInterceptor;
    @Autowired
    private ResourceConfigBean resourceConfigBean;
    @Bean
    public Connector connector() {
        Connector connector = new Connector();
        connector.setPort(httpPort);
        connector.setScheme("http");
        return connector;
    }

    @Bean
    public ServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(connector());
        return tomcatServletWebServerFactory;
    }

    @Bean
    public FilterRegistrationBean<RequestParamaFilter> register() {
        FilterRegistrationBean<RequestParamaFilter> register = new FilterRegistrationBean<RequestParamaFilter>();
        register.setFilter(new RequestParamaFilter());
        return register;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestViewInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String osName = System.getProperty("os.name");

        if (osName.startsWith("Win")) {
            registry.addResourceHandler(resourceConfigBean.getRelativePathPattern()).addResourceLocations(ResourceUtils.FILE_URL_PREFIX + resourceConfigBean.getLocationPathForWindows());
        } else if (osName.startsWith("Mac")){
            registry.addResourceHandler(resourceConfigBean.getRelativePathPattern()).addResourceLocations(ResourceUtils.FILE_URL_PREFIX + resourceConfigBean.getLocationPathForMacOS());
        } else {
            registry.addResourceHandler(resourceConfigBean.getRelativePathPattern()).addResourceLocations(ResourceUtils.FILE_URL_PREFIX + resourceConfigBean.getLocationPathForLinux());
        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("welcome");
    }
}
