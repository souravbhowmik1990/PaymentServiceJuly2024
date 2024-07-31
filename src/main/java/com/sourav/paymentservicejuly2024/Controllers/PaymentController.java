package com.sourav.paymentservicejuly2024.Controllers;


import com.sourav.paymentservicejuly2024.DTOs.GeneratePaymentLinkRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    // http:localhost:8080/payments
    @PostMapping
    public String generatePaymentLinks(@RequestBody GeneratePaymentLinkRequestDto requestDto){
        return null;
    }

    public void handleWebhookEvent(){

    }

}
