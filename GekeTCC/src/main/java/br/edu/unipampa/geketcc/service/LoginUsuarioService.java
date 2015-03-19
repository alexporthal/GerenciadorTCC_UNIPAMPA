package br.edu.unipampa.geketcc.service;

import br.edu.unipampa.geketcc.dao.LoginUsuarioDAO;
import br.edu.unipampa.geketcc.model.Pessoa;
import br.edu.unipampa.geketcc.model.Usuario;

/*
 * Login Usuário Service
 *
 * Classe que realiza serviços para as classes controladoras
 *
 * @author Gean Pereira
 * @since 09/12/2014
 */
public class LoginUsuarioService {

    private final LoginUsuarioDAO loginUsuarioDao;

    public LoginUsuarioService() {
        loginUsuarioDao = new LoginUsuarioDAO();
    }

    /**
     * Valida se o usuário passado como parâmetro é valido, verificando
     * se o login e senha informados batem com os contidos no banco de dados
     * 
     * @param usuario
     * @return boolean
     */
    public boolean validarUsuario(Usuario usuario) {
        Usuario retorno = (Usuario) loginUsuarioDao.buscarUsuario(usuario.getLogin());

        if (retorno != null) {
            return retorno.getSenha().equals(usuario.getSenha());
        }
        
        return false;
    }

    /**
     * Busca as informações de um usuário 
     * 
     * @param login
     * @return Pessoa  
     */
    public Pessoa buscaUsuario(String login) {
        Usuario usuario = loginUsuarioDao.buscarUsuario(login);
        Pessoa pessoaUsuario = loginUsuarioDao.buscarPessoa(usuario);

        if (pessoaUsuario != null) {
            return pessoaUsuario;
        }

        return null;
    }
}
