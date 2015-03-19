package br.edu.unipampa.geketcc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * Autorizador Interceptor
 *
 * Classe responsável por realizar a autenticação dos usuários e restringir
 * os mesmos, verificando as permissões de acesso a determinadas telas.
 *
 * @author Gean Pereira
 * @since 09/12/2014
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    /**
     *
     * Método executado antes da requisição ser totalmente processada, ou seja,
     * realiza todas as verificações para depois retornar a resposta da
     * requisição
     *
     * @param request
     * @param response
     * @param controller
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object controller) throws Exception {

        System.out.println("Processo de autenticação inciado");

        String uri = request.getRequestURI();
        if (uri.equals("/GekeTCC/")
                || uri.contains("/GekeTCC/login")
                || uri.contains("/GekeTCC/index")
                || uri.endsWith("efetuaLogin")
                || uri.contains("resources")) {
            System.out.println("Acesso a tela de login");

            return true;
        }

        if (request.getSession().getAttribute("usuarioLogado") != null || uri.endsWith("cadastroBanca")) {

            System.out.println("Acesso as demais telas...");

            return true;
        }

        System.out.println("Acesso negado!");

        response.sendRedirect("/GekeTCC/");
        return false;
    }

}
