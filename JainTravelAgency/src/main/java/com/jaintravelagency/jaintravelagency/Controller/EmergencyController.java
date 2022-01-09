package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.Emergency;
import com.jaintravelagency.jaintravelagency.Services.EmergencyService;
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


public class EmergencyController {
    private EmergencyService emergencyService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public EmergencyController(EmergencyService emergencyService, ApplicationEventPublisher applicationEventPublisher) {
        this.emergencyService = emergencyService;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @GetMapping("/emergencyregister")
    public String register(Model model){
        model.addAttribute("emergency", new Emergency());
        return "emergencyregister";
    }

    @GetMapping("/emergencyregisterError")
    public String registerError(Model model){
        model.addAttribute("emergency",new Emergency());
        model.addAttribute("emergencyError",true);
        return "emergencyregister";
    }

    @PostMapping("/emergencyeregister")
    public String register(@ModelAttribute("vehicle") Emergency emergency, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(emergencyService.EmergencyNoExists(emergency.getPhoneNo())){
            return "redirect:/emergencyregisterError";
        }
        emergencyService.saveEmergency(emergency);
        return "emergencyregistersuccess";
    }
}
