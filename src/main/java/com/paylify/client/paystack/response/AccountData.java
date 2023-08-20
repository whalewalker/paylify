package com.paylify.client.paystack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AccountData {
    @JsonProperty("account_number")
     String accountNumber;

    @JsonProperty("account_name")
     String accountName;

    @JsonProperty("bank_id")
     int bankId;
}
