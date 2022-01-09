package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.Customer;
import com.jaintravelagency.jaintravelagency.Services.CustomerService;
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


public class CustomerController {
    private CustomerService customerService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CustomerController(CustomerService customerService, ApplicationEventPublisher applicationEventPublisher) {
        this.customerService = customerService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/cutomerregister")
    public String register(Model model){
        model.addAttribute("customer", new Customer());
        return "customerregister";
    }

    @GetMapping("/customerregisterError")
    public String registerError(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerIdError",true);
        return "customerregister";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("customer") Customer customer, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(customerService.customerIdExists(customer.getCustomerId())){
            return "redirect:/customerregisterError";
        }

        customerService.saveCustomer(customer);

        return "customerregistersuccess";
    }


}

