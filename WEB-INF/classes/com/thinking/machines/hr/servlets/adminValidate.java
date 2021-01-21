package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class adminValidate extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
String name=request.getParameter("aname");
String password=request.getParameter("apassword");
boolean found;
AdminDAO adminDAO;
adminDAO = new AdminDAO();
AdminDTO adminDTO;
adminDTO = new AdminDTO();
adminDTO.setName(name);
adminDTO.setPassword(password);
found=adminDAO.validate(adminDTO);
List<AdminDTO> admins;
admins=adminDAO.getAll();
if(found==true)
{
pw.println("<!DOCTYPE HTML>");
pw.println("<html lan='en'>");
pw.println("<head>");
pw.println("<title>Admin information</title>");

pw.println("<link rel='stylesheet' type='text/css' href='adminValidate.css'>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace' rel='stylesheet'>");
pw.println("</head>");
pw.println("<body>");
pw.println("<form method='post' action='/elibrary/adminInfo'  onSubmit='return adminValidate(this)'>");


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

pw.println("<h1>WELCOME</h1>");

String mobileNumber;
String emailAddress;
String homeAddress;
adminDTO=admins.get(0);
name=adminDTO.getName();
password=adminDTO.getPassword();
mobileNumber=adminDTO.getMobileNo();
emailAddress=adminDTO.getEmailAddress();
homeAddress=adminDTO.getHomeAddress();


}
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