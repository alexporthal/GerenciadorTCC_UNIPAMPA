/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.geketcc.dao;

import br.edu.unipampa.geketcc.model.Aluno;
import br.edu.unipampa.geketcc.model.Defesa;
import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.MembroBanca;
import java.util.HashMap;

/**
 *
 * @author Bruning
 */
public class BancaDAO {
    public boolean salvar(Defesa defesa) {
        return CRUD.salvar(defesa);
    }
    public Matricula buscar(Aluno aluno) {
        return null; //(Matricula) CRUD.buscarObjeto("aluno", aluno, Matricula.class);
    }
    
    public Defesa buscar(Matricula matricula) {
        HashMap filtros = new HashMap();
        filtros.put("matricula.codigo", matricula.getCodigo());
        return (Defesa) DAO.buscarObjeto(filtros, Defesa.class);
    }
    
      public MembroBanca buscar(Defesa banca) {
        return null;// (MembroBanca) CRUD.buscarObjeto("banca", banca, MembroBanca.class);
    }
}
