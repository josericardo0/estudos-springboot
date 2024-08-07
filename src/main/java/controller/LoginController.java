package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.AutheticationService;

@Controller
public class LoginController {

    private final AutheticationService autheticationService;

    public LoginController(AutheticationService autheticationService) {
        super();
        this.autheticationService = autheticationService;
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String irParaPaginaLogin(){
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String irParaPaginaBoasVindas(@RequestParam String nome, @RequestParam String senha, ModelMap modelo) {
        if (autheticationService.authenticate(nome, senha)) {
            modelo.put("nome", nome);
            modelo.put("senha", senha);
            return "bemvindo";
        }
        return "login";
    }
}
