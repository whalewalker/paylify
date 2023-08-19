package com.paylify.client.flutterwave.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Value
 public class TransferResponse {

    @JsonProperty("status")
     String status;

    @JsonProperty("message")
     String message;

    @JsonProperty("data")
     Data data;
}
