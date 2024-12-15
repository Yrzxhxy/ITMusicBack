package com.javaclimb.itmusic.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {



    /*
    * 跨域
    * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("localhost") // 允许所有域
//                .allowedMethods("*") // 允许所有方法（GET、POST、PUT、DELETE等）
                .allowCredentials(true) // 允许携带凭证（如Cookies）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600); // 预检请求的缓存时间（秒）
    }


}