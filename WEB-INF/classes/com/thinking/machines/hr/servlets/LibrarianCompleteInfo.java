package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
 
public class LibrarianCompleteInfo extends HttpServlet 
{
public void doGet(HttpServletRequest request,HttpServletResponse response) 
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
String name=request.getParameter("name");
String password=request.getParameter("password");
String enrollmentNumber="";
String mobileNumber;
String emailAddress;
int year;
int sem;
String branch;

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
pw.println("<li><a class='active' href='/elibrary/contact1.html'>Contact</a></li>");
pw.println("<li><a class='active1' href='/elibrary/disclaimer1.html'>Disclaimer</a></li>");
pw.println("<li><a class='active' href='/elibrary/login.html'>Logout</a></li>");
pw.println("</ul></div></div>");
pw.println("</head>");
pw.println("<body>");
pw.println("<div id='container'>");
pw.println("<div id='left'>");
pw.println("<img src='img2.png'><br><br>");
pw.println("<b id='left11' style='background-color:#006E8D;color:white'>Librarian Info</b><br><br>");
pw.println("<a id='left12' href='/elibrary/categorie.html'>Categories</a><br><br>");
pw.println("<a id='left13' href='#'>Pending Request</a>");
pw.println("</div>");
pw.println("<div id='right'>");
pw.println("<h1 id='heading'>Librarian Information</h1>");
pw.println("<div id='info'>");
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
pw.println("Password : "+password+"<br>");
pw.println("Mobile Number : "+mobileNumber+"<br>");
pw.println("Email Address : "+emailAddress+"<br>");
pw.println("Enrollment Id : "+enrollmentNumber+"<br>");
pw.println("Year : "+year+"<br>");
pw.println("Semester: "+sem+"<br>");
pw.println("Branch : "+branch+"<br>");
pw.println("</div>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}}}
}

catch(Exception e)
{
System.out.println(e);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}