package br.edu.unipampa.geketcc.dao;

import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.List;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;

/**
 * Login Usuario DAO
 *
 * @version v 1.0 27/03/2015
 * @author Alex Becker
 * @since 27/03/2015
 *
 */
public class LoginUsuarioDAO {

    private final LdapTemplate ldapTemplate;

    public LoginUsuarioDAO(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public List<Pessoa> getUserInfo(String login) {
        return ldapTemplate.search(
                "", "(uid=" + login + ")",
                new AttributesMapper() {
                    @Override
                    public Object mapFromAttributes(Attributes attrs)
                    throws NamingException {
                        Pessoa p = new Pessoa();
                        p.setMatricula((String) attrs.get("uid").get());
                        p.setNome((String) attrs.get("cn").get());
                        p.setEmail((String) attrs.get("mail").get());
                        return p;
                    }
                });
    }

    public boolean autenticarUsuario(String login, String senha) {
        Filter filter = new AndFilter()
                .and(new EqualsFilter("uid", login));
        return ldapTemplate.authenticate("", filter.toString(), senha);
    }
}
