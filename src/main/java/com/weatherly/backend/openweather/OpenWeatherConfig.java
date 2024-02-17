package com.weatherly.backend.openweather;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class OpenWeatherConfig {
    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Bean
    @Qualifier("openWeatherRestTemplate")
    public RestTemplate openWeatherRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(apiUrl));
        restTemplate.getInterceptors().add((request, body, execution) -> {
            return execution.execute(request, body);
        });
        return restTemplate;
    }

    @Bean(name = "openWeatherApiKey")
    public String getApiKey() {
        return apiKey;
    }
}
