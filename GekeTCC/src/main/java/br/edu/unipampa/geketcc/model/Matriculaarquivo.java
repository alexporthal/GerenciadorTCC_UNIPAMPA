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
import javax.persistence.Lob;
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
@Table(name = "matriculaarquivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matriculaarquivo.findAll", query = "SELECT m FROM Matriculaarquivo m"),
    @NamedQuery(name = "Matriculaarquivo.findByCodigo", query = "SELECT m FROM Matriculaarquivo m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Matriculaarquivo.findByStatus", query = "SELECT m FROM Matriculaarquivo m WHERE m.status = :status")})
public class Matriculaarquivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "matricula", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Matricula matricula;

    public Matriculaarquivo() {
    }

    public Matriculaarquivo(Integer codigo) {
        this.codigo = codigo;
    }

    public Matriculaarquivo(Integer codigo, byte[] arquivo, int status) {
        this.codigo = codigo;
        this.arquivo = arquivo;
        this.status = status;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "br.edu.unipampa.geketcc.model.Matriculaarquivo[ codigo=" + codigo + " ]";
    }
    
}
