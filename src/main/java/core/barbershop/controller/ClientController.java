package core.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import core.barbershop.model.Client;
import core.barbershop.service.ClientService;

/**
 * ClientController
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/register/form")
    public ModelAndView clientRegisterView (){
        ModelAndView m = new ModelAndView("clientRegister");
        m.addObject("client", new Client());
        return m;
    }
  
    @PostMapping("/register")
    public String clientRegister(@ModelAttribute Client client){
        this.clientService.postClient(client);
       
        return "redirect:/client/register/form";
    }
}