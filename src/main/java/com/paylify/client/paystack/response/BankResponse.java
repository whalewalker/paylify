package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
public class BankResponse {
    @JsonProperty("status")
      boolean status;

    @JsonProperty("message")
      String message;

    @JsonProperty("data")
    List<BankData> data;
}
