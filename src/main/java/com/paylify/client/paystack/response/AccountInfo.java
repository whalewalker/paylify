package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AccountInfo {
    @JsonProperty("status")
     boolean status;

    @JsonProperty("message")
     String message;

    @JsonProperty("data")
     AccountData data;
}
