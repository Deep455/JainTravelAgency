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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RegisterController {
    private EmployeeService employeeService;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public RegisterController(EmployeeService employeeService, ApplicationEventPublisher applicationEventPublisher) {
        this.employeeService = employeeService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @GetMapping("/registerError")
    public String registerError(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("empIdError",true);
        return "register";
    }

    @GetMapping("/showemployee")
    public String showemployee(Model model){
        List<Employee> employeeList = employeeService.showEmployee();
        model.addAttribute("employeelist", employeeList);
        return "showemployee";
    }

    @GetMapping("/deleteemployee")
    public String deleteemployee(Model model){
        model.addAttribute("employee", new Employee());
        return "deleteemployee";
    }

    @PostMapping("/deleteemployee")
    public String deleteemployee(@ModelAttribute("employee") Employee employee, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(employeeService.employeeIdExists(employee.getEmpId())){
            employeeService.deleteEmployee(employee.getEmpId());
            return "deleteemployeesuccess";
        }
        else{
            return "deleteemployeeerror";
        }

    }

    @PostMapping("/register")
    public String register(@ModelAttribute("employee") Employee employee, BindingResult result, WebRequest request, Model model, RedirectAttributes attributes){
        if(employeeService.employeeIdExists(employee.getEmpId())){
            return "redirect:/registerError";
        }

        employeeService.saveEmployee(employee);

        return "registersuccess";
    }


}
