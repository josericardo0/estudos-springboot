package controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("nome")
public class BemvindoController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String irParaPaginaLogin(Model modelo){
        modelo.addAttribute("nome", continueLogadoUsuario());
        return "bemvindo";
    }

    private String continueLogadoUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
