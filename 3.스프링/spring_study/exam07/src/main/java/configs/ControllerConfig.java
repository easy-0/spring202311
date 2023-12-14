package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("controllers")
public class ControllerConfig {
    /*
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public MemberController memberController() {
        return new MemberController();
    }

     */
}
