package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RecipientDetails {
    @JsonProperty("authorization_code")
    String authorizationCode;

    @JsonProperty("account_number")
    String accountNumber;

    @JsonProperty("account_name")
    String accountName;

    @JsonProperty("bank_code")
    String bankCode;

    @JsonProperty("bank_name")
    String bankName;
}
