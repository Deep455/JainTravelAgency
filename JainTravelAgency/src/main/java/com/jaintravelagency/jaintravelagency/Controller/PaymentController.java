package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.Payment;
import com.jaintravelagency.jaintravelagency.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public class PaymentController {
    private PaymentService paymentService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public PaymentController(PaymentService paymentService, ApplicationEventPublisher applicationEventPublisher) {
        this.paymentService = paymentService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/paymentregister")
    public String register(Model model){
        model.addAttribute("payment", new Payment());
        return "paymentregister";
    }

    @GetMapping("/paymentregisterError")
    public String registerError(Model model){
        model.addAttribute("payment",new Payment());
        model.addAttribute("paymentregisterError",true);
        return "paymentregister";
    }

    @PostMapping("/paymentregister")
    public String register(@ModelAttribute("paymentregister") Payment payment, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(paymentService.paymentReceiptNoExists(payment.getPaymentReceiptNo())){
            return "redirect:/paymentregisterError";
        }

        paymentService.savePayment(payment);
        return "paymentregistersuccess";

    }

}
