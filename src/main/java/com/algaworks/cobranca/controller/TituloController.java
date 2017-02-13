package com.algaworks.cobranca.controller;



import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/titulos")
public class TituloController {

    //Titulo titulo;

    private static final String CADASTRO_VIEW="CadastroTitulo";

    //Ja injeta o objeto pra gente , facilitando
    @Autowired
    private Titulos titulos;

    @RequestMapping("/novo")
    public ModelAndView novo(){

        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(new Titulo());

        return mv;

    }

    // Post para /titulos , pegara dados da requisicao e ja transformara em titulo
    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Titulo titulo, Errors errors , RedirectAttributes attributes){
        //TODO:Salvar no banco de dados
        if(errors.hasErrors()){

            return CADASTRO_VIEW;
        }

        titulos.save(titulo);
        //redirect para uma URL -> Apaga os campos salvos e redireciona para um novo endereço
        attributes.addFlashAttribute("mensagem","Título salvo com sucesso!");
        return "redirect:/titulos/novo";
    }

    @RequestMapping
    public ModelAndView pesquisar(){

        List<Titulo>todosTitulos = titulos.findAll();
        ModelAndView mv = new ModelAndView("PesquisaTitulos");
        mv.addObject("titulos",todosTitulos);
        return mv;

    }
    //Nao pode haver dois @RequestMapping iguais
    // Mapear por codigo para edicao
    @RequestMapping("{codigo}")
    //O spring entende que pegara um objeto titulo através do seu codigo
    public ModelAndView edicao(@PathVariable ("codigo") Titulo titulo){

        //(Obs: Tambem funciona)Pegando o objeto com codigo=codigo e atribuindo ao titulo
        //Titulo titulo = titulos.findOne(codigo);

        ModelAndView mv= new ModelAndView(CADASTRO_VIEW);
        mv.addObject(titulo);
        return mv;

    }


    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo>todosStatusTitulo(){

        return Arrays.asList(StatusTitulo.values());

    }

}
