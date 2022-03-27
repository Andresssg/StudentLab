/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.student;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstudianteid", query = "SELECT e FROM Estudiante e WHERE e.estudianteid = :estudianteid"),
    @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiante.findByApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Estudiante.findBySemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :semestre")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ESTUDIANTEID")
    private Integer estudianteid;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private Collection<EstudiantePorCurso> estudiantePorCursoCollection;

    public Estudiante() {
    }

    public Estudiante(Integer estudianteid) {
        this.estudianteid = estudianteid;
    }

    public Integer getEstudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(Integer estudianteid) {
        this.estudianteid = estudianteid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    @XmlTransient
    public Collection<EstudiantePorCurso> getEstudiantePorCursoCollection() {
        return estudiantePorCursoCollection;
    }

    public void setEstudiantePorCursoCollection(Collection<EstudiantePorCurso> estudiantePorCursoCollection) {
        this.estudiantePorCursoCollection = estudiantePorCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteid != null ? estudianteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudianteid == null && other.estudianteid != null) || (this.estudianteid != null && !this.estudianteid.equals(other.estudianteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.Estudiante[ estudianteid=" + estudianteid + " ]";
    }
    
}
