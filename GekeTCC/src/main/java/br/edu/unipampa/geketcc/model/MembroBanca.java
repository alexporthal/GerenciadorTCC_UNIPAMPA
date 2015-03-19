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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "membrobanca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MembroBanca.findAll", query = "SELECT m FROM MembroBanca m"),
    @NamedQuery(name = "MembroBanca.findByCodigo", query = "SELECT m FROM MembroBanca m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "MembroBanca.findByPresenca", query = "SELECT m FROM MembroBanca m WHERE m.presenca = :presenca")})
public class MembroBanca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presenca")
    private boolean presenca;
    @JoinColumn(name = "matricula", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumn(name = "membro", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Pessoa membro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membroBanca")
    private Collection<Nota> notaCollection;

    public MembroBanca() {
    }

    public MembroBanca(Integer codigo) {
        this.codigo = codigo;
    }

    public MembroBanca(Integer codigo, boolean presenca) {
        this.codigo = codigo;
        this.presenca = presenca;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public boolean getPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Pessoa getMembro() {
        return membro;
    }

    public void setMembro(Pessoa membro) {
        this.membro = membro;
    }

    @XmlTransient
    public Collection<Nota> getNotaCollection() {
        return notaCollection;
    }

    public void setNotaCollection(Collection<Nota> notaCollection) {
        this.notaCollection = notaCollection;
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
        if (!(object instanceof MembroBanca)) {
            return false;
        }
        MembroBanca other = (MembroBanca) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unipampa.geketcc.model.MembroBanca[ codigo=" + codigo + " ]";
    }
    
}
