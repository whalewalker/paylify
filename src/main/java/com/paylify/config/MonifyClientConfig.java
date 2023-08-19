package com.paylify.config;

import com.paylify.client.monify.MonifyClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class MonifyClientConfig extends HttpClientConfig<MonifyClient>{
    @Value("${monify.base-url}")
    private String baseUrl;

    @Value("${monify.secret-key}")
    private String secretKey;

    @Override
    protected WebClient.Builder configureClientBuilder(WebClient.Builder clientBuilder) {
        return clientBuilder
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + secretKey);
    }

    @Override
    protected Class<MonifyClient> getClientType() {
        return MonifyClient.class;
    }
}
