/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.student;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andres
 */
@Embeddable
public class EstudiantePorCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTUDIANTE_ID")
    private int estudianteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CURSO")
    private int codigoCurso;

    public EstudiantePorCursoPK() {
    }

    public EstudiantePorCursoPK(int estudianteId, int codigoCurso) {
        this.estudianteId = estudianteId;
        this.codigoCurso = codigoCurso;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estudianteId;
        hash += (int) codigoCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantePorCursoPK)) {
            return false;
        }
        EstudiantePorCursoPK other = (EstudiantePorCursoPK) object;
        if (this.estudianteId != other.estudianteId) {
            return false;
        }
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.EstudiantePorCursoPK[ estudianteId=" + estudianteId + ", codigoCurso=" + codigoCurso + " ]";
    }
    
}
