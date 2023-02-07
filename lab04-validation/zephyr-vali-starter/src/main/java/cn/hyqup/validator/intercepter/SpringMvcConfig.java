package cn.hyqup.validator.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//@ComponentScan({"cn.hyqup.validator"})
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Bean
    public ValiIntercepter valiIntercepter() {
        return new ValiIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(valiIntercepter()).addPathPatterns("/**");
    }

}
