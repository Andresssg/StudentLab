<%-- 
    Document   : StudentInfo
    Created on : 22-mar-2022, 19:09:18
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.estudianteid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.nombre}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.apellido}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.semestre}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="student">
                <tr>
                    <td>${student.estudianteid}</td>
                    <td>${student.nombre}</td>
                    <td>${student.apellido}</td>
                    <td>${student.semestre}</td>
                </tr>
            </c:forEach> 
        </table>
        <br><hr>
        <h1>Course Information</h1>
        <form action="./CourseServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo Curso</td>
                    <td><input type="text" name="codigoCurso" value="${curso.codigocurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre Curso</td>
                    <td><input type="text" name="nombreCurso" value="${curso.nombrecurso}" /></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="creditos" value="${curso.creditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                <tr>
                    <td>Estudiantes Admitidos</td>
                    <td><input type="text" name="estudiantesAdmitidos" value="${curso.estudiantesadmitidos}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action2" value="Add" />
                        <input type="submit" name="action2" value="Edit" />
                        <input type="submit" name="action2" value="Delete" />
                        <input type="submit" name="action2" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Codigo Curso</th>
            <th>Nombre Curso</th>
            <th>Creditos</th>
            <th>Semestre</th>
            <th>Estudiantes Admitidos</th>
                <c:forEach items="${cursos}" var="curso">
                <tr>
                    <td>${curso.codigocurso}</td>
                    <td>${curso.nombrecurso}</td>
                    <td>${curso.creditos}</td>
                    <td>${curso.semestre}</td>
                    <td>${curso.estudiantesadmitidos}</td>
                </tr>
            </c:forEach> 
        </table>
        <br><hr>
        <h1>Students' Grades by course</h1>
        <form action="./GradesServlet" method="POST">
            <table>
                <tr>
                    <td>Estudiante Id</td>
                    <td><input type="text" name="gradesEstudianteID" value="${grade.estudiante.estudianteid}" /></td>
                </tr>
                <tr>
                    <td>Codigo Curso</td>
                    <td><input type="text" name="gradesCodigoCurso" value="${grade.curso.codigocurso}" /></td>
                </tr>
                <tr>
                    <td>Nota Definitiva</td>
                    <td><input type="text" name="notaDefinitiva" value="${grade.notaDefinitiva}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action3" value="Add" />
                        <input type="submit" name="action3" value="Edit" />
                        <input type="submit" name="action3" value="Delete" />
                        <input type="submit" name="action3" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Estudiante Id</th>
            <th>Codigo Curso</th>
            <th>Nota Definitiva</th>
            <th>Aprobado</th>
                <c:forEach items="${grades}" var="info">
                <tr>
                    <td>${info.estudiante.estudianteid}</td>
                    <td>${info.curso.codigocurso}</td>
                    <td>${info.notaDefinitiva}</td>
                    <td>${info.aprobado}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>