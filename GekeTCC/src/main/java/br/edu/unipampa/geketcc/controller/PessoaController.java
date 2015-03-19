package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.model.Pessoa;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.unipampa.geketcc.service.PessoaService;
import java.util.ArrayList;

/*
 * Classe encarregada do controle das operações das pessoas
 *
 * @author Alex Becker
 * @since 10/12/2014
 */
@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController() {
        pessoaService = new PessoaService();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping("/pesquisarOrientadores")
    public ModelAndView convidar() {
        ModelAndView mv = new ModelAndView("pesquisa/orientador");

        ArrayList<Pessoa> orientadores = pessoaService.buscarTodosProfessores();
        mv.getModelMap().put("orientadores", orientadores);
        return mv;
    }

}
