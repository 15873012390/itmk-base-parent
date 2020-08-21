package com.itmk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:跨域配置类
 * @version 1.0
 */
@Configuration
public class AppCorsConfiguration {
    private CorsConfiguration buildConfig() {
        CorsConfiguration appCorsConfiguration = new CorsConfiguration();
        appCorsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        appCorsConfiguration.addAllowedHeader("*"); // 2允许任何头
       // appCorsConfiguration.addAllowedMethod("{GET,HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH}"); // 3允许任何方法（post、get等）
        appCorsConfiguration.addAllowedMethod("OPTIONS");
        appCorsConfiguration.addAllowedMethod("HEAD");
        appCorsConfiguration.addAllowedMethod("GET");
        appCorsConfiguration.addAllowedMethod("PUT");
        appCorsConfiguration.addAllowedMethod("POST");
        appCorsConfiguration.addAllowedMethod("DELETE");
        appCorsConfiguration.addAllowedMethod("PATCH");
        appCorsConfiguration.setAllowCredentials(true);//这两句不加不能跨域上传文件，
        appCorsConfiguration.setMaxAge(3600l);//加上去就可
        return appCorsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}