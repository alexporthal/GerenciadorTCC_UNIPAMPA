package br.edu.unipampa.geketcc.service;

import br.edu.unipampa.geketcc.dao.LoginUsuarioDAO;
import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.LdapTemplate;

/**
 * Login Usuario Service
 *
 * @version v 1.0 27/03/2015
 * @author Alex Becker
 * @since 27/03/2015
 *
 */
public class LoginUsuarioService {

    private final LoginUsuarioDAO loginUsuarioDao;

    public LoginUsuarioService() {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        loginUsuarioDao = new LoginUsuarioDAO(appContext.getBean(LdapTemplate.class));
    }

    public Pessoa autenticarUsuario(String login, String senha) {
        Pessoa usuario = null;
        if (loginUsuarioDao.autenticarUsuario(login, senha)) {
            usuario = getInfoUsuarioLogado(login);
        }
        return usuario;
    }

    private Pessoa getInfoUsuarioLogado(String login) {
        List<Pessoa> usuario = loginUsuarioDao.getUserInfo(login);
        return usuario.get(0);
    }

}
