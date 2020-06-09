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

import core.barbershop.model.Client;
import core.barbershop.model.Company;
import core.barbershop.model.Employee;
import core.barbershop.model.Schedule;
import core.barbershop.service.ClientService;
import core.barbershop.service.CompanyService;
import core.barbershop.service.EmployeeService;
import core.barbershop.service.ScheduleService;

/**
 * ScheduleController
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/register/form")
    public ModelAndView scheduleRegisterView (){
        ModelAndView m = new ModelAndView("scheduleRegister");
        List<Client> clients = this.clientService.findAllClient();
        List<Company> companies = this.companyService.findAllCompany();
        List<Employee> employees = this.employeeService.findAllEmployee();
        m.addObject("schedule", new Schedule());
        m.addObject("clients", clients);
        m.addObject("companies", companies);
        m.addObject("employees", employees);
        return m;
    }
  
    @PostMapping("/register")
    public String scheduleRegister(@ModelAttribute Schedule schedule){
        this.scheduleService.postSchedule(schedule);
       
        return "redirect:/schedule/register/form";
    }

    @GetMapping("/list")
    public ModelAndView scheduleList(){
        List<Schedule> schedules = this.scheduleService.findAllSchedule();

        ModelAndView m = new ModelAndView("schedulesView");
        m.addObject("schedules", schedules);
        return m;
    }

    @GetMapping("/{id}")
    public ModelAndView getSchedule(
        @PathVariable("id") Integer id
    ){
        Schedule schedule = this.scheduleService.getSchedule(id);

        ModelAndView m = new ModelAndView("scheduleView");
        m.addObject("schedule", schedule);
        return m;
    }

    @GetMapping("/delete/{id}")
    public String deleteSchedule(
        @PathVariable("id") Integer id
    ){
        this.scheduleService.deleteSchedule(id);

        return "redirect:/schedule/list";
    }
}