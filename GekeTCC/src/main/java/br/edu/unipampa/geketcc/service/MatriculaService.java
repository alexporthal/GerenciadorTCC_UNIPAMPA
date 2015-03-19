package br.edu.unipampa.geketcc.service;

import br.edu.unipampa.geketcc.dao.*;
import br.edu.unipampa.geketcc.model.Email;
import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.ArrayList;

/*
 * Matrícula Service
 *
 * @author Alex Becker
 * @since 07/12/2014
 */
public class MatriculaService {

    private final MatriculaDAO matriculaDao;

    public MatriculaService() {
        matriculaDao = new MatriculaDAO();
    }

    /**
     * Salvar o registro da matricula
     *
     * @param matricula
     * @return
     */
    public boolean solicitarPreMatricula(Matricula matricula) {
        matricula.setStatus(0);
        boolean retorno = matriculaDao.salvar(matricula);
        if (retorno) {
            this.enviarEmailPreMatricula(matricula);
        }

        return retorno;
    }

    public boolean aceitarPreMatricula(int codigo) {
        return matriculaDao.aceitar(codigo, 1);
    }

    /**
     * Envair email para orientador da solicitação de pré-matrícula
     *
     * @param matricula
     */
    private void enviarEmailPreMatricula(Matricula matricula) {
        String assunto = "[GekeTCC] - Solicitação Pré-Matrícula";
        String destinatario = matricula.getOrientador().getEmail();
        String mensagem = "<html>"
                + "<head>"
                + "</head>"
                + "<body>"
                + "<h3>Email enviado através do Sistema GekeTCC</h3>"
                + "<hr />"
                + "<h3>*** Olá " + matricula.getOrientador().getNome() + " *** </h3><br />"
                + "<h4>O aluno " + matricula.getAluno().getNome() + " solicitou a Pré-Matrícula no TCC I</h4>"
                + "<h4>Para aceitar ou recusar a solicitação acesse pelo link: http://localhost:8083/GekeTCC/matricula/solicitacaoPendente/"
                + matricula.getCodigo() + " </h4>"
                + "</body>"
                + "</html>";
        Email email = new Email(assunto, mensagem, destinatario);
    }

    public ArrayList<Matricula> buscarMatriculasOrientador(int status, Pessoa orientador) {
        return matriculaDao.buscarMatriculasOrientador(status, orientador);
    }
    
    public ArrayList<Matricula> buscarMatriculasAvaliadasEAprovadas(Pessoa orientador) {
        return matriculaDao.buscarMatriculasAvaliadasEAprovadas(orientador);
    }
    
    public ArrayList<Matricula> buscaMatriculasAlunos(int status, Pessoa aluno) {
        return matriculaDao.buscaMatriculasAlunos(status, aluno);
    }
    
    public ArrayList<Matricula> buscaMatriculasAtivas(Pessoa aluno) {
        return matriculaDao.buscaMatriculasAtivas(aluno);
    }

    public Matricula buscarMatricula(int id) {
        return matriculaDao.buscar(id);
    }

    public boolean rejeitarPreMatricula(int codigo) {
        return matriculaDao.aceitar(codigo, 2);
    }

    public Matricula buscar(int codigoMatricula) {
        return matriculaDao.buscar(codigoMatricula);
    }

}
