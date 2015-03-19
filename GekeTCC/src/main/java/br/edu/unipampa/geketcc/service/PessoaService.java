package br.edu.unipampa.geketcc.service;

import br.edu.unipampa.geketcc.dao.PessoaDAO;
import br.edu.unipampa.geketcc.model.Email;
import br.edu.unipampa.geketcc.model.Pessoa;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/*
 * Pessoa Service
 *
 * @author Alex Becker
 * @since 10/12/2014
 */
public class PessoaService {

    private final PessoaDAO pessoaDao;

    public PessoaService() {
        pessoaDao = new PessoaDAO();
    }

    public ArrayList<Pessoa> buscarTodosProfessores() {
        return pessoaDao.buscarTodosProfessores();
    }

    /**
     * Salva uma pessoa
     *
     * @param pessoa
     * @return
     */
    public boolean salvar(Pessoa pessoa) {
        return pessoaDao.salvar(pessoa);
    }

    /**
     * Convidar membro externo
     *
     * @param membroExterno
     * @return
     */
    public boolean convidarMembroExterno(Pessoa pessoa) throws NoSuchAlgorithmException {
        boolean retorno = pessoaDao.salvar(pessoa);
        if (retorno) {
            this.enviarConviteME(pessoa);
        }

        return retorno;
    }

    /**
     * Envair email para membro externo com link da pagina para terminar o
     * cadastro
     *
     * @param membroExterno
     */
    private void enviarConviteME(Pessoa pessoa) {
        String assunto = "[GekeTCC] - Convite para participar de banca";
        String destinatario = pessoa.getEmail();
        //falta pegar o orientador da session
        String mensagem = "<html>"
                + "<head>"
                + "</head>"
                + "<body>"
                + "<h3>Email enviado através do Sistema GekeTCC</h3>"
                + "<hr />"
                + "<h3>*** Olá " + pessoa.getNome() + " *** </h3><br />"
                + "<h4>Você foi convidado a participar de uma banca pelo professor XXXX</h4>"
                + "<h4>Para aceitar o convite e finalizar o cadastro acesse pelo link: http://localhost:8083/GekeTCC/membroExterno/cadastrar/"
                + pessoa.getCodigo() + " </h4>"
                + "</body>"
                + "</html>";
        Email email = new Email(assunto, mensagem, destinatario);
    }

    public Pessoa buscar(int codigoMembroExterno) {
        return pessoaDao.buscar(codigoMembroExterno);
    }

}
