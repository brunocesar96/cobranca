package com.algaworks.cobranca.controller;



import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;


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
    public ModelAndView novo(){

        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("todosStatusTitulo", StatusTitulo.values());

        return mv;

    }

    // Post para /titulos , pegara dados da requisicao e ja transformara em titulo
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo){
        //TODO:Salvar no banco de dados

        titulos.save(titulo);
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("mensagem","Título salvo com sucesso!");
        return mv;
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo>todosStatusTitulo(){

        return Arrays.asList(StatusTitulo.values());

    }

}
