package com.feas.domain.config;

/**
 * @author Sherif Nouh
 * @Date ١٠/٠٩/٢٠٢٣
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Date;

@Configuration
public class DomainJacksonConfig {
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        builder.deserializerByType(Date.class, new CustomDateDeserializer());
        return builder.build();
    }
}