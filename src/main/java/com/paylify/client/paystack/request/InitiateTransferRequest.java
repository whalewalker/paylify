package com.paylify.client.paystack.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitiateTransferRequest {
    @JsonProperty("source")
    String source;

    @JsonProperty("reason")
    String reason;

    @JsonProperty("amount")
    Integer amount;

    @JsonProperty("recipient")
    String recipient;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("reference")
    String reference;
}
