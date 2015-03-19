package br.edu.unipampa.geketcc.dao;

import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * Matrícula DAO
 *
 * @author Alex Becker
 * @since 07/12/2014
 */
public class MatriculaDAO {

    /**
     * Salvar o registro da matricula
     *
     * @param matricula
     * @return
     */
    public boolean salvar(Matricula matricula) {
        return CRUD.salvar(matricula);
    }

    public ArrayList<Matricula> buscarMatriculasOrientador(int status, Pessoa orientador) {
        return (ArrayList<Matricula>) CRUD.buscarMatriculasOrientador(Matricula.class, status, orientador);
    }
    
    public ArrayList<Matricula> buscarMatriculasAvaliadasEAprovadas(Pessoa orientador) {
        return (ArrayList<Matricula>) CRUD.buscarMatriculasAvaliadasEAprovadas(Matricula.class, orientador);
    }

    public ArrayList<Matricula> buscaMatriculasAtivas(Pessoa aluno) {
        return (ArrayList<Matricula>) CRUD.buscaMatriculasAtivas(Matricula.class, aluno);
    }

    public ArrayList<Matricula> buscaMatriculasAlunos(int status, Pessoa aluno) {
        return (ArrayList<Matricula>) CRUD.buscaMatriculasAlunos(Matricula.class, status, aluno);
    }

    public boolean aceitar(int codigo, int status) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        boolean salvou = false;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = (Query) session.createQuery("update Matricula set "
                    + " status = :status where id = :codigo");
            query.setParameter("status", status);
            query.setParameter("codigo", codigo);
            query.executeUpdate();
            salvou = true;
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            salvou = false;
        }
        return salvou;
    }

    public Matricula buscar(int codigoMatricula) {
        return (Matricula) CRUD.buscarObjeto(codigoMatricula, Matricula.class);
    }

}
