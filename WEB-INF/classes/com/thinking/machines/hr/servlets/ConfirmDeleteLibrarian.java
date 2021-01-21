package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class ConfirmDeleteLibrarian extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String enroll_no;
enroll_no=request.getParameter("enroll_no");
LibrarianDAO librarianDAO=new LibrarianDAO();

LibrarianDTO librarian=librarianDAO.getByEnroll(enroll_no);
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
pw.println("<!DOCTYPE HTML>");
pw.println("<html>");
pw.println("<head><link rel='stylesheet' type='text/css' href='adminValidate.css'>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace' rel='stylesheet'>");
pw.println("<script>");
pw.println("function cancelDeletion()");
pw.println("{");
pw.println("document.getElementById('cancelDeletionForm').submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<div id='menubar'>");
pw.println("<div id='left'></div>");
pw.println("<div id=right>");
pw.println("<ul>");
pw.println("<li><a class='active' href='/elibrary/index.html'>Home</a></li>");
pw.println("<li><a class='active' href='/elibrary/contact.html'>Contact</a></li>");
pw.println("<li><a class='active1' href='/elibrary/disclaimer.html'>Disclaimer</a></li>");
pw.println("<li><a class='active' href='/elibrary/login.html'>Logout</a></li>");
pw.println("</ul></div>");
pw.println("</div><br>");
pw.println("<div class='container'>");

pw.println("<div id='left1'>");
pw.println("<img src='admin123.png'><br>");
pw.println("<a id='left11' href='/elibrary/adminInfo'>AdminInfo</a><br><br>");
pw.println("<a id='left12' href='/elibrary/librarianInfo'>LibrarianInfo</a><br><br>");
pw.println("<a id='left13' href='/Book'>BookInfo</a>");
pw.println("</div>");

pw.println("<div id='center3'");
pw.println("<h2>Librarian(Delete Module)</h2>");
pw.println("<form method='post' action='/elibrary/deleteLibrarian'>");
pw.println("<input type='hidden' id='enroll_no' name='enrollment_no' value='"+enroll_no+"'>");
pw.println("Librarian : ");
pw.println("<b>"+librarian.getEnrollmentNumber()+"</b><br><br>");
pw.println("Are you sure you want to delete this librarian? <br><br>");
pw.println("<button type='submit'>Yes</button>");
pw.println("<button type='Button' onClick='cancelDeletion()'>No</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception exception)
{
System.out.println(exception.getMessage());
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

}