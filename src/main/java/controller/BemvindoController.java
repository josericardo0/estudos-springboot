package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BemvindoController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String irParaPaginaLogin(Model modelo){
        modelo.addAttribute("nome", "José Ricardo");
        return "bemvindo";
    }

}
