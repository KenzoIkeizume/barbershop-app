package core.barbershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Company> employees = this.companyService.findAllCompany();
        m.addObject("employees", employees);
        m.addObject("employee", new Employee());
        return m;
    }
  
    @PostMapping("/register")
    public String employeeRegister(@ModelAttribute Employee employee){
        this.employeeService.postEmployee(employee);
        
        return "redirect:/employee/register/form";
    }

    @GetMapping("/list")
    public ModelAndView employeeList(){
        List<Employee> employees = this.employeeService.findAllEmployee();

        ModelAndView m = new ModelAndView("employeesView");
        m.addObject("employees", employees);
        return m;
    }

    @GetMapping("/{id}")
    public ModelAndView getEmployee(
        @PathVariable("id") Integer id
    ){
        Employee employee = this.employeeService.getEmployee(id);

        ModelAndView m = new ModelAndView("employeeView");
        m.addObject("employee", employee);
        return m;
    }
}