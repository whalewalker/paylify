package com.paylify.config;

import com.paylify.client.flutterwave.FlutterwaveClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
public class FlutterwaveClientConfig  extends HttpClientConfig<FlutterwaveClient>{

    @Value("${flutterwave.base-url}")
    private String baseUrl;

    @Value("${flutterwave.secret-key}")
    private String secretKey;


    @Override
    protected WebClient.Builder configureClientBuilder(WebClient.Builder clientBuilder) {
        return clientBuilder
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + secretKey);
    }

    @Override
    protected Class<FlutterwaveClient> getClientType() {
        return FlutterwaveClient.class;
    }
}
