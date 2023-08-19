package com.paylify.client.paystack.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class FinalizeTransferRequest {
    @JsonProperty("transfer_code")
    String transferCode;

    @JsonProperty("otp")
    String otp;
}
