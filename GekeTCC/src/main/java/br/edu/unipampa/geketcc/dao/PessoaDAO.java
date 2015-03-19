package br.edu.unipampa.geketcc.dao;

import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.ArrayList;

/*
 * Pessoa DAO
 *
 * @author Alex Becker
 * @since 10/12/2014
 */
public class PessoaDAO {

    public ArrayList<Pessoa> buscarTodosProfessores() {
        return (ArrayList<Pessoa>) CRUD.buscarTodasPessoas(Pessoa.class, 1);
    }

    /**
     * Salvar a registro pessoa
     *
     * @param pessoa
     * @return
     */
    public boolean salvar(Pessoa pessoa) {
        return CRUD.salvar(pessoa);
    }

    /**
     * Busca uma pessoa a partir de seu código identificador
     *
     * @param codigo
     * @return
     */
    public Pessoa buscar(int codigo) {
        return (Pessoa) CRUD.buscarObjeto(codigo, Pessoa.class);
    }

}
