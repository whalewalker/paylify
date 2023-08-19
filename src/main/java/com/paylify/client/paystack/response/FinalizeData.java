package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FinalizeData {
    @JsonProperty("domain")
    String domain;

    @JsonProperty("amount")
    Integer amount;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("reference")
    String reference;

    @JsonProperty("source")
    String source;

    @JsonProperty("source_details")
    Object sourceDetails;

    @JsonProperty("reason")
    String reason;

    @JsonProperty("status")
    String status;

    @JsonProperty("failures")
    Object failures;

    @JsonProperty("transfer_code")
    String transferCode;

    @JsonProperty("titan_code")
    String titanCode;

    @JsonProperty("transferred_at")
    String transferredAt;

    @JsonProperty("id")
    Long id;

    @JsonProperty("integration")
    Integer integration;

    @JsonProperty("recipient")
    Long recipient;

    @JsonProperty("createdAt")
    String createdAt;

    @JsonProperty("updatedAt")
    String updatedAt;
}
