package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class LibrarianValidate extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
String name=request.getParameter("lname");
String password=request.getParameter("lpassword");
String enrollmentNumber="";
boolean found;
LibrarianDAO librarianDAO;
librarianDAO = new LibrarianDAO();
LibrarianDTO librarianDTO;
librarianDTO = new LibrarianDTO();
librarianDTO.setName(name);
librarianDTO.setPassword(password);
found=librarianDAO.validate(librarianDTO);
List<LibrarianDTO> librarians;
librarians=librarianDAO.getAll();
if(found==true)
{
pw.println("<!DOCTYPE HTML>");
pw.println("<html>");
pw.println("<head>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace' rel='stylesheet'>");
pw.println("<link rel='stylesheet' type='text/css' href='LibrarianEnter.css'>");
pw.println("<div  id='menubar'>");
pw.println("<div id='left1'></div>");
pw.println("<div id='right1'>");
pw.println("<ul>");
pw.println("<li><a class='active' href='/elibrary/index.html'>Home</a></li>");
pw.println("<li><a class='active' href='/elibrary/contact.html'>Contact</a></li>");
pw.println("<li><a class='active1' href='/elibrary/disclaimer.html'>Disclaimer</a></li>");
pw.println("<li><a class='active' href='/elibrary/login.html'>Logout</a></li>");
pw.println("</ul></div></div>");
pw.println("</head>");
pw.println("<body>");
pw.println("<div id='container'>");
pw.println("<div id='left'>");
pw.println("<img src='img2.png'><br><br>");
pw.println("<a id='left11' href='/elibrary/librarianCompleteInfo?name="+name+"&password="+password+"'>Librarian Info</a><br><br>");
pw.println("<a id='left12' href='/elibrary/categorie.html'>Categories</a><br><br>");
pw.println("<a id='left13' href='#'>Pending Request</a>");

pw.println("</div>");
pw.println("<div id='right'>");
pw.println("<h1 id='heading'>Librarian Section</h1>");
pw.println("<div id='intro'>");
pw.println("<h2>Librarian Identity</h2>");
String mobileNumber;
String emailAddress;

int year;
int sem;
String branch;
for(int i=0;i<librarians.size();i++)
{
librarianDTO=librarians.get(i);

String lname=librarianDTO.getName();
String lpassword=librarianDTO.getPassword();
if(name.equals(lname)&&password.equals(lpassword))
{
mobileNumber=librarianDTO.getMobileNo();
emailAddress=librarianDTO.getEmailAddress();
enrollmentNumber=librarianDTO.getEnrollmentNumber();

year=librarianDTO.getYear();
sem=librarianDTO.getSemester();
branch=librarianDTO.getBranch();

pw.println("Name : "+name+"<br>");
pw.println("Enrollment Id : "+enrollmentNumber+"<br>");
pw.println("</div>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}}}
else
{
pw.println("<!DOCTYPE HTML>");
pw.println("<html lan='en'>");
pw.println("<head>");
pw.println("<title>Librarian Exists</title>");
pw.println("<link rel='stylesheet' type='text/css' href='/elibrary/invalidlogin.css'>");
pw.println("<link href=\"https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace\" rel=\"stylesheet\">");
pw.println("</head>");
pw.println("<body>");
pw.println("<div id='container'>");
pw.println("<div id='left1'>");
pw.println("<h1>Invalid Login Details !! Please try again</h1>");
pw.println("");
pw.println("<form action='/elibrary/AdminLogin.html'>");
pw.println("<button id='button' type='submit'>Go Back</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<div id='right'>");
pw.println("<img src='Oops.jpg'>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}