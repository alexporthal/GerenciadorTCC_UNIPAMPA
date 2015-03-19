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
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByCodigo", query = "SELECT m FROM Matricula m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Matricula.findByTema", query = "SELECT m FROM Matricula m WHERE m.tema = :tema"),
    @NamedQuery(name = "Matricula.findByDescricao", query = "SELECT m FROM Matricula m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Matricula.findByTcc", query = "SELECT m FROM Matricula m WHERE m.tcc = :tcc"),
    @NamedQuery(name = "Matricula.findByStatus", query = "SELECT m FROM Matricula m WHERE m.status = :status"),
    @NamedQuery(name = "Matricula.findByMotivoReprovacao", query = "SELECT m FROM Matricula m WHERE m.motivoReprovacao = :motivoReprovacao"),
    @NamedQuery(name = "Matricula.findByNotaFinal", query = "SELECT m FROM Matricula m WHERE m.notaFinal = :notaFinal"),
    @NamedQuery(name = "Matricula.findByAvaliado", query = "SELECT m FROM Matricula m WHERE m.avaliado = :avaliado")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tema")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tcc")
    private int tcc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Size(max = 200)
    @Column(name = "motivoReprovacao")
    private String motivoReprovacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "notaFinal")
    private Float notaFinal;
    @Column(name = "avaliado")
    private Boolean avaliado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula", fetch = FetchType.EAGER)
    private Collection<MembroBanca> membroBancaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<Matriculaarquivo> matriculaarquivoCollection;
    @JoinColumn(name = "aluno", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Pessoa aluno;
    @JoinColumn(name = "coorientador", referencedColumnName = "codigo")
    @ManyToOne
    private Pessoa coorientador;
    @JoinColumn(name = "orientador", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Pessoa orientador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private Collection<Defesa> defesaCollection;

    public Matricula() {
    }

    public Matricula(Integer codigo) {
        this.codigo = codigo;
    }

    public Matricula(Integer codigo, String tema, String descricao, int tcc, int status) {
        this.codigo = codigo;
        this.tema = tema;
        this.descricao = descricao;
        this.tcc = tcc;
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTcc() {
        return tcc;
    }

    public void setTcc(int tcc) {
        this.tcc = tcc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMotivoReprovacao() {
        return motivoReprovacao;
    }

    public void setMotivoReprovacao(String motivoReprovacao) {
        this.motivoReprovacao = motivoReprovacao;
    }

    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Boolean getAvaliado() {
        return avaliado;
    }

    public void setAvaliado(Boolean avaliado) {
        this.avaliado = avaliado;
    }

    @XmlTransient
    public Collection<MembroBanca> getMembroBancaCollection() {
        return membroBancaCollection;
    }

    public void setMembroBancaCollection(Collection<MembroBanca> membroBancaCollection) {
        this.membroBancaCollection = membroBancaCollection;
    }

    @XmlTransient
    public Collection<Matriculaarquivo> getMatriculaarquivoCollection() {
        return matriculaarquivoCollection;
    }

    public void setMatriculaarquivoCollection(Collection<Matriculaarquivo> matriculaarquivoCollection) {
        this.matriculaarquivoCollection = matriculaarquivoCollection;
    }

    public Pessoa getAluno() {
        return aluno;
    }

    public void setAluno(Pessoa aluno) {
        this.aluno = aluno;
    }

    public Pessoa getCoorientador() {
        return coorientador;
    }

    public void setCoorientador(Pessoa coorientador) {
        this.coorientador = coorientador;
    }

    public Pessoa getOrientador() {
        return orientador;
    }

    public void setOrientador(Pessoa orientador) {
        this.orientador = orientador;
    }

    @XmlTransient
    public Collection<Defesa> getDefesaCollection() {
        return defesaCollection;
    }

    public void setDefesaCollection(Collection<Defesa> defesaCollection) {
        this.defesaCollection = defesaCollection;
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
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unipampa.geketcc.model.Matricula[ codigo=" + codigo + " ]";
    }
    
}
