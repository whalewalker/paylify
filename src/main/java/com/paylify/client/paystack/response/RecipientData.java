package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class RecipientData {
    @JsonProperty("active")
    Boolean active;

    @JsonProperty("createdAt")
    String createdAt;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("domain")
    String domain;

    @JsonProperty("id")
    Long id;

    @JsonProperty("integration")
    Integer integration;

    @JsonProperty("name")
    String name;

    @JsonProperty("recipient_code")
    String recipientCode;

    @JsonProperty("type")
    String type;

    @JsonProperty("updatedAt")
    String updatedAt;

    @JsonProperty("is_deleted")
    Boolean isDeleted;

    @JsonProperty("details")
    RecipientDetails details;
}
