package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class FinalizeTransferResponse {
    @JsonProperty("status")
    Boolean status;

    @JsonProperty("message")
    String message;

    @JsonProperty("data")
    FinalizeData data;
}
