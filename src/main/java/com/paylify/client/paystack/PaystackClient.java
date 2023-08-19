package com.paylify.client.paystack;

import com.paylify.client.paystack.request.FinalizeTransferRequest;
import com.paylify.client.paystack.request.InitiateTransferRequest;
import com.paylify.client.paystack.request.RecipientRequest;
import com.paylify.client.paystack.response.FinalizeTransferResponse;
import com.paylify.client.paystack.response.RecipientResponse;
import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(accept = MediaType.APPLICATION_JSON_VALUE, contentType = MediaType.APPLICATION_JSON_VALUE)
public interface PaystackClient {
    @PostExchange(value = "/transferrecipient")
    RecipientResponse createRecipient(RecipientRequest request);

    @PostExchange(value = "/transfer")
    InitiateTransferRequest initiateTransfer(InitiateTransferRequest request);

    @PostExchange(value = "/finalize_transfer")
    FinalizeTransferResponse finalizeTransfer(FinalizeTransferRequest request);

}
