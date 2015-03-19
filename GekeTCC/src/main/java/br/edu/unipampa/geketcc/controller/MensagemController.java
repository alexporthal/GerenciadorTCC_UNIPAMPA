/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.geketcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Douglas
 */
@Controller
@RequestMapping("/mensagem")
public class MensagemController {

    @RequestMapping("/exibir")
    public ModelAndView mensagem() {
        return new ModelAndView("mensagem/mensagem");
    }
    
    @RequestMapping("/mensagemSimples")
    public ModelAndView mensagemSimples() {
        return new ModelAndView("mensagem/mensagemSimples");
    }

}
