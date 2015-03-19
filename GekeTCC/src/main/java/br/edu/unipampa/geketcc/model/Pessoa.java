/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.geketcc.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCodigo", query = "SELECT p FROM Pessoa p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pessoa.findByTipo", query = "SELECT p FROM Pessoa p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findBySiap", query = "SELECT p FROM Pessoa p WHERE p.siap = :siap"),
    @NamedQuery(name = "Pessoa.findByMatricula", query = "SELECT p FROM Pessoa p WHERE p.matricula = :matricula"),
    @NamedQuery(name = "Pessoa.findByCargaHoraria", query = "SELECT p FROM Pessoa p WHERE p.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Pessoa.findByInstituicao", query = "SELECT p FROM Pessoa p WHERE p.instituicao = :instituicao")})
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "siap")
    private String siap;
    @Size(max = 15)
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "cargaHoraria")
    private Integer cargaHoraria;
    @Size(max = 60)
    @Column(name = "instituicao")
    private String instituicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membro")
    private Collection<MembroBanca> membroBancaCollection;
    @JoinColumn(name = "usuario", referencedColumnName = "codigo", updatable=true, insertable=true)
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Usuario usuario;
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

    public String getSiap() {
        return siap;
    }

    public void setSiap(String siap) {
        this.siap = siap;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    @XmlTransient
    public Collection<MembroBanca> getMembroBancaCollection() {
        return membroBancaCollection;
    }

    public void setMembroBancaCollection(Collection<MembroBanca> membroBancaCollection) {
        this.membroBancaCollection = membroBancaCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
