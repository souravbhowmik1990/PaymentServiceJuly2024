package com.sourav.paymentservicejuly2024.Controllers;


import com.razorpay.RazorpayException;
import com.sourav.paymentservicejuly2024.DTOs.GeneratePaymentLinkRequestDto;
import com.sourav.paymentservicejuly2024.Services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    // http:localhost:8080/payments
    @PostMapping
    public String generatePaymentLinks(@RequestBody GeneratePaymentLinkRequestDto requestDto) throws RazorpayException {
        return paymentService.generatePaymentLink(requestDto.getOrderId());
    }
    public void handleWebhookEvent(){

    }

}
