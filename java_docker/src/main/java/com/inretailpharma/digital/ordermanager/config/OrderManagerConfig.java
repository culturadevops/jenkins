package com.inretailpharma.digital.ordermanager.config;

import com.inretailpharma.digital.ordermanager.config.parameters.ExternalServicesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@EnableConfigurationProperties({
        ExternalServicesProperties.class
})
public class OrderManagerConfig {

    @Autowired
    private ExternalServicesProperties externalServicesProperties;



    @Bean(name = "dispatcherRestTemplate")
    public RestTemplate createExternalRestTemplate(RestTemplateBuilder builder) {

        return builder
                .setConnectTimeout(
                        Duration.ofMillis(
                                Long.parseLong(externalServicesProperties.getDispatcherInsinkTrackerConnectTimeout())

                        )
                )
                .setReadTimeout(
                        Duration.ofMillis(
                                Long.parseLong(externalServicesProperties.getDispatcherInsinkTrackerReadTimeout())
                        )
                ).build();
    }


}
