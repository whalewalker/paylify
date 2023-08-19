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
public class Data {
    @JsonProperty("id")
    Long id;

    @JsonProperty("account_number")
    String accountNumber;

    @JsonProperty("bank_code")
    String bankCode;

    @JsonProperty("full_name")
    String fullName;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("debit_currency")
    String debitCurrency;

    @JsonProperty("amount")
    Integer amount;

    @JsonProperty("fee")
    Integer fee;

    @JsonProperty("status")
    String status;

    @JsonProperty("reference")
    String reference;

    @JsonProperty("meta")
    Object meta;

    @JsonProperty("narration")
    String narration;

    @JsonProperty("complete_message")
    String completeMessage;

    @JsonProperty("requires_approval")
    Integer requiresApproval;

    @JsonProperty("is_approved")
    Integer isApproved;

    @JsonProperty("bank_name")
    String bankName;
}
