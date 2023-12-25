package com.feas.api.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Sherif Nouh
 * @Date ٢٠/٠٦/٢٠٢٣
 */
@Configuration
public class JacksonConfig {

    /*@Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.dateFormat(new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH)); // Specify the desired date format
        return builder;
    }*/
}