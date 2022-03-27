/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.EstudiantePorCurso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface EstudiantePorCursoFacadeLocal {

    void create(EstudiantePorCurso estudiantePorCurso);

    void edit(EstudiantePorCurso estudiantePorCurso);

    void remove(EstudiantePorCurso estudiantePorCurso);

    EstudiantePorCurso find(Object id);

    List<EstudiantePorCurso> findAll();

    List<EstudiantePorCurso> findRange(int[] range);

    int count();
    
}
