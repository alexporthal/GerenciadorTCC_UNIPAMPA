/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.geketcc.service;

import br.edu.unipampa.geketcc.dao.BancaDAO;
import br.edu.unipampa.geketcc.model.Aluno;
import br.edu.unipampa.geketcc.model.Defesa;
import br.edu.unipampa.geketcc.model.Email;
import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.MembroBanca;
import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author Bruning
 */
public class BancaService {

    private final BancaDAO bancaDAO;

    public BancaService() {
        bancaDAO = new BancaDAO();
    }

    public boolean salvar(Defesa defesa) {
        return bancaDAO.salvar(defesa);
    }

    public Matricula buscar(Aluno aluno) {
        return bancaDAO.buscar(aluno);
    }

    public Defesa buscar(Matricula matricula) {
        Defesa defesa = bancaDAO.buscar(matricula);
        if (defesa == null) {
            System.out.println("Banca nullllll");
            return new Defesa();
        } else {

            System.out.println("Banca corretaaaa" + defesa.getData() + " -- - " + defesa.getHora());
            return defesa;
        }
    }

    public MembroBanca buscar(Defesa defesa) {

        if (bancaDAO.buscar(defesa) == null) {
//            MembroBanca membroBanca = new MembroBanca(defesa);
//            return membroBanca;
                return null;
        } else {
            return bancaDAO.buscar(defesa);
        }
    }

    public MembroBanca retornaDadosBanca(Aluno aluno) {
        Matricula matriculaAluno = buscar(aluno);
        Defesa defesa = buscar(matriculaAluno);
        MembroBanca membroBanca = buscar(defesa);
        return membroBanca;
    }

    public boolean enviarEmailPresencaBanca(ArrayList<Pessoa> membros, Defesa defesa) {
        String destinatarios = "";
        for (int i = 0; i < membros.size(); i++) {
            if(i != membros.size()-1) {
                destinatarios += membros.get(i).getEmail() + ",";
            } else {
                destinatarios += membros.get(i).getEmail();
            }
        }
        String assunto = "Convite para presença em uma banca de TCC";
        String mensagem = ""
                + "<div style=\"background: black; color: white; padding: 2%\">"
                + "<h2>Você foi convidado para participar de uma banca de TCC da UNIPAMPA</h2>"
                + "<h3>Segue abaixo as informações da banca: </h3>"
                + "</div>"
                + "<div style=\"background: #00994C; color: black; padding: 1%\">"
                + "<label>Tema</label>: " + defesa.getMatricula().getTema() + "<br>"
                + "<label>Apresentador</label>: " + defesa.getMatricula().getAluno().getNome() + "<br>"
                + "<label>Orientador</label>: " + defesa.getMatricula().getOrientador().getNome() + "<br>"
                + "<label>Data</label>: " + defesa.getData() + "<br>"
                + "<label>Horário</label>: " + defesa.getHora() + "<br>"
                + "<label>Local</label>: " + defesa.getLocal() + ""
                + "</div>";
        Email email = new Email(assunto, mensagem, destinatarios);
        return email.enviarEmail();
    }
}
