package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"org.example.service"})
@PropertySource("classpath:database.properties")
@Import({JdbcConfig.class, MyBatisConfig.class})
public class SpringConfig {
}
