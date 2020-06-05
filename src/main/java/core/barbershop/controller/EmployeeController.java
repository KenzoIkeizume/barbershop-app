package core.barbershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import core.barbershop.model.Company;
import core.barbershop.model.Employee;
import core.barbershop.service.CompanyService;
import core.barbershop.service.EmployeeService;

/**
 * EmployeeController
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private CompanyService companyService;

    @GetMapping("/register/form")
    public ModelAndView employeeRegisterView (){
        ModelAndView m = new ModelAndView("employeeRegister");
        List<Company> companies = this.companyService.findAllCompany();
        m.addObject("companies", companies);
        m.addObject("employee", new Employee());
        return m;
    }
  
    @PostMapping("/register")
    public String employeeRegister(@ModelAttribute Employee employee){
        this.employeeService.postEmployee(employee);
        
        return "redirect:/employee/register/form";
    }
}