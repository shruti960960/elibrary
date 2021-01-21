package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class EditLibrarian extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
List<LibrarianDTO> Librarians;
LibrarianDAO librarianDAO;
librarianDAO = new LibrarianDAO();
LibrarianDTO librarianDTO;
librarianDTO = new LibrarianDTO();
Librarians=librarianDAO.getAll();

String name;
String password;
String email_address;
String mobile_no;
String enroll_no;
int year;
int sem;
String branch;
enroll_no=request.getParameter("enroll_no");
for(int i=0;i<Librarians.size();i++)
{
librarianDTO=Librarians.get(i);
if(librarianDTO.getEnrollmentNumber().equals(enroll_no))
{
name=librarianDTO.getName();
password=librarianDTO.getPassword();
email_address=librarianDTO.getEmailAddress();
mobile_no=librarianDTO.getMobileNo();
enroll_no=librarianDTO.getEnrollmentNumber();
year=librarianDTO.getYear();
sem=librarianDTO.getSemester();
branch=librarianDTO.getBranch();
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
pw.println("<li><a class='active1' href='/elibrary/index.html'>Home</a></li>");
pw.println("<li><a class='active' href='/elibrary/contact.html'>Contact</a></li>");
pw.println("<li><a class='active1' href='/elibrary/disclaimer.html'>Disclaimer</a></li>");
pw.println("<li><a class='active1' href='/elibrary/login.html'>Logout</a></li>");
pw.println("</ul></div>");
pw.println("</div><br>");
pw.println("<div class='container'>");

pw.println("<div id='left1'>");
pw.println("<img src='admin123.png' style='height:180px'><br><br>");
pw.println("<a id='left11' href='/elibrary/adminInfo'>AdminInfo</a><br><br>");
pw.println("<a id='left12' href='/elibrary/librarianInfo'>LibrarianInfo</a><br><br>");
pw.println("<a id='left13' href='/Book'>BookInfo</a>");
pw.println("</div>");
pw.println("<div id='center' style='font-family:Arial'>"); 
pw.println("<form action='/elibrary/librarianUpdate' method='get'>");
pw.println("<h1 style='font-size:50px;text-align:center'>Librarian(Edit Module)</h1>");
pw.println("<div id='edit'>");

pw.println("<b>Name</b>");
pw.println("<input type='text' value='"+name+"' id='name' name='name' maxlength='35' size='30' style='margin-left:86px'><br><br>");
pw.println("<b>Password</b>");
pw.println("<input type='text' value='"+password+"' id='password' name='password' maxlength='35' size='30' style='margin-left:53px'><br><br>");
pw.println("<b>Email Address</b>");
pw.println("<input type='text' value='"+email_address+"' id='emailaddress' name='emailAddress' maxlength='35' size='30' style='margin-left:15px'><br><br>");
pw.println("<b>Mobile Number</b>");
pw.println("<input type='text' value='"+mobile_no+"' id='mobileNumber' name='mobileNumber' maxlength='35' size='30' style='margin-left:10px'><br><br>");
pw.println("<b>Enrollment Number</b>");
pw.println("<input type='text' value='"+enroll_no+"' id='enroll_no' name='enroll_no' maxlength='35' size='30' style='margin-left:15px'><br><br>");
pw.println("<b>Year</b>");
pw.println("<input type='text' value='"+year+"' id='year' name='year' maxlength='35' size='30' style='margin-left:73px'><br><br>");
pw.println("<b>Semester</b>");
pw.println("<input type='text' value='"+sem+"' id='sem' name='sem' maxlength='35' size='30' style='margin-left:73px'><br><br>");
pw.println("<b>Branch</b>");
pw.println("<input type='text' value='"+branch+"' id='branch' name='branch' maxlength='35' size='30' style='margin-left:73px'><br><br><br>");
pw.println("<button type='submit' style='font-size:20px;border:2px solid purple;border-radius:8px;background-color:purple;color:white;transition-duration: 0.4s'>Update</button>");
pw.println("<a href='/elibrary/librarianInfo' style='font-size:22px;border:2px solid purple;border-radius:8px;background-color:purple;color:white;text-decoration:none;padding:1px'>Cancel</a>");
pw.println("</div>");
pw.println("</form>");
pw.println("</div>");

pw.println("</div>");


pw.println("</body>");
pw.println("</html>");
}
}
}
catch(Exception e){
System.out.println(e);

}
}}