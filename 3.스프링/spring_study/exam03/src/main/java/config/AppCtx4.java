package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("models")    // 설정 범위를 value값으로 작성
public class AppCtx4 {
}
