package com.paylify.client.monify;

import com.paylify.client.monify.request.InitiateTransferRequest;
import com.paylify.client.monify.response.TransferResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "/api/v2/disbursements/single", accept = MediaType.APPLICATION_JSON_VALUE, contentType = MediaType.APPLICATION_JSON_VALUE)

public interface MonifyClient {
    @PostExchange
    TransferResponse initiateTransfer(InitiateTransferRequest request);

    @GetExchange("/summary")
    TransferResponse verifyTransfer(@RequestParam String reference);
}
