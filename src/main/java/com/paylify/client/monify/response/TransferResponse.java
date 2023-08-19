package com.paylify.client.monify.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class TransferResponse {
    @JsonProperty("requestSuccessful")
    boolean requestSuccessful;

    @JsonProperty("responseMessage")
    String responseMessage;

    @JsonProperty("responseCode")
    String responseCode;

    @JsonProperty("responseBody")
    Data data;
}
