/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.maximkoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author max
 */
public class GenSec extends HttpServlet{
    String html;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        html=(String)session.getAttribute("text");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        
     Date a = new Date();
        session.setAttribute("text", html+"<br>"+"<h1>Now it is +"+a.getTime()+"</h1>");
        out.print(html+"<br>"+"<h1>Now it is +"+a.getTime()+"</h1>");
        
    }    
    
}
