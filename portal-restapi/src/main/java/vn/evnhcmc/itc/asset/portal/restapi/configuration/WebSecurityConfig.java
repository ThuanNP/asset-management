package vn.evnhcmc.itc.asset.portal.restapi.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
