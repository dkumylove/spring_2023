package com.choongang.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableScheduling   // 스케줄 설정 자동화
@EnableConfigurationProperties(FileProperties.class)
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private FileProperties fileProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 설정파일에 경로를 입력해 놓았기 때문에 fileProperties.getUrl(),fileProperties.getPath() 경로 호출
        registry.addResourceHandler(fileProperties.getUrl() + "**")
                .addResourceLocations("file:///" + fileProperties.getPath());
    }
}
