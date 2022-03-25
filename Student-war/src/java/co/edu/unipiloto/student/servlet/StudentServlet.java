/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.student.Estudiante;
import co.edu.unipiloto.student.session.EstudianteFacadeLocal;
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
public class StudentServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

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

        Estudiante estudiante = new Estudiante();

        String id = request.getParameter("studentId");
        int idEstudiante = 0;
        int semestreEstudiante = 0;
        String nombre = request.getParameter("firstName");
        String apellido = request.getParameter("lastName");
        String semestre = request.getParameter("yearLevel");

        if (id != null && !id.equals("")) {
            idEstudiante = Integer.parseInt(id);
        }

        if (semestre != null && !semestre.equals("")) {
            semestreEstudiante = Integer.parseInt(semestre);
        }

        String action = request.getParameter("action");

        if (action.equals("Add")) {
            estudiante.setEstudianteid(idEstudiante);
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setSemestre(semestreEstudiante);
            estudianteFacade.create(estudiante);
        } else if (action.equals("Edit")) {
            estudiante.setEstudianteid(idEstudiante);
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setSemestre(semestreEstudiante);
            estudianteFacade.edit(estudiante);
        } else if (action.equals("Delete")) {
            estudiante.setEstudianteid(idEstudiante);
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setSemestre(semestreEstudiante);
            estudianteFacade.remove(estudiante);
        } else {
            request.setAttribute("allStudents", estudianteFacade.findAll());
        }

        request.setAttribute("student", estudiante);
        request.setAttribute("allStudents", estudianteFacade.findAll());
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
