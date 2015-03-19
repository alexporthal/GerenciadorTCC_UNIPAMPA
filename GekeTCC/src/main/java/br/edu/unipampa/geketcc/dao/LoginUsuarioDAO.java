package br.edu.unipampa.geketcc.dao;

import br.edu.unipampa.geketcc.model.Pessoa;
import br.edu.unipampa.geketcc.model.Usuario;

/*
 * Login Usuario DAO
 *
 * @author Gean Pereira
 * @since 09/12/2014
 */
public class LoginUsuarioDAO {
    
    public Usuario buscarUsuario(String loginUsuario) {
        return (Usuario) CRUD.buscarObjetoLogin(loginUsuario, Usuario.class);
    }
    
    public Pessoa buscarPessoa(Usuario usuario) {
        return (Pessoa) CRUD.buscarObjetoPessoa(usuario, Pessoa.class);
    }
}
