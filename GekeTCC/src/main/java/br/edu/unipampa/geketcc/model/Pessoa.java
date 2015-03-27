package br.edu.unipampa.geketcc.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Pessoa
 *
 * @version v 1.0 27/03/2015
 * @author Alex Becker
 * @since 27/03/2015
 *
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String emailAlternativo;

    @Size(max = 15)
    @Column(name = "matricula")
    private String matricula;

    @Size(max = 60)
    @Column(name = "curso")
    private String curso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membro")
    private Collection<MembroBanca> membroBancaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<Matricula> matriculaCollection;

    @OneToMany(mappedBy = "coorientador")
    private Collection<Matricula> matriculaCollection1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orientador")
    private Collection<Matricula> matriculaCollection2;

    public Pessoa() {
    }

    public Pessoa(Integer codigo) {
        this.codigo = codigo;
    }

    public Pessoa(Integer codigo, int tipo, String nome, String email) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @XmlTransient
    public Collection<MembroBanca> getMembroBancaCollection() {
        return membroBancaCollection;
    }

    public void setMembroBancaCollection(Collection<MembroBanca> membroBancaCollection) {
        this.membroBancaCollection = membroBancaCollection;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection1() {
        return matriculaCollection1;
    }

    public void setMatriculaCollection1(Collection<Matricula> matriculaCollection1) {
        this.matriculaCollection1 = matriculaCollection1;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection2() {
        return matriculaCollection2;
    }

    public void setMatriculaCollection2(Collection<Matricula> matriculaCollection2) {
        this.matriculaCollection2 = matriculaCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unipampa.geketcc.model.Pessoa[ codigo=" + codigo + " ]";
    }

}
