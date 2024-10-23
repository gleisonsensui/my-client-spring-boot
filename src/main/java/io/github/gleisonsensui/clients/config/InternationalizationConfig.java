package io.github.gleisonsensui.clients.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternationalizationConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSourceBundle = new ReloadableResourceBundleMessageSource();
        messageSourceBundle.setBasename("classpath:messages");
        messageSourceBundle.setDefaultEncoding("ISO-8859-1");
        messageSourceBundle.setDefaultLocale(Locale.getDefault());
        return  messageSourceBundle;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
