package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.model.Pessoa;
import br.edu.unipampa.geketcc.service.LoginUsuarioService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Login Controller
 *
 * @version v 1.0 27/03/2015
 * @author Alex Becker
 * @since 27/03/2015
 *
 */
@Controller
public class LoginController {

    private final LoginUsuarioService loginUsuarioService;

    public LoginController() {
        loginUsuarioService = new LoginUsuarioService();
    }

    @RequestMapping(value = {"/", "/login", "/index"})
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView("inicio");

        return modelAndView;
    }

    @RequestMapping("/login/efetuaLogin")
    public String efetuaLogin(@ModelAttribute(value = "login") String login,
            @ModelAttribute(value = "senha") String senha, RedirectAttributes redirectAttrs, HttpSession session) {
System.out.println("começou");
        Pessoa pessoa = loginUsuarioService.autenticarUsuario(login, senha);

        if (pessoa != null) {
            System.out.println("Logado");
            session.setAttribute("usuarioLogado", pessoa);
            redirectAttrs.addAttribute("mensagem",
                    "Bem-Vindo ao Sistema. Escolha o que deseja fazer no menu ao lado.").addFlashAttribute(
                            "mensagem", "Bem-Vindo ao Sistema. Escolha o que deseja fazer no menu ao lado.");
        } else {
            System.out.println("nops");
            session.invalidate();
            redirectAttrs.addAttribute("mensagem",
                    "Erro ao efetuar o login, 'Login' ou 'Senha' inválidos!").addFlashAttribute(
                            "mensagem", "Erro ao efetuar o login, 'Login' ou 'Senha' inválidos!");
        }

        return "redirect:/principal";
    }

    @RequestMapping("/principal")
    public ModelAndView inicio() {
        return new ModelAndView("/principal");
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/principal";
    }
}
