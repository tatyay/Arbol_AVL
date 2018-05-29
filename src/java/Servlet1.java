/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.faces.util.CollectionsUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateo
 */
@WebServlet(urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {
    
    HashMap<String, ArbolAVL> arboles_A = new HashMap<>();
    HashMap<String, ArbolAVL> arboles_M = new HashMap<>();
    String resul = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Arbol AVL</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"text-align:center\"><h1>" + resul + "</h1><div>");
            out.println("<a href=\"javascript:history.back(-1);\">Regresar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        
        String action = request.getParameter("action");
        
        String ent_AA = request.getParameter("entidad_A");
        String cod_AA = request.getParameter("codigo_A");
        String name_AA = request.getParameter("nombre_A");
        
        String ent_AM = request.getParameter("entidad_M");
        String cod_AM = request.getParameter("codigo_M");
        String name_AM = request.getParameter("nombre_M");
        
        String ent_A = request.getParameter("nombre_E_A");
        String ent_M = request.getParameter("nombre_E_M");
        if (action != null) {
            switch (action) {
                case "Generar Arbol_A":
                    if(!arboles_A.containsKey(ent_AA)){
                        arboles_A.put(ent_AA, new ArbolAVL());
                        resul = "ARBOL "+ent_AA+" DE ESTUDIANTES CREADO";
                    }else{
                        resul = "EL ARBOL "+ent_AA+" YA EXISTE";
                    }
                    break;
                case "Insertar Alumno":
                    if(arboles_A.containsKey(ent_AA)){
                        arboles_A.get(ent_AA).insert("Cosa a insertar");
                        resul = "EL ESTUDIANTE "+name_AA+" HA SIDO AGREGADO CON EXITO";
                    }else{
                        resul = "EL ARBOL "+ent_AA+" NO EXISTE";
                    }
                    break;
                case "Retirar Alumno":
                    if(arboles_A.containsKey(ent_AA)){
                        resul = "EL ESTUDIANTE "+name_AA+" HA SIDO REMOVIDO DEL ARBOL";
                    }else{
                         resul = "EL ARBOL "+ent_AA+" NO EXISTE";
                    }
                    break;
                case "Listar Alumnos":
                    if(arboles_A.containsKey(ent_AA)){
                        resul="";
                    }else{
                         resul = "EL ARBOL "+ent_AA+" NO EXISTE";
                    }
                    break;
                case "Generar Arbol_M":
                    if(!arboles_M.containsKey(ent_AM)){
                        arboles_M.put(ent_AM, new ArbolAVL());
                        resul = "ARBOL "+ent_AM+" DE MATERIAS CREADO";
                    }else{
                        resul = "EL ARBOL "+ent_AM+" YA EXISTE";
                    }
                    break;
                case "Insertar Materia":
                    if(arboles_M.containsKey(ent_AM)){
                        arboles_M.get(ent_AM).insert("Cosa a Insertar");
                        resul = "LA MATERIA "+name_AM+" HA SIDO AGREGADA CON EXITO";
                    }else{
                        resul = "EL ARBOL "+ent_AM+" NO EXISTE";
                    }
                    break;
                case "Retirar Materia":
                    if(arboles_M.containsKey(ent_AM)){
                        resul = "LA MATERIA "+name_AM+" HA SIDO REMOVIDA DEL ARBOL";
                    }else{
                         resul = "EL ARBOL "+ent_AM+" NO EXISTE";
                    }
                    break;
                case "Listar Materias":
                    if(arboles_M.containsKey(ent_AM)){
                        resul="";
                    }else{
                        resul = "EL ARBOL "+ent_AM+" NO EXISTE"; 
                    }
                    break;
                case "Materias X Alumno": 
                    break;
                case "Alumnos X Materia": 
                    break;
            }
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}