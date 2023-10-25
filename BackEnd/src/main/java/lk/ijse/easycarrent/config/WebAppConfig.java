package lk.ijse.easycarrent.config;

import lk.ijse.easycarrent.advisor.AppWideExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AppWideExceptionHandler.class},basePackages = "lk.ijse.easycarrent.controller")
public class WebAppConfig {


}
