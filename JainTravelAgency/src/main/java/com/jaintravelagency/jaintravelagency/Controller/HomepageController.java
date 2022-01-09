package com.jaintravelagency.jaintravelagency.Controller;

import com.jaintravelagency.jaintravelagency.Models.Employee;
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

@Controller
public class HomepageController {

    @RequestMapping({"/","","/homepage"})
    public String homepage(Model model) {
        return "homepage";
    }

}
