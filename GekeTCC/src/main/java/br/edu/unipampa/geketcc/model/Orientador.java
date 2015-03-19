package br.edu.unipampa.geketcc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * Orientador Model
 *
 * @author Gean Pereira
 * @since 09/12/2014
 */
@Entity
@DiscriminatorValue(value = "2")
public class Orientador extends Pessoa {
   
    public Orientador() {
        
    }

    public Orientador(Pessoa pessoa) {
        super.setCodigo(pessoa.getCodigo());
        super.setTipo(pessoa.getTipo());
        super.setNome(pessoa.getNome());
        super.setEmail(pessoa.getEmail());
        super.setMatricula(pessoa.getMatricula());
        super.setCargaHoraria(pessoa.getCargaHoraria());
    }
}
