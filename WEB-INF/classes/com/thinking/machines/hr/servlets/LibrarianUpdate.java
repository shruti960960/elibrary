package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class LibrarianUpdate extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

String name="";
String password="";
String email_address="";
String mobile_no="";
String enroll_no="";
int year;
int sem;
String branch="";
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
name=request.getParameter("name");
password=request.getParameter("password");
email_address=request.getParameter("emailAddress");
mobile_no=request.getParameter("mobileNumber");
enroll_no=request.getParameter("enroll_no");
year=Integer.parseInt(request.getParameter("year"));
sem=Integer.parseInt(request.getParameter("sem"));
branch=request.getParameter("branch");

LibrarianDTO librarian=new LibrarianDTO();
librarian.setName(name);
librarian.setPassword(password);
librarian.setEmailAddress(email_address);
librarian.setMobileNo(mobile_no);
librarian.setEnrollmentNumber(enroll_no);
librarian.setYear(year);
librarian.setSemester(sem);
librarian.setBranch(branch);

LibrarianDAO librarianDAO;
librarianDAO=new LibrarianDAO();
librarianDAO.update(librarian);

pw.println("<!DOCTYPE HTML>");
pw.println("<html>");
pw.println("<head><link rel='stylesheet' type='text/css' href='adminValidate.css'>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace' rel='stylesheet'>");
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
pw.println("<h2>Updated Successfully</h2><br>");
pw.println("<a id='ok' href='/elibrary/librarianInfo'>OK</a>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception exception)
{
System.out.println(exception);}
}}