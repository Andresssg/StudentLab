/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.unipiloto.course.servlet;


import co.edu.unipiloto.student.Curso;
import co.edu.unipiloto.student.session.CursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class CourseServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Curso curso = new Curso();

        String codigoCurso = request.getParameter("codigoCurso");
        int codigo = 0;

        String nombreCurso = request.getParameter("nombreCurso");

        String creditosCurso = request.getParameter("creditos");
        int creditos = 0;

        String semestreCurso = request.getParameter("semestre");
        int semestre = 0;

        String estudiantes = request.getParameter("estudiantesAdmitidos");
        int estudiantesAdmitidos = 0;

        if (codigoCurso != null && !codigoCurso.equals("")) {
            codigo = Integer.parseInt(codigoCurso);
        }

        if (semestreCurso != null && !semestreCurso.equals("")) {
            semestre = Integer.parseInt(semestreCurso);
        }

        if (creditosCurso != null && !creditosCurso.equals("")) {
            creditos = Integer.parseInt(creditosCurso);
        }

        if (estudiantes != null && !estudiantes.equals("")) {
            estudiantesAdmitidos = Integer.parseInt(semestreCurso);
        }

        String action = request.getParameter("action2");

        if (action.equals("Add")) {
            curso.setNombrecurso(nombreCurso);
            curso.setCreditos(creditos);
            curso.setSemestre(semestre);
            curso.setEstudiantesadmitidos(estudiantesAdmitidos);
            cursoFacade.create(curso);
        } else if (action.equals("Edit")) {
            curso.setCodigocurso(codigo);
            curso.setNombrecurso(nombreCurso);
            curso.setCreditos(creditos);
            curso.setSemestre(semestre);
            curso.setEstudiantesadmitidos(estudiantesAdmitidos);
            cursoFacade.edit(curso);
        } else if (action.equals("Delete")) {
            curso.setCodigocurso(codigo);
            curso.setNombrecurso(nombreCurso);
            curso.setCreditos(creditos);
            curso.setSemestre(semestre);
            curso.setEstudiantesadmitidos(estudiantesAdmitidos);
            cursoFacade.remove(curso);
        } else {
            request.setAttribute("cursos", cursoFacade.findAll());
        }

        request.setAttribute("curso", curso);
        request.setAttribute("cursos", cursoFacade.findAll());
        request.getRequestDispatcher("StudentInfo.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
