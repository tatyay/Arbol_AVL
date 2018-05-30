/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
            out.println("<body style=\"background-color:#d0e1e1\">");
            out.println("<div style=\"text-align:center\">" + resul + "<div>");
            out.println("<hr>");
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
            resul = "<div style=\"text-align: center;border: 1px solid #4CAF50;width: 75%;margin: auto;\">";
            switch (action) {
                case "Generar Arbol_A":
                    if(!arboles_A.containsKey(ent_AA)){
                        arboles_A.put(ent_AA, new ArbolAVL());
                        resul += "<h2>ARBOL <u>"+ent_AA+"</u> DE ESTUDIANTES CREADO</h2>";
            
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AA+"</u> YA EXISTE</h2>";
                    }
                    break;
                case "Insertar Alumno":
                    if(arboles_A.containsKey(ent_AA)){
                        arboles_A.get(ent_AA).insert(cod_AA, name_AA);
                        resul += "<h2>EL ESTUDIANTE <u>"+name_AA+"</u> HA SIDO AGREGADO CON EXITO</h2>";
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AA+"</u> NO EXISTE</h2>";
                    }
                    break;
                case "Retirar Alumno":
                    if(arboles_A.containsKey(ent_AA)){
                        /*%%%%%%%%%%%%%%%%%%% AÑADIR CODIGO DE RETIRAR AQUI %%%%%%%%%%%%%%%%%%%%%*/
                        //arboles_A.get(ent_AA).retirar?
                        resul += "<h2>EL ESTUDIANTE "+name_AA+" HA SIDO REMOVIDO DEL ARBOL</h2>";
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AA+"</u> NO EXISTE</h2>";
                    }
                    break;
                case "Listar Alumnos":
                    if(arboles_A.containsKey(ent_AA)){
                        resul+="<h2>ESTUDIANTES DE LA ENTIDAD "+ent_AA+"</h2>";
                        resul+= "</div>";
                        resul+="<br>";
                        resul+= "<div style=\"text-align: center;border: 1px solid #4CAF50;width: 75%;margin: auto;\">";
                        resul+="<br>";
                        resul+="<table align=center border=\"1\" cellpadding=\"3\" cellspacing=\"0\">";
                        resul+="<tr>";
                        resul+="<td>Balance</td><td>Codigo</td><td>Nombre</td>";
                        resul+="</tr>";
                        resul+=arboles_A.get(ent_AA).getInorden();
                        resul+="</table>";                       
                        resul+="<br>";
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AA+"</u> NO EXISTE</h2>";
                    }
                    break;
                case "Generar Arbol_M":
                    if(!arboles_M.containsKey(ent_AM)){
                        arboles_M.put(ent_AM, new ArbolAVL());
                        resul += "<h2>ARBOL "+ent_AM+" DE MATERIAS CREADO</h2>";
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AM+"</u> YA EXISTE</h2>";
                    }
                    break;
                case "Insertar Materia":
                    if(arboles_M.containsKey(ent_AM)){
                        arboles_M.get(ent_AM).insert(cod_AM, name_AM);
                        resul += "<h2>LA MATERIA "+name_AM+" HA SIDO AGREGADA CON EXITO</h2>";
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AM+"</u> NO EXISTE</h2>";
                    }
                    break;
                case "Retirar Materia":
                    if(arboles_M.containsKey(ent_AM)){
                        /*%%%%%%%%%%%%%%%%%%% AÑADIR CODIGO DE RETIRAR AQUI %%%%%%%%%%%%%%%%%%%%%*/
                        //arboles_M.get(ent_AM).retirar?
                        resul += "<h2>LA MATERIA "+name_AM+" HA SIDO REMOVIDA DEL ARBOL</h2>";
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AM+"</u> NO EXISTE</h2>";
                    }
                    break;
                case "Listar Materias":
                    if(arboles_M.containsKey(ent_AM)){
                        resul+="<h2>MATERIAS DE LA ENTIDAD "+ent_AM+"</h2>";
                        resul+="<br>";   
                        resul+= "</div>";
                        resul+= "<div style=\"text-align: center;border: 1px solid #4CAF50;width: 75%;margin: auto;\">";
                        resul+="<table align=center border=\"1\" cellpadding=\"3\" cellspacing=\"0\">";
                        resul+="<tr>";
                        resul+="<td>Balance</td><td>Codigo</td><td>Nombre</td>";
                        resul+="</tr>";
                        resul+=arboles_M.get(ent_AM).getInorden();
                        resul+="</table>";
                    }else{
                        resul += "<h2>EL ARBOL <u>"+ent_AM+"</u> NO EXISTE</h2>";
                    }
                    break;
                case "Materias X Alumno": 
                    break;
                case "Alumnos X Materia": 
                    break;
            }
            resul += "</div>";
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}