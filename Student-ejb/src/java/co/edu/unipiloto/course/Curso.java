/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.course;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodigocurso", query = "SELECT c FROM Curso c WHERE c.codigocurso = :codigocurso"),
    @NamedQuery(name = "Curso.findByNombrecurso", query = "SELECT c FROM Curso c WHERE c.nombrecurso = :nombrecurso"),
    @NamedQuery(name = "Curso.findByCreditos", query = "SELECT c FROM Curso c WHERE c.creditos = :creditos"),
    @NamedQuery(name = "Curso.findBySemestre", query = "SELECT c FROM Curso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Curso.findByEstudiantesadmitidos", query = "SELECT c FROM Curso c WHERE c.estudiantesadmitidos = :estudiantesadmitidos")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOCURSO")
    private Integer codigocurso;
    @Size(max = 50)
    @Column(name = "NOMBRECURSO")
    private String nombrecurso;
    @Column(name = "CREDITOS")
    private Integer creditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "ESTUDIANTESADMITIDOS")
    private Integer estudiantesadmitidos;

    public Curso() {
    }

    public Curso(Integer codigocurso) {
        this.codigocurso = codigocurso;
    }

    public Integer getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(Integer codigocurso) {
        this.codigocurso = codigocurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getEstudiantesadmitidos() {
        return estudiantesadmitidos;
    }

    public void setEstudiantesadmitidos(Integer estudiantesadmitidos) {
        this.estudiantesadmitidos = estudiantesadmitidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocurso != null ? codigocurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codigocurso == null && other.codigocurso != null) || (this.codigocurso != null && !this.codigocurso.equals(other.codigocurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.course.Curso[ codigocurso=" + codigocurso + " ]";
    }

}
