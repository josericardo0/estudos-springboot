package service;

import org.springframework.stereotype.Service;

@Service
public class AutheticationService {

    public boolean authenticate (String nomeDeUsuario, String senha) {

        boolean isNomeUsuarioValido = nomeDeUsuario.equalsIgnoreCase("Zecardinho");
        boolean isSenhaValida = senha.equalsIgnoreCase("1234567");

        return isNomeUsuarioValido && isSenhaValida;
    }
}
