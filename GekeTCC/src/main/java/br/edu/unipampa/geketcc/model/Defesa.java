/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unipampa.geketcc.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "defesa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Defesa.findAll", query = "SELECT d FROM Defesa d"),
    @NamedQuery(name = "Defesa.findByCodigo", query = "SELECT d FROM Defesa d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Defesa.findByData", query = "SELECT d FROM Defesa d WHERE d.data = :data"),
    @NamedQuery(name = "Defesa.findByHora", query = "SELECT d FROM Defesa d WHERE d.hora = :hora"),
    @NamedQuery(name = "Defesa.findByLocal", query = "SELECT d FROM Defesa d WHERE d.local = :local")})
public class Defesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "hh:mm")
    private Date hora;
    @Size(max = 45)
    @Column(name = "local")
    private String local;
    @JoinColumn(name = "matricula", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Matricula matricula;

    public Defesa() {
    }

    public Defesa(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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
        if (!(object instanceof Defesa)) {
            return false;
        }
        Defesa other = (Defesa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.unipampa.geketcc.model.Defesa[ codigo=" + codigo + " ]";
    }
    
}
