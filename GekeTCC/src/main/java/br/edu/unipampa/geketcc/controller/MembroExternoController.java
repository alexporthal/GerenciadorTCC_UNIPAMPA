package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.model.Pessoa;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unipampa.geketcc.service.PessoaService;
import java.security.NoSuchAlgorithmException;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Classe encarregada do controle das operações de membro externo.
 *
 * @author Alex Becker, Douglas Giordano
 * @since 29/11/2014
 */
@Controller
@RequestMapping("/membroExterno")
public class MembroExternoController {

    private final PessoaService pessoaService;

    public MembroExternoController() {
        pessoaService = new PessoaService();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar(@RequestParam("codigo") int codigo) {
        ModelAndView modelAndView = new ModelAndView("cadastroMembroExterno");
        
        Pessoa membroExterno = pessoaService.buscar(codigo);
        
        membroExterno.setTipo(3);

        modelAndView.addObject("membroExterno", membroExterno);
        return modelAndView;
    }

    @RequestMapping("/salvar")
    public String salvar(@ModelAttribute(value = "membroExterno") Pessoa membroExterno,
            BindingResult result, RedirectAttributes redirectAttrs) throws NoSuchAlgorithmException {
        membroExterno.setTipo(3);
        if (pessoaService.salvar(membroExterno)) {
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

    @RequestMapping("/convidar")
    public ModelAndView convidar() {
        ModelAndView mv = new ModelAndView("convidarMembroExterno");

        Pessoa membroExterno = new Pessoa();
        membroExterno.setTipo(3);
        mv.getModelMap().put("membroExterno", membroExterno);
        return mv;
    }

    @RequestMapping(value = "/enviarConvite", method = RequestMethod.POST)
    public String enviarConvite(@ModelAttribute(value = "membroExterno") Pessoa membroExterno,
            BindingResult result, RedirectAttributes redirectAttrs) throws NoSuchAlgorithmException {
        membroExterno.setTipo(3);

        if (pessoaService.convidarMembroExterno(membroExterno)) {
            redirectAttrs.addAttribute("mensagem",
                    "Convite enviado com sucesso!").addFlashAttribute(
                            "mensagem", "Convite enviado com sucesso!");
        } else {
            redirectAttrs.addAttribute("mensagem",
                    "Erro ao enviar o convite!").addFlashAttribute(
                            "mensagem", "Erro ao enviar o convite!");
        }

        return "redirect:/mensagem/exibir";
    }

}
