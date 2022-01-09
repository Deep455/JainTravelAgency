package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.Employee;
import com.jaintravelagency.jaintravelagency.Repository.EmployeeRepository;
import com.jaintravelagency.jaintravelagency.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {
    private EmployeeService employeeService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public LoginController(EmployeeService employeeService, ApplicationEventPublisher applicationEventPublisher) {
        this.employeeService = employeeService;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("employee", new Employee());
        return "login";
    }

    @RequestMapping("/loggedhomepage")
    public String welcome(Principal principal, Model model){
        Employee employee = employeeService.findEmployeeByEmpId(principal.getName());

        return "loggedhomepage";
    }

    @RequestMapping("/accessdenied")
    public String accessDenied(){
        return "accessdenied";
    }



}
