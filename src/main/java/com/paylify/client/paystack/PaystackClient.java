package com.paylify.client.paystack;

import com.paylify.client.paystack.request.FinalizeTransferRequest;
import com.paylify.client.paystack.request.InitiateTransferRequest;
import com.paylify.client.paystack.request.RecipientRequest;
import com.paylify.client.paystack.response.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(accept = MediaType.APPLICATION_JSON_VALUE, contentType = MediaType.APPLICATION_JSON_VALUE)
public interface PaystackClient {
    @PostExchange(value = "/transferrecipient")
    RecipientResponse createRecipient(RecipientRequest request);

    @PostExchange(value = "/transfer")
    InitiateTransferResponse initiateTransfer(InitiateTransferRequest request);

    @PostExchange(value = "/finalize_transfer")
    FinalizeTransferResponse finalizeTransfer(FinalizeTransferRequest request);

    @GetExchange(value = "/{id}")
    FinalizeTransferResponse verifyTransfer(@PathVariable String id);

    @GetExchange(value = "/bank")
    BankResponse banks();

    @GetExchange("/bank/resolve")
    AccountInfo inquiry(@RequestParam("account_number") String accountNumber, @RequestParam("bank_code") String bankCode);
}
