/*
 */
package br.edu.unipampa.geketcc.dao;

import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * @author Douglas
 */
public class CRUD {

    /**
     * Salva um objeto mapeado no banco de dados
     *
     * @param obj
     * @return boolean se salvou ou não
     */
    public static boolean salvar(Object obj) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        boolean salvou = false;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(obj);
            salvou = true;
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            salvou = false;
        }
        return salvou;
    }

    public static List buscarObjetos(String query) {
        List list = new ArrayList();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            tx.begin();//inicia conexão
            list = session.createQuery(query).list();
            tx.commit();//manda o comando
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public static List<?> buscarMatriculasBanca(String query) {
        ArrayList<?> objetos = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            tx.begin();//inicia conexão
            objetos = (ArrayList<?>) session.createQuery(query).list();
            tx.commit();//manda o comando
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return objetos;
    }

    public static Object buscarObjeto(int codigo, Class<?> classe) {
        Object objeto = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("codigo", codigo));
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
        return objeto;
    }

    public static Object buscarObjeto(String codigo, Class<?> classe) {
        Object objeto = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("codigo", codigo));
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
        return objeto;
    }

    public static Object buscarObjeto(String filtro, Object obj, Class<?> classe) {
        Object objeto = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq(filtro, obj));
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
        return objeto;
    }

    public static Object buscarObjetoLogin(String login, Class<?> classe) {
        Object objeto = null;
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("login", login));
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
        return objeto;
    }

    public static List<?> buscarTodasPessoas(Class<?> classe, int tipo) {
        ArrayList<?> objetos = null;
        Session session = HibernateUtil.openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("tipo", tipo));
            objetos = (ArrayList<?>) criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return objetos;
    }

    public static List<?> buscarMatriculasOrientador(Class<?> classe, int status, Pessoa orientador) {
        ArrayList<?> objetos = null;
        Session session = HibernateUtil.openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("status", status));
            criteria.add(Restrictions.eq("orientador", orientador));
            objetos = (ArrayList<?>) criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return objetos;
    }
    
    public static List<?> buscarMatriculasAvaliadasEAprovadas(Class<?> classe, Pessoa orientador) {
        ArrayList<?> objetos = null;
        Session session = HibernateUtil.openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(classe);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            criteria.add(Restrictions.disjunction().add(
                    Restrictions.and(Restrictions.eq("status", 3),
                            Restrictions.eq("avaliado", true),
                            Restrictions.eq("orientador", orientador))));
            objetos = (ArrayList<?>) criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return objetos;
    }

    public static List<?> buscaMatriculasAtivas(Class<?> classe, Pessoa aluno) {
        ArrayList<?> objetos = null;
        Session session = HibernateUtil.openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.disjunction().add(
                    Restrictions.or(Restrictions.eq("status", 0),
                            Restrictions.eq("status", 1))));
            criteria.add(Restrictions.eq("aluno", aluno));
            objetos = (ArrayList<?>) criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return objetos;
    }

    public static List<?> buscaMatriculasAlunos(Class<?> classe, int status, Pessoa aluno) {
        ArrayList<?> objetos = null;
        Session session = HibernateUtil.openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("status", status));
            criteria.add(Restrictions.eq("aluno", aluno));
            objetos = (ArrayList<?>) criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return objetos;
    }

    public static boolean excluir(int codigo, Class type) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Object object = session.get(type, codigo);
            session.delete(object);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
