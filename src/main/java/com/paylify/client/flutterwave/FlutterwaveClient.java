package com.paylify.client.flutterwave;

import com.paylify.client.flutterwave.request.TransferRequest;
import com.paylify.client.flutterwave.response.TransferResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "/v3/transfers", accept = MediaType.APPLICATION_JSON_VALUE, contentType = MediaType.APPLICATION_JSON_VALUE)
public interface FlutterwaveClient {

    @PostExchange
    TransferResponse transfer(TransferRequest request);

    @GetExchange("/{id}")
    TransferResponse verifyTransfer(@PathVariable int id);
}
