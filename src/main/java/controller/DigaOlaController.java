package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DigaOlaController {

    @RequestMapping("diga-ola")
    @ResponseBody
    public String digaOla() {
        return "Olá! O que você está estudando hoje?";
    }


    @RequestMapping("diga-ola-html")
    @ResponseBody
    public String digaOlaHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> Praticando Spring Boot </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Minha primeira página HTML com corpo!");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

}
