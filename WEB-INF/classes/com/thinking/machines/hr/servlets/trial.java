package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import java.util.*;
public class trial extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
DTOtrial dtotrial;
String book_name;
byte[] book_pdf;
DAOtrial daotrial=new DAOtrial();
List<DTOtrial> trials;
trials=daotrial.getAll();
System.out.println("hello");
for(int x=0;x<trials.size();x++)
{
dtotrial=trials.get(x);
book_name=dtotrial.getBookName();
book_pdf=dtotrial.getBookPdf();
System.out.println(book_name);
System.out.println(book_pdf);
}
}
catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}