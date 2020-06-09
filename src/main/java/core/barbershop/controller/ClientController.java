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

    @GetMapping("/list")
    public ModelAndView companieList(){
        List<Client> clients = this.clientService.findAllClient();

        ModelAndView m = new ModelAndView("clientsView");
        m.addObject("clients", clients);
        return m;
    }

    @GetMapping("/{id}")
    public ModelAndView getClient(
        @PathVariable("id") Integer id
    ){
        Client client = this.clientService.getClient(id);

        ModelAndView m = new ModelAndView("clientView");
        m.addObject("client", client);
        return m;
    }
}