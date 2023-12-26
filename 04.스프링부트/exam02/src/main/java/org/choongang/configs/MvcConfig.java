package org.choongang.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 설정 클래스
@EnableJpaAuditing  // 변화감지 설정 활성화 + @EntityListeners(AuditingEntityListener.class) 변화감지 설정
public class MvcConfig implements WebMvcConfigurer {
}
