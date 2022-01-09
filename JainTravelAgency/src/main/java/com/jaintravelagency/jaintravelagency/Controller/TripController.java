package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.Trip;
import com.jaintravelagency.jaintravelagency.Services.TripService;
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
public class TripController {
    private TripService tripService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public TripController(TripService tripService, ApplicationEventPublisher applicationEventPublisher) {
        this.tripService = tripService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/tripregister")
    public String register(Model model){
        model.addAttribute("trip", new Trip());
        return "tripregister";
    }

    @GetMapping("/tripregisterError")
    public String registerError(Model model){
        model.addAttribute("trip",new Trip());
        model.addAttribute("tripError",true);
        return "tripregister";
    }

    @GetMapping("/showtrip")
    public String showtrip(Model model){
        List<Trip> tripList = tripService.showTrip();
        model.addAttribute("triplist", tripList);
        return "showtrip";
    }

    @GetMapping("/deletetrip")
    public String deletetrip(Model model){
        model.addAttribute("trip", new Trip());
        return "deletetrip";
    }

    @PostMapping("/deletetrip")
    public String deletetrip(@ModelAttribute("trip") Trip trip, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(tripService.tripNoExists(trip.getTripNo())){
            tripService.deleteTrip(trip.getTripNo());
            return "deletetripsuccess";
        }
        else{
            return "deletetriperror";
        }

    }

    @PostMapping("/tripregister")
    public String register(@ModelAttribute("trip") Trip trip, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(tripService.tripNoExists(trip.getTripNo())){
            return "redirect:/tripregisterError";
        }

        tripService.saveTrip(trip);
        return "tripregistersuccess";

    }
}
