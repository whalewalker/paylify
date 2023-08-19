package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitialTransferData {
    @JsonProperty("integration")
    int integration;

    @JsonProperty("domain")
    String domain;

    @JsonProperty("amount")
    int amount;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("source")
    String source;

    @JsonProperty("reason")
    String reason;

    @JsonProperty("recipient")
    int recipient;

    @JsonProperty("status")
    String status;

    @JsonProperty("transfer_code")
    String transferCode;

    @JsonProperty("id")
    int id;

    @JsonProperty("createdAt")
    LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    LocalDateTime updatedAt;

}
