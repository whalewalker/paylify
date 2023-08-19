package com.paylify.client.paystack.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipientRequest {
    @JsonProperty("type")
    String type;

    @JsonProperty("name")
    String name;

    @JsonProperty("account_number")
    String accountNumber;

    @JsonProperty("bank_code")
    String bankCode;

    @JsonProperty("currency")
    String currency;
}
