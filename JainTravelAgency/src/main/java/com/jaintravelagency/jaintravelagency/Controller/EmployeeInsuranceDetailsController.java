package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.EmployeeInsuranceDetails;
import com.jaintravelagency.jaintravelagency.Services.EmployeeInsuranceDetailsService;
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


public class EmployeeInsuranceDetailsController {

    private EmployeeInsuranceDetailsService employeeInsuranceDetailsService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public EmployeeInsuranceDetailsController(EmployeeInsuranceDetailsService employeeInsuranceDetailsService, ApplicationEventPublisher applicationEventPublisher) {
        this.employeeInsuranceDetailsService = employeeInsuranceDetailsService;
        this.applicationEventPublisher = applicationEventPublisher;
    }



    @GetMapping("/employeeinsurancedetailsregister")
    public String register(Model model){
        model.addAttribute("employeeInsuranceDetails", new EmployeeInsuranceDetails());
        return "employeeinsurancedetailsregister";
    }

    @GetMapping("/employeeinsurancedetailsregisterError")
    public String registerError(Model model){
        model.addAttribute("employeeInsuranceDetails",new EmployeeInsuranceDetails());
        model.addAttribute("vehicleError",true);
        return "employeeinsurancedetailsregister";
    }

    @PostMapping("/employeeinsurancedetailsregister")
    public String register(@ModelAttribute("employeeInsuranceDetails") EmployeeInsuranceDetails employeeInsuranceDetails, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(employeeInsuranceDetailsService.EmployeeInsuranceNoExists(employeeInsuranceDetails.getInsuranceNo())){
            return "redirect:/employeeinsurancedetailsregisterError";
        }

        employeeInsuranceDetailsService.saveEmployeeInsuranceDetails(employeeInsuranceDetails);
        return "employeeinsurancedetailsregistersuccess";
    }
}
