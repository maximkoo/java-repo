/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.maximkoo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
/**
 *
 * @author max
 */
public class Srvlt3 extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        
        JSONObject json = new JSONObject();

        json.put("Mobile", "9999988888");
        json.put("Name", "Maximkoo");

        out.print(json.toString());
    }
}
