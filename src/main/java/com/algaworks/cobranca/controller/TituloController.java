package com.algaworks.cobranca.controller;



import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by bruno on 29/01/17.
 */

@Controller
@RequestMapping("/titulos")
public class TituloController {

    //Titulo titulo;

    //Ja injeta o objeto pra gente , facilitando
    @Autowired
    private Titulos titulos;

    @RequestMapping("/novo")
    public String novo(){

        return "CadastroTitulo";

    }

    // Post para /titulos , pegara dados da requisicao e ja transformara em titulo
    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Titulo titulo){
        //TODO:Salvar no banco de dados

        titulos.save(titulo);

        return "CadastroTitulo";
    }

}
