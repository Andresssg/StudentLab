/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.student;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "ESTUDIANTE_POR_CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudiantePorCurso.findAll", query = "SELECT e FROM EstudiantePorCurso e"),
    @NamedQuery(name = "EstudiantePorCurso.findByEstudianteId", query = "SELECT e FROM EstudiantePorCurso e WHERE e.estudiantePorCursoPK.estudianteId = :estudianteId"),
    @NamedQuery(name = "EstudiantePorCurso.findByCodigoCurso", query = "SELECT e FROM EstudiantePorCurso e WHERE e.estudiantePorCursoPK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "EstudiantePorCurso.findByNotaDefinitiva", query = "SELECT e FROM EstudiantePorCurso e WHERE e.notaDefinitiva = :notaDefinitiva"),
    @NamedQuery(name = "EstudiantePorCurso.findByAprobado", query = "SELECT e FROM EstudiantePorCurso e WHERE e.aprobado = :aprobado")})
public class EstudiantePorCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiantePorCursoPK estudiantePorCursoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA_DEFINITIVA")
    private Double notaDefinitiva;
    @Column(name = "APROBADO")
    private Boolean aprobado;
    @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "CODIGOCURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "ESTUDIANTE_ID", referencedColumnName = "ESTUDIANTEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public EstudiantePorCurso() {
    }

    public EstudiantePorCurso(EstudiantePorCursoPK estudiantePorCursoPK) {
        this.estudiantePorCursoPK = estudiantePorCursoPK;
    }

    public EstudiantePorCurso(int estudianteId, int codigoCurso) {
        this.estudiantePorCursoPK = new EstudiantePorCursoPK(estudianteId, codigoCurso);
    }

    public EstudiantePorCursoPK getEstudiantePorCursoPK() {
        return estudiantePorCursoPK;
    }

    public void setEstudiantePorCursoPK(EstudiantePorCursoPK estudiantePorCursoPK) {
        this.estudiantePorCursoPK = estudiantePorCursoPK;
    }

    public Double getNotaDefinitiva() {
        return notaDefinitiva;
    }

    public void setNotaDefinitiva(Double notaDefinitiva) {
        this.notaDefinitiva = notaDefinitiva;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiantePorCursoPK != null ? estudiantePorCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantePorCurso)) {
            return false;
        }
        EstudiantePorCurso other = (EstudiantePorCurso) object;
        if ((this.estudiantePorCursoPK == null && other.estudiantePorCursoPK != null) || (this.estudiantePorCursoPK != null && !this.estudiantePorCursoPK.equals(other.estudiantePorCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.EstudiantePorCurso[ estudiantePorCursoPK=" + estudiantePorCursoPK + " ]";
    }
    
}
