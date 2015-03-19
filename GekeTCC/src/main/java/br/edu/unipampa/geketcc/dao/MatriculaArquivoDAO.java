package br.edu.unipampa.geketcc.dao;

import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.Matriculaarquivo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/*
 * Matricula Arquivo TCC
 *
 * @author Douglas Giordano
 * @since 07/12/2014
 */
public class MatriculaArquivoDAO {

    /**
     * Salvar o registro do arquivo de TCC
     *
     * @param MatriculaArquivo
     * @return
     */
    public boolean salvar(Matriculaarquivo matriculaArquivo) {
        return CRUD.salvar(matriculaArquivo);
    }

    public Matricula buscarUltimaMatricula(int codigoAluno) {
        Object objeto = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(Matricula.class);
            criteria.add(Restrictions.eq("aluno.codigo", codigoAluno));
            criteria.addOrder(Order.desc("codigo"));
            criteria.setMaxResults(1);
            objeto = criteria.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Matricula) objeto;
    }

    public List<Matriculaarquivo> buscarUltimosArquivos(int codigoMatricula) {
        List<Matriculaarquivo> matriculasArquivos = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(Matriculaarquivo.class);
            criteria.add(Restrictions.eq("matricula.codigo", codigoMatricula));
            matriculasArquivos = criteria.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return matriculasArquivos;
    }

    public Matriculaarquivo buscarMatriculaArquivo(int codigoArquivo) {
        return (Matriculaarquivo) CRUD.buscarObjeto(codigoArquivo, Matriculaarquivo.class);
    }

    public List<Matriculaarquivo> buscarMatriculasArquivos(int codigoOrientador, int status) {
        List<Matriculaarquivo> matriculasArquivos = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(Matriculaarquivo.class);
            criteria.add(Restrictions.eq("status", status));
            criteria.add(Restrictions.eq("matricula.orientador.codigo", codigoOrientador));
            matriculasArquivos = criteria.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return matriculasArquivos;
    }

    public Matriculaarquivo buscarMatriculaArquivo(int codigoOrientador, int codigoAluno, int status) {
        Matriculaarquivo matriculasArquivos = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(Matriculaarquivo.class)
                    .add(Restrictions.eq("status", status));
            criteria.createCriteria("matricula").add(Restrictions.and(Restrictions.eq("orientador.codigo", codigoOrientador),Restrictions.eq("aluno.codigo", codigoAluno)));

            matriculasArquivos = (Matriculaarquivo) criteria.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return matriculasArquivos;
    }

    public Matriculaarquivo buscar(Matricula matricula) {
        Matriculaarquivo matriculaArquivo = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(Matriculaarquivo.class);
            criteria.add(Restrictions.eq("matricula.codigo", matricula.getCodigo()));
            criteria.setMaxResults(1);
            matriculaArquivo = (Matriculaarquivo) criteria.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return matriculaArquivo;
    }
}
