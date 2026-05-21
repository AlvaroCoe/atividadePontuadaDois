package com.example.atividadePontuadaDois.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @RestController
    public class BemVindo {
        @GetMapping("/")
        public String mensagem() {
            return "Seja bem vindo à segunda atividade Pontuada!";
        }

        @GetMapping("/dev")
        public String nomeDev() {
            return "Meu nome é Alvaro Coelho." +
                    " Acesse http://localhost:8080/atividade para mais informações.";
        }

        @GetMapping("/atividade")
        public String atividade() {
            return "Essa é minha segunda atividade pontuada na matéria de DS\n" +
                    "O link abaixo você pode acessar meu repositório no git para acessá-la: \n" +
                    "https://github.com/AlvaroCoe/atividadePontuadaDois";

        }

    }
}