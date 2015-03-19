/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.dao.CRUD;
import br.edu.unipampa.geketcc.model.Aluno;
import br.edu.unipampa.geketcc.model.Defesa;
import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.MembroBanca;
import br.edu.unipampa.geketcc.service.BancaService;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bruning
 */
@Controller
@RequestMapping("/banca")

public class BancaController {

    private final BancaService bancaService;

    public BancaController() {
        bancaService = new BancaService();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping("/cadastrar/novaBanca")
    public ModelAndView cadastrar(@ModelAttribute(value = "aluno") Aluno aluno, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("cadastroBanca");

        MembroBanca banca = bancaService.retornaDadosBanca(aluno);
        modelAndView.addObject("banca", banca);

        return modelAndView;
    }

    @RequestMapping("/pesquisaAlunosPendentes")
    public ModelAndView pesquisarAlunosPendentes() {
        ModelAndView mv = new ModelAndView("pesquisa/alunosSemBanca");

        ArrayList<Matricula> matriculas;       
        matriculas = (ArrayList<Matricula>) CRUD.buscarObjetos("SELECT * FROM MATRICULA");
        ArrayList<Matricula> matriculasAlunoSemBanca;
        matriculasAlunoSemBanca = new ArrayList<>();

        for (Matricula matricula : matriculas) {
            if (CRUD.buscarObjeto("matricula", matricula, Defesa.class) == null) {
                matriculasAlunoSemBanca.add(matricula);
            }
        }
        mv.getModelMap().put("matricula", matriculas);
        return mv;
    }

    @RequestMapping("/pesquisaAlunoComBanca")
    public ModelAndView pesquisarAlunosComBanca() {
        ModelAndView mv = new ModelAndView("pesquisa/alunosComBanca");

        ArrayList<Matricula> matriculas = (ArrayList<Matricula>) CRUD.buscarObjetos("SELECT * FROM MATRICULA");
        ArrayList<Matricula> matriculasAlunoComBanca = new ArrayList<>();
       
        for (Matricula matricula : matriculas) {
            if (CRUD.buscarObjeto("matricula", matricula, Defesa.class) != null) {
                matriculasAlunoComBanca.add(matricula);
            }

        }
        mv.getModelMap().put("matriculas", matriculas);
        return mv;
    }
    
    
    @RequestMapping("/selecionarAluno")
    public ModelAndView selecionarAluno() {
        ModelAndView modelAndView = new ModelAndView("selecionaAluno");

        // ArrayList<Pessoa> pessoas  = (ArrayList<Pessoa>)CRUD.buscarObjetos("SELECT * FROM PESSOA");
        // ArrayList<Aluno> alunos = new ArrayList<>();
        // for (Pessoa pessoa : pessoas) {
        //     if (pessoa.getTipo() == 1) {
        //       alunos.add(new Aluno(pessoa));
        //   }
        //  }
        //  modelAndView.addObject("alunos", alunos);
        //ArrayList<Matricula> matriculas = (ArrayList<Matricula>) CRUD.buscarObjetos("SELECT * FROM MATRICULA");

        return modelAndView;
    }

    @RequestMapping("/salvar")
    public String salvar(@ModelAttribute(value = "banca") Defesa banca,
            BindingResult result, RedirectAttributes redirectAttrs) throws NoSuchAlgorithmException {
        if (bancaService.salvar(banca)) {
            redirectAttrs.addAttribute("mensagem",
                    "Seu cadastro foi efetuado com sucesso! Utilize a tela de login para acompanhamento do TCC!").addFlashAttribute(
                            "mensagem", "Seu cadastro foi efetuado com sucesso! Utilize a tela de login para acompanhamento do TCC!");
        } else {
            redirectAttrs.addAttribute("mensagem",
                    "Erro ao efetuar o cadastro!").addFlashAttribute(
                            "mensagem", "Erro ao efetuar o cadastro!");
        }

        return "redirect:/mensagem/exibir";
    }
}
