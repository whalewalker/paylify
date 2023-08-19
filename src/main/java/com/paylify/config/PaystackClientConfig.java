package com.paylify.config;

import com.paylify.client.paystack.PaystackClient;
import com.paylify.web.exception.PayStackException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class PaystackClientConfig  extends HttpClientConfig<PaystackClient>{

    @Value("${paystack.base-url}")
    private String baseUrl;

    @Value("${paystack.secret-key}")
    private String secretKey;


    @Override
    protected WebClient.Builder configureClientBuilder(WebClient.Builder clientBuilder) {
        return clientBuilder
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + secretKey);
    }

    @Override
    protected Class<PaystackClient> getClientType() {
        return PaystackClient.class;
    }

    @Override
    protected Mono<? extends Throwable> handleStatusError(ClientResponse resp) {
        var mediaType = resp.headers().contentType();
        if(mediaType.isPresent() && mediaType.get().equals(MediaType.TEXT_HTML)) {
            log.error("Error while calling endpoint with status code {}", resp.statusCode());
            return Mono.error(new PayStackException("CBA is down", "91-30"));
        }
        return super.handleStatusError(resp);
    }

    @Bean(name = "paystackWebClientBuilder")
    public WebClient.Builder paystackWebClientBuilder() {
        return WebClient.builder();
    }
}
