/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.unipiloto.grades.servlet;

import co.edu.unipiloto.student.EstudiantePorCurso;
import co.edu.unipiloto.student.EstudiantePorCursoPK;
import co.edu.unipiloto.student.session.EstudiantePorCursoFacadeLocal;
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
public class GradesServlet extends HttpServlet {

    @EJB
    private EstudiantePorCursoFacadeLocal estudiantePorCursoFacade;

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

        EstudiantePorCursoPK estudiantePorCursoPK;
        String estudianteIDStr = request.getParameter("gradesEstudianteID");
        int estudianteID = 0;
        String codigoCursoStr = request.getParameter("gradesCodigoCurso");
        int codigoCurso = 0;
        String nota = request.getParameter("notaDefinitiva");
        double notaDefinitiva = 0;

        if (estudianteIDStr != null && !"".equals(estudianteIDStr)) {
            estudianteID = Integer.parseInt(estudianteIDStr);
        }
        if (codigoCursoStr != null && !"".equals(codigoCursoStr)) {
            codigoCurso = Integer.parseInt(codigoCursoStr);
        }
        if (nota != null && !"".equals(nota)) {
            notaDefinitiva = Double.parseDouble(nota);
        }

        estudiantePorCursoPK = new EstudiantePorCursoPK(estudianteID, codigoCurso);

        EstudiantePorCurso estudiantePorCurso = new EstudiantePorCurso(estudiantePorCursoPK);
        estudiantePorCurso.setNotaDefinitiva(notaDefinitiva);
        estudiantePorCurso.setAprobado(notaDefinitiva >= 3.0);

        String action = request.getParameter("action3");
        if (action.equals("Add")) {
            estudiantePorCursoFacade.create(estudiantePorCurso);
        } else if (action.equals("Edit")) {
            estudiantePorCursoFacade.edit(estudiantePorCurso);
        } else if (action.equals("Delete")) {
            estudiantePorCursoFacade.remove(estudiantePorCurso);
        } else if (action.equals("Search")) {
            request.setAttribute("grades", estudiantePorCursoFacade.findAll());
        }

        request.setAttribute("grade", estudiantePorCurso);
        request.setAttribute("grades", estudiantePorCursoFacade.findAll());
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
