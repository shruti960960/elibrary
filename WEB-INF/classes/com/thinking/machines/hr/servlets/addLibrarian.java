package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class addLibrarian extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
String name="";
String password="";
String email_address="";
String mobile_no="";
String enrollment_no="";
int year=0;
int sem=0;
String branch="";
LibrarianDTO librarian=new LibrarianDTO();
try{
pw=response.getWriter();
name=request.getParameter("name");
password=request.getParameter("password");
email_address=request.getParameter("email");
mobile_no=request.getParameter("mobileno");
enrollment_no=request.getParameter("enroll");
year=Integer.parseInt(request.getParameter("year"));
sem=Integer.parseInt(request.getParameter("sem"));
branch=request.getParameter("branch");


librarian.setName(name);
librarian.setPassword(password);
librarian.setEmailAddress(email_address);
librarian.setMobileNo(mobile_no);
librarian.setEnrollmentNumber(enrollment_no);
librarian.setYear(year);
librarian.setSemester(sem);
librarian.setBranch(branch);

LibrarianDAO librarianDAO;
librarianDAO=new LibrarianDAO();
librarianDAO.add(librarian);

pw.println("<!DOCTYPE HTML>");
pw.println("<html lan='en'>");
pw.println("<head>");
pw.println("<title>Added Successfully</title>");
pw.println("<link rel='stylesheet' type='text/css' href='addedSuccessfully.css'>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covere+By+Your+Grace' rel='stylesheet'>");
pw.println("</head>");
pw.println("<body>");
pw.println("<div id='container'>");
pw.println("<div id='left'>");
pw.println("<h1>You Are Successfully Added</h1>");
pw.println("<h4>Now you are librarian member of this elibrary.</h4>");

pw.println("<form action='LibrarianLogin.html'>");
pw.println("<button id='button' type='submit'>Login</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}
catch(DAOException daoException)
{

pw.println("<!DOCTYPE HTML>");
pw.println("<html lan='en'>");
pw.println("<head>");
pw.println("<title>Exists</title>");
pw.println("<link rel='stylesheet' type='text/css' href='addedSuccessfully.css'>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covere+By+Your+Grace' rel='stylesheet'>");
pw.println("</head>");
pw.println("<body>");
pw.println("<div id='container'>");
pw.println("<div id='left'>");
pw.println("Librarian with the enrollment :");
pw.println(librarian.getEnrollmentNumber()+"<br>");
pw.println("already exists<br><br>");
pw.println("<form action='LibrarianLogin.html'>");
pw.println("<button id='button' type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception exception)
{
System.out.println(exception); //remove after testing
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}}