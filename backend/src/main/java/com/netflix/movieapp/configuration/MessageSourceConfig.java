package com.netflix.movieapp.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */

@Configuration
public class MessageSourceConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages/api_response_message","classpath:/messages/validation_message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}

