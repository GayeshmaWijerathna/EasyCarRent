package lk.ijse.easycarrent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "lk.ijse.easycarrent.repo")
public class JPAConfig {
}
