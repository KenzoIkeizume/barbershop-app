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

    @GetMapping("/list")
    public ModelAndView companieList(){
        List<Company> companies = this.companyService.findAllCompany();

        ModelAndView m = new ModelAndView("companiesView");
        m.addObject("companies", companies);
        return m;
    }

    @GetMapping("/{id}")
    public ModelAndView getCompany(
        @PathVariable("id") Integer id
    ){
        Company company = this.companyService.getCompany(id);

        ModelAndView m = new ModelAndView("companyView");
        m.addObject("company", company);
        return m;
    }
}