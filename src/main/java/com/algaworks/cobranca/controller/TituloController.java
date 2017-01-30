package com.algaworks.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bruno on 29/01/17.
 */

@Controller
public class TituloController {

    @RequestMapping("/titulos/novo")
    public String novo(){

        return "CadastroTitulo";

    }

}
