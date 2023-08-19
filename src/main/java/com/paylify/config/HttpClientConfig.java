package com.paylify.config;

import com.paylify.web.exception.PaylifyException;
import io.netty.handler.logging.LogLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Slf4j
@Configuration
public abstract class HttpClientConfig<T> {
    @Bean
    public T createClient(WebClient.Builder webClientBuilder) {
        HttpClient httpClient = HttpClient.create()
                .proxyWithSystemProperties()
                .wiretap("reactor.netty.http.client.HttpClient", LogLevel.INFO, AdvancedByteBufFormat.TEXTUAL, StandardCharsets.UTF_8);

        WebClient.Builder clientBuilder = webClientBuilder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultStatusHandler(HttpStatusCode::isError, this::handleStatusError);

        clientBuilder = configureClientBuilder(clientBuilder);

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(clientBuilder.build()))
                .blockTimeout(Duration.ofSeconds(60))
                .build();

        return factory.createClient(getClientType());
    }

    protected abstract WebClient.Builder configureClientBuilder(WebClient.Builder clientBuilder);

    protected abstract Class<T> getClientType();

    protected Mono<? extends Throwable> handleStatusError(ClientResponse webClientResponse) {
        log.error("Error while calling endpoint with status code {}", webClientResponse.statusCode());
        return webClientResponse.bodyToMono(Object.class).flatMap(err -> Mono.error(new PaylifyException(err)));
    }

}
