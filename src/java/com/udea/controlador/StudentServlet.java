/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controlador;

import com.udea.dao.StudentDAOLocal;
import com.udea.modelo.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alejandro
 */
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentDAOLocal studentDAO;

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
        response.setContentType("text/html;charset=UTF-8");

        //Action sirve para tomar el evento del boton
        String action = request.getParameter("action");
        //Capturamos los datos desde el formulario
        String studentIdStr = request.getParameter("studentId");
        int studentId = 0;
        if (studentIdStr != null && !studentIdStr.equals("")) {
            studentId = Integer.parseInt(studentIdStr);
        }

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String yearLevelStr = request.getParameter("yearlevel");
        int yearlevel=0;
        if(yearLevelStr != null && !yearLevelStr.equals("")){
            yearlevel = Integer.parseInt(yearLevelStr);
        }
        //llamo el contructor con parametros
        Student student = new Student(studentId, firstname, lastname, yearlevel);
        //Realizo las acciones del boton segun el evento capturado
        if("Add".equalsIgnoreCase(action)){
            studentDAO.addStudent(student);
        }else if("Edit".equalsIgnoreCase(action)){
            studentDAO.editStudent(student);
        }else if("Delete".equalsIgnoreCase(action)){
            studentDAO.deleteStudent(studentId);
        }else if("Search".equalsIgnoreCase(action)){
            studentDAO.getStudent(studentId);
        }
        //Reenvio de objetos hacia la vista (index.jsp)
        request.setAttribute("student", student);//si es solo 1 objeto
        request.setAttribute("allStudents", studentDAO.getAllStudents());
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
