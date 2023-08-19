package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class RecipientResponse {

    @JsonProperty("status")
    public boolean status;

    @JsonProperty("message")
    public String message;

    @JsonProperty("data")
    public RecipientData data;
}
