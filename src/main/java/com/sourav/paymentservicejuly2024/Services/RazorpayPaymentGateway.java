package com.sourav.paymentservicejuly2024.Services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentService{
    private RazorpayClient razorpayClient;

    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {
        // make a call to razorpay to generate the payment link;

        JSONObject paymentLinkRequest = new JSONObject();

        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        //paymentLinkRequest.put("accept_partial",true);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis() +10*60*1000);
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Payment for Cadbery");
        JSONObject customer = new JSONObject();
        customer.put("name","Sourav Bhowmik");
        customer.put("contact","9804005095");
        customer.put("email","souravbhowmik1990@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        //notes.put("policy_name","Jeevan Bima");
        //paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }
}
