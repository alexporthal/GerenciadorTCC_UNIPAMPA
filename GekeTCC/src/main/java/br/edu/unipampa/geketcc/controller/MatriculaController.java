package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.Pessoa;
import br.edu.unipampa.geketcc.service.MatriculaService;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * Matrícula Controller
 *
 * @author Alex Becker
 * @since 07/12/2014
 */
@Controller
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController() {
        matriculaService = new MatriculaService();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping("/preMatricula")
    public ModelAndView preMatricula(HttpSession session) {
        Pessoa aluno = (Pessoa) session.getAttribute("usuarioLogado");
        ModelAndView mv = new ModelAndView("solicitarPreMatricula");

        ArrayList<Matricula> matriculas = matriculaService.buscaMatriculasAtivas(aluno);

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);

        boolean matriculado = false;
        if (matriculas.size() > 0) {
            matriculado = true;
        }

        mv.getModelMap().put("matricula", matricula);
        mv.getModelMap().put("matriculado", matriculado);
        return mv;
    }

    @RequestMapping("/solicitarPreMatricula")
    public String solicitarPreMatricula(HttpSession session, @ModelAttribute(value = "matricula") Matricula matricula,
            BindingResult result, RedirectAttributes redirectAttrs) throws NoSuchAlgorithmException {
        Pessoa aluno = (Pessoa) session.getAttribute("usuarioLogado");
        ArrayList<Matricula> matriculas = matriculaService.buscaMatriculasAlunos(3, aluno);

        if (matriculas.size() <= 1) {
            matricula.setAluno(aluno);
            if (matriculas.isEmpty()) {
                matricula.setTcc(0);
            } else {
                matricula.setTcc(1);
            }
            if (matriculaService.solicitarPreMatricula(matricula)) {
                redirectAttrs.addAttribute("mensagem",
                        "Pre-Matricula efetuada com sucesso!").addFlashAttribute(
                                "mensagem", "Pre-Matricula efetuada com sucesso!!");
            } else {
                redirectAttrs.addAttribute("mensagem",
                        "Erro ao solicitar Pre-Matricula!").addFlashAttribute(
                                "mensagem", "Erro ao solicitar Pre-Matricula!");
            }
        } else {
            redirectAttrs.addAttribute("mensagem",
                    "Pré-Matrícula não solicitada. Você já foi aprovado no TCC I e II.").addFlashAttribute(
                            "mensagem", "Pré-Matrícula não solicitada. Você já foi aprovado no TCC I e II.");
        }

        return "redirect:/mensagem/exibir";
    }

    @RequestMapping("/matriculasOrientador")
    public ModelAndView matriculasPendentes() {
        ModelAndView mv = new ModelAndView("matriculasOrientador");
        return mv;
    }

    @RequestMapping(value = "/aceitarPreMatricula/{codigo}", method = RequestMethod.GET)
    public @ResponseBody
    String aceitarPreMatricula(@PathVariable("codigo") int codigo) {
        String retorno = "";
        if (matriculaService.aceitarPreMatricula(codigo)) {
            retorno = "<h3>Matrícula aceita com sucesso!</h3>";
        } else {
            retorno = "<h3>Erro ao aceitar matrícula!</h3>";
        }

        return retorno;
    }

    @RequestMapping(value = "/rejeitarPreMatricula/{codigo}", method = RequestMethod.GET)
    public @ResponseBody
    String rejeitarPreMatricula(@PathVariable("codigo") int codigo) {
        String retorno = "";
        if (matriculaService.rejeitarPreMatricula(codigo)) {
            retorno = "<h3>Matrícula rejeitada com sucesso!</h3>";
        } else {
            retorno = "<h3>Erro ao rejeitar matrícula!</h3>";
        }

        return retorno;
    }

    @RequestMapping("/pesquisarMatriculasPendentes")
    public ModelAndView pesquisarMatriculasPendentes(HttpSession session) {
        ModelAndView mv = new ModelAndView("pesquisa/matriculasPendentes");

        Pessoa orientador = (Pessoa) session.getAttribute("usuarioLogado");

        ArrayList<Matricula> matriculas = matriculaService.buscarMatriculasOrientador(0, orientador);
        mv.getModelMap().put("matriculas", matriculas);
        return mv;
    }

    @RequestMapping("/pesquisarMatriculasAceitas")
    public ModelAndView pesquisarMatriculasAceitas(HttpSession session) {
        ModelAndView mv = new ModelAndView("pesquisa/matriculasAceitas");

        Pessoa orientador = (Pessoa) session.getAttribute("usuarioLogado");

        ArrayList<Matricula> matriculas = matriculaService.buscarMatriculasOrientador(1, orientador);
        mv.getModelMap().put("matriculas", matriculas);
        return mv;
    }

    @RequestMapping("/pesquisarMatriculasRejeitadas")
    public ModelAndView pesquisarMatriculasRejeitadas(HttpSession session) {
        ModelAndView mv = new ModelAndView("pesquisa/matriculasRejeitadas");

        Pessoa orientador = (Pessoa) session.getAttribute("usuarioLogado");

        ArrayList<Matricula> matriculas = matriculaService.buscarMatriculasOrientador(2, orientador);
        mv.getModelMap().put("matriculas", matriculas);
        return mv;
    }

    @RequestMapping("/pesquisarMatriculasAprovadas")
    public ModelAndView pesquisarMatriculasAprovadas(HttpSession session) {
        ModelAndView mv = new ModelAndView("pesquisa/matriculasAprovadas");

        Pessoa orientador = (Pessoa) session.getAttribute("usuarioLogado");

        ArrayList<Matricula> matriculas = matriculaService.buscarMatriculasOrientador(3, orientador);
        mv.getModelMap().put("matriculas", matriculas);
        return mv;
    }

    @RequestMapping("/pesquisarMatriculasReprovadas")
    public ModelAndView pesquisarMatriculasReprovadas(HttpSession session) {
        ModelAndView mv = new ModelAndView("pesquisa/matriculasReprovadas");

        Pessoa orientador = (Pessoa) session.getAttribute("usuarioLogado");

        ArrayList<Matricula> matriculas = matriculaService.buscarMatriculasOrientador(4, orientador); 
        mv.getModelMap().put("matriculas", matriculas);
        return mv;
    }

}
