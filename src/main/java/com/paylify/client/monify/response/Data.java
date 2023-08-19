package com.paylify.client.monify.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {
    @JsonProperty("amount")
    int amount;

    @JsonProperty("reference")
    String reference;

    @JsonProperty("status")
    String status;

    @JsonProperty("dateCreated")
    LocalDateTime dateCreated;

    @JsonProperty("totalFee")
    int totalFee;

    @JsonProperty("transactionDescription")
    String transactionDescription;

    @JsonProperty("destinationAccountName")
    String destinationAccountName;

    @JsonProperty("destinationBankName")
    String destinationBankName;

    @JsonProperty("destinationAccountNumber")
    String destinationAccountNumber;

    @JsonProperty("destinationBankCode")
    String destinationBankCode;
}
