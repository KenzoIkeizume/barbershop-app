package core.barbershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController
 */
@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping()
    public ModelAndView home(){
        ModelAndView m = new ModelAndView("homeView");
        return m;
    }
}
