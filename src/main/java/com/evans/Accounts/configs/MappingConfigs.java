package com.evans.Accounts.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfigs {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
