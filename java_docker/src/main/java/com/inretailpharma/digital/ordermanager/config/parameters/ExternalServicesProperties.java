package com.inretailpharma.digital.ordermanager.config.parameters;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "external-service")
public class ExternalServicesProperties {


    @Value("${external-service.audit.create-order}")
    private String uriApiService;

    @Value("${external-service.audit.time-out}")
    private Integer timeout;

    @Value("${external-service.dispatcher.insink-tracker.uri}")
    private String dispatcherInsinkTrackerUri;

    @Value("${external-service.dispatcher.insink-tracker.connect-timeout}")
    private String dispatcherInsinkTrackerConnectTimeout;

    @Value("${external-service.dispatcher.insink-tracker.read-timeout}")
    private String dispatcherInsinkTrackerReadTimeout;

    @Value("${external-service.dispatcher.tracker.uri}")
    private String dispatcherTrackerUri;

    @Value("${external-service.dispatcher.tracker.connect-timeout}")
    private String dispatcherTrackerConnectTimeout;

    @Value("${external-service.dispatcher.tracker.read-timeout}")
    private String dispatcherTrackerReadTimeout;

}
