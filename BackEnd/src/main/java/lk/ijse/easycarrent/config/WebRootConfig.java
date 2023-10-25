package lk.ijse.easycarrent.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackages = "lk.ijse.easycarrent.service")
public class WebRootConfig {

}
