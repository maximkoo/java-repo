package ru.maximkoo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author max
 */
public class ArrayHolder extends HttpServlet{
    private String [] a={"a","b","c"};
    
    public String[] getA(){
        return a;
    };  
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        
        JSONArray jsonArray = new JSONArray();

        for (String i:a){
            jsonArray.add(i);
        }
        //jsonArray.addAll(Arrays.asList(a));

        out.print(jsonArray)  ;
    };
}
