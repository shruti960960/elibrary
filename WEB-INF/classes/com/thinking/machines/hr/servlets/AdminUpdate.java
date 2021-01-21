package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class AdminUpdate extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw;
String name="";
String password="";
String email_address="";
String mobile_no="";
String home_address="";
String admin_id="";
int sno=1;
try
{
pw=response.getWriter();
response.setContentType("text/html");
name=request.getParameter("name");
password=request.getParameter("password");
email_address=request.getParameter("emailAddress");
mobile_no=request.getParameter("mobileNumber");
home_address=request.getParameter("homeAddress");
admin_id=request.getParameter("adminId");


AdminDTO admin=new AdminDTO();
admin.setName(name);
admin.setPassword(password);
admin.setEmailAddress(email_address);
admin.setMobileNo(mobile_no);
admin.setHomeAddress(home_address);
admin.setAdminId(admin_id);

AdminDAO adminDAO;
adminDAO=new AdminDAO();
adminDAO.update(admin);

pw.println("<!DOCTYPE HTML>");
pw.println("<html>");
pw.println("<head><link rel='stylesheet' type='text/css' href='adminValidate.css'>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace' rel='stylesheet'>");
pw.println("<script>");
pw.println("function Updated()");
pw.println("{");
pw.println("document.getElementById('Updated').submit();");
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
pw.println("<a id='left13' href='/elibrary/bookInfo.html'>BookInfo</a>");
pw.println("</div>");

pw.println("<div id='center'>");
pw.println("<h2>Updated Successfully</h2>");
pw.println("<button id='ok' type='button' onClick='Updated()'>OK</button>");
pw.println("<form id='Updated' action='/elibrary/adminInfo'>");
pw.println("</form>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception e)
{
System.out.println(e);}
}}