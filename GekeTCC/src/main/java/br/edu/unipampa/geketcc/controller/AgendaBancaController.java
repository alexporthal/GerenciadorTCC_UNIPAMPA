package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.model.Defesa;
import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.service.BancaService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * Classe encarregada do controle da agenda da banca.
 *
 * @author Douglas Giordano
 * @since 20/12/2014
 */
@Controller
@RequestMapping("/agendaBanca")
public class AgendaBancaController {

    private final BancaService bancaService;

    public AgendaBancaController() {
        bancaService = new BancaService();
    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
//        binder.registerCustomEditor(Date.class, editor);
//    }

    @RequestMapping("/agendar")
    public ModelAndView cadastrar(@RequestParam("matricula") int codigoMatricula) {
        ModelAndView modelAndView = new ModelAndView();
        Matricula matricula = new Matricula();
        matricula.setCodigo(codigoMatricula);
        Defesa banca = bancaService.buscar(matricula);

        if (banca == null) {
            modelAndView.setViewName("/mensagem/mensagemSimples");
            modelAndView.addObject("mensagem", "Nenhuma defesa foi definida ainda. Aguarde a mesma ser criada para poder agendar.");
        } else {
            modelAndView.setViewName("agendaBanca");
            modelAndView.addObject("banca", banca);
        }
        return modelAndView;
    }

    @RequestMapping("/salvar")
    public String salvar(@ModelAttribute(value = "banca") Defesa banca,
            BindingResult result, RedirectAttributes redirectAttrs) {
        String mensagem = "";

        if (bancaService.salvar(banca)) {
            mensagem = "O agendamento da banca foi efetuado com sucesso!";
        } else {
            mensagem = "Ocorreu um problema ao efetuar o agendamento da banca!";
        }
        redirectAttrs.addAttribute("mensagem", mensagem).addFlashAttribute(mensagem);

        return "redirect:/mensagem/mensagemSimples";
    }

}
