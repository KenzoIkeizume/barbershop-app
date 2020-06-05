package core.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import core.barbershop.model.Company;
import core.barbershop.service.CompanyService;

/**
 * CompanyController
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/register/form")
    public ModelAndView companyRegisterView (){
        ModelAndView m = new ModelAndView("companyRegister");
        m.addObject("company", new Company());
        return m;
    }
  
    @PostMapping("/register")
    public String companyRegister(@ModelAttribute Company company){
        this.companyService.postCompany(company);
       
        return "redirect:/company/register/form";
    }
}