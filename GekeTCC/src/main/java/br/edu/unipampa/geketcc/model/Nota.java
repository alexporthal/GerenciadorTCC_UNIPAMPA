/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.geketcc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n"),
    @NamedQuery(name = "Nota.findByCodigo", query = "SELECT n FROM Nota n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "Nota.findByRelevancia", query = "SELECT n FROM Nota n WHERE n.relevancia = :relevancia"),
    @NamedQuery(name = "Nota.findByEstadoArte", query = "SELECT n FROM Nota n WHERE n.estadoArte = :estadoArte"),
    @NamedQuery(name = "Nota.findByClarezaApresentacao", query = "SELECT n FROM Nota n WHERE n.clarezaApresentacao = :clarezaApresentacao"),
    @NamedQuery(name = "Nota.findByCorretudeTecnica", query = "SELECT n FROM Nota n WHERE n.corretudeTecnica = :corretudeTecnica"),
    @NamedQuery(name = "Nota.findByAbrangencia", query = "SELECT n FROM Nota n WHERE n.abrangencia = :abrangencia"),
    @NamedQuery(name = "Nota.findByConhecimento", query = "SELECT n FROM Nota n WHERE n.conhecimento = :conhecimento"),
    @NamedQuery(name = "Nota.findByPlanejamento", query = "SELECT n FROM Nota n WHERE n.planejamento = :planejamento"),
    @NamedQuery(name = "Nota.findByClarezaTexto", query = "SELECT n FROM Nota n WHERE n.clarezaTexto = :clarezaTexto"),
    @NamedQuery(name = "Nota.findByGramaticaOrtografia", query = "SELECT n FROM Nota n WHERE n.gramaticaOrtografia = :gramaticaOrtografia"),
    @NamedQuery(name = "Nota.findByEstruturaOrg", query = "SELECT n FROM Nota n WHERE n.estruturaOrg = :estruturaOrg"),
    @NamedQuery(name = "Nota.findByNotaFinalAvaliacao", query = "SELECT n FROM Nota n WHERE n.notaFinalAvaliacao = :notaFinalAvaliacao")})
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "relevancia")
    private float relevancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoArte")
    private float estadoArte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clarezaApresentacao")
    private float clarezaApresentacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corretudeTecnica")
    private float corretudeTecnica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abrangencia")
    private float abrangencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conhecimento")
    private float conhecimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planejamento")
    private float planejamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clarezaTexto")
    private float clarezaTexto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gramaticaOrtografia")
    private float gramaticaOrtografia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estruturaOrg")
    private float estruturaOrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notaFinalAvaliacao")
    private float notaFinalAvaliacao;
    @JoinColumn(name = "membroBanca", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private MembroBanca membroBanca;

    public Nota() {
    }

    public Nota(Integer codigo) {
        this.codigo = codigo;
    }

    public Nota(Integer codigo, float relevancia, float estadoArte, float clarezaApresentacao, float corretudeTecnica, float abrangencia, float conhecimento, float planejamento, float clarezaTexto, float gramaticaOrtografia, float estruturaOrg, float notaFinalAvaliacao) {
        this.codigo = codigo;
        this.relevancia = relevancia;
        this.estadoArte = estadoArte;
        this.clarezaApresentacao = clarezaApresentacao;
        this.corretudeTecnica = corretudeTecnica;
        this.abrangencia = abrangencia;
        this.conhecimento = conhecimento;
        this.planejamento = planejamento;
        this.clarezaTexto = clarezaTexto;
        this.gramaticaOrtografia = gramaticaOrtografia;
        this.estruturaOrg = estruturaOrg;
        this.notaFinalAvaliacao = notaFinalAvaliacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public float getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(float relevancia) {
        this.relevancia = relevancia;
    }

    public float getEstadoArte() {
        return estadoArte;
    }

    public void setEstadoArte(float estadoArte) {
        this.estadoArte = estadoArte;
    }

    public float getClarezaApresentacao() {
        return clarezaApresentacao;
    }

    public void setClarezaApresentacao(float clarezaApresentacao) {
        this.clarezaApresentacao = clarezaApresentacao;
    }

    public float getCorretudeTecnica() {
        return corretudeTecnica;
    }

    public void setCorretudeTecnica(float corretudeTecnica) {
        this.corretudeTecnica = corretudeTecnica;
    }

    public float getAbrangencia() {
        return abrangencia;
    }

    public void setAbrangencia(float abrangencia) {
        this.abrangencia = abrangencia;
    }

    public float getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(float conhecimento) {
        this.conhecimento = conhecimento;
    }

    public float getPlanejamento() {
        return planejamento;
    }

    public void setPlanejamento(float planejamento) {
        this.planejamento = planejamento;
    }

    public float getClarezaTexto() {
        return clarezaTexto;
    }

    public void setClarezaTexto(float clarezaTexto) {
        this.clarezaTexto = clarezaTexto;
    }

    public float getGramaticaOrtografia() {
        return gramaticaOrtografia;
    }

    public void setGramaticaOrtografia(float gramaticaOrtografia) {
        this.gramaticaOrtografia = gramaticaOrtografia;
    }

    public float getEstruturaOrg() {
        return estruturaOrg;
    }

    public void setEstruturaOrg(float estruturaOrg) {
        this.estruturaOrg = estruturaOrg;
    }

    public float getNotaFinalAvaliacao() {
        return notaFinalAvaliacao;
    }

    public void setNotaFinalAvaliacao(float notaFinalAvaliacao) {
        this.notaFinalAvaliacao = notaFinalAvaliacao;
    }

    public MembroBanca getMembroBanca() {
        return membroBanca;
    }

    public void setMembroBanca(MembroBanca membroBanca) {
        this.membroBanca = membroBanca;
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
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unipampa.geketcc.model.Nota[ codigo=" + codigo + " ]";
    }
    
}
