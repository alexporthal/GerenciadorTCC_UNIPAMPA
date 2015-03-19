package br.edu.unipampa.geketcc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * Co-Orientador Model
 *
 * @author Gean Pereira
 * @since 09/12/2014
 */
@Entity
@DiscriminatorValue(value = "5")
public class CoOrientador extends Pessoa {
    public CoOrientador() {
    }

    public CoOrientador(Pessoa pessoa) {
        super.setCodigo(pessoa.getCodigo());
        super.setTipo(pessoa.getTipo());
        super.setNome(pessoa.getNome());
        super.setEmail(pessoa.getEmail());
        super.setMatricula(pessoa.getMatricula());
        super.setCargaHoraria(pessoa.getCargaHoraria());
    }
}
