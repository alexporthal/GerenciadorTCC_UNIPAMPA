package br.edu.unipampa.geketcc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/*
 * Aluno Model
 *
 * @author Gean Pereira
 * @since 09/12/2014
 */
@Entity
@DiscriminatorValue(value = "1")
public class Aluno extends Pessoa {

    public Aluno(){}
    
    public Aluno(Pessoa pessoa) {
        super.setCodigo(pessoa.getCodigo());
        super.setTipo(pessoa.getTipo());
        super.setNome(pessoa.getNome());
        super.setEmail(pessoa.getEmail());
        super.setMatricula(pessoa.getMatricula());
        super.setCargaHoraria(pessoa.getCargaHoraria());
    }
}
