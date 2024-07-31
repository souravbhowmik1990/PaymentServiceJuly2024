package com.sourav.paymentservicejuly2024.Services;

import com.razorpay.RazorpayException;

public interface PaymentService {
    public String generatePaymentLink(Long orderId) throws RazorpayException;

}
