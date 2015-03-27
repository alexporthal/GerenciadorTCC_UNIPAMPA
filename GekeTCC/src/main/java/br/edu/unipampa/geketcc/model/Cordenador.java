package br.edu.unipampa.geketcc.model;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/*
 * Cordenador Model
 *
 * @author Gean Pereira
 * @since 09/12/2014
 */
@Entity
@DiscriminatorValue(value = "3")
public class Cordenador extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "matricula")
    private String matricula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<Matricula> matriculaCollection;
    @OneToMany(mappedBy = "coorientador")
    private Collection<Matricula> matriculaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orientador")
    private Collection<Matricula> matriculaCollection2;

    public Cordenador() {
    }

    public Cordenador(Pessoa pessoa) {
        super.setCodigo(pessoa.getCodigo());
        super.setTipo(pessoa.getTipo());
        super.setNome(pessoa.getNome());
        super.setEmail(pessoa.getEmail());
        super.setMatricula(pessoa.getMatricula());
    }

    public Cordenador(Integer codigo) {
        this.codigo = codigo;
    }

    public Cordenador(Integer codigo, int tipo, String nome, String email) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
    }

//    public Integer getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(Integer codigo) {
//        this.codigo = codigo;
//    }
//
//    public int getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(int tipo) {
//        this.tipo = tipo;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSiap() {
//        return siap;
//    }
//
//    public void setSiap(String siap) {
//        this.siap = siap;
//    }
//
//    public String getMatricula() {
//        return matricula;
//    }
//
//    public void setMatricula(String matricula) {
//        this.matricula = matricula;
//    }
//
//    public Integer getCargaHoraria() {
//        return cargaHoraria;
//    }
//
//    public void setCargaHoraria(Integer cargaHoraria) {
//        this.cargaHoraria = cargaHoraria;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    @XmlTransient
//    public Collection<Matricula> getMatriculaCollection() {
//        return matriculaCollection;
//    }
//
//    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
//        this.matriculaCollection = matriculaCollection;
//    }
//
//    @XmlTransient
//    public Collection<Matricula> getMatriculaCollection1() {
//        return matriculaCollection1;
//    }
//
//    public void setMatriculaCollection1(Collection<Matricula> matriculaCollection1) {
//        this.matriculaCollection1 = matriculaCollection1;
//    }
//
//    @XmlTransient
//    public Collection<Matricula> getMatriculaCollection2() {
//        return matriculaCollection2;
//    }
//
//    public void setMatriculaCollection2(Collection<Matricula> matriculaCollection2) {
//        this.matriculaCollection2 = matriculaCollection2;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (codigo != null ? codigo.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Cordenador)) {
//            return false;
//        }
//        Cordenador other = (Cordenador) object;
//        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "br.edu.unipampa.geketcc.model.Cordenador[ codigo=" + codigo + " ]";
//    }

}
