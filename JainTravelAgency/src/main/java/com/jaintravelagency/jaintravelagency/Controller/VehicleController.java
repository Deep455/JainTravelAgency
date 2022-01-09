package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.Vehicle;
import com.jaintravelagency.jaintravelagency.Services.VehicleService;
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

import java.util.List;

@Controller
public class VehicleController {
    private VehicleService vehicleService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public VehicleController(VehicleService vehicleService, ApplicationEventPublisher applicationEventPublisher) {
        this.vehicleService = vehicleService;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @GetMapping("/vehicleregister")
    public String register(Model model){
        model.addAttribute("vehicle", new Vehicle());
        return "vehicleregister";
    }

    @GetMapping("/showvehicle")
    public String showvehicle(Model model){
        List<Vehicle> vehicleList = vehicleService.showVehicle();
        model.addAttribute("vehiclelist", vehicleList);
        return "showvehicle";
    }

    @GetMapping("/deletevehicle")
    public String deletevehicle(Model model){
        model.addAttribute("vehicle", new Vehicle());
        return "deletevehicle";
    }

    @PostMapping("/deletevehicle")
    public String deletevehicle(@ModelAttribute("vehicle") Vehicle vehicle, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(vehicleService.vehicleRegNoExists(vehicle.getRegNo())){
            vehicleService.deleteVehicle(vehicle.getRegNo());
            return "deletevehiclesuccess";
        }
        else{
            return "deletevehicleerror";
        }

    }




    @GetMapping("/vehicleregisterError")
    public String registerError(Model model){
        model.addAttribute("vehicle",new Vehicle());
        model.addAttribute("vehicleError",true);
        return "vehicleregister";
    }

    @PostMapping("/vehicleregister")
    public String register(@ModelAttribute("vehicle") Vehicle vehicle, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(vehicleService.vehicleRegNoExists(vehicle.getRegNo())){
            return "redirect:/vehicleregisterError";
        }

        vehicleService.saveVehicle(vehicle);
        return "vehicleregistersuccess";
    }
}
