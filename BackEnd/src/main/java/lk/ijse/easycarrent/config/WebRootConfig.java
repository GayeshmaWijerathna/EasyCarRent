package lk.ijse.easycarrent.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackages = "lk.ijse.easycarrent.service")
public class WebRootConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}