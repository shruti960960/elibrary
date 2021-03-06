package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class librarianInfo extends HttpServlet
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
int sno=0;

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
pw.println("<a id='left13' href='/elibrary/bookInfo.html'>BookInfo</a>");
pw.println("</div>");

pw.println("<div id='center1'>");
pw.println("<table border='1' style='border:2px solid black;margin-top:8px;margin-left:60px'>");
pw.println("<thead style='background-color:#DA99F5'>");
pw.println("<tr>");


pw.println("</th>");
pw.println("</tr>");
pw.println("<tr style='font-size:20px'>");
pw.println("<th style='width:50px'>S.No</th>");
pw.println("<th style='width:100px'>Name</th>");
pw.println("<th style='width:100px'>Password</th>");
pw.println("<th style='width:150px'>Email Address</th>");
pw.println("<th style='width:150px'>Mobile Number</th>");
pw.println("<th style='widht:150px'>Enrollment number</th>");
pw.println("<th style='width:80px'>year</th>");
pw.println("<th style='width:80px'>sem</th>");
pw.println("<th style='width:80px'>branch</th>");
pw.println("<th style='width:80px'>Edit</th>");
pw.println("<th style='width:80px'>Delete</th>");

pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody class='tbody'>");

for(int i=0;i<Librarians.size();i++){
sno++;
librarianDTO=Librarians.get(i);
name=librarianDTO.getName();
password=librarianDTO.getPassword();
email_address=librarianDTO.getEmailAddress();
mobile_no=librarianDTO.getMobileNo();
enroll_no=librarianDTO.getEnrollmentNumber();
year=librarianDTO.getYear();
sem=librarianDTO.getSemester();
branch=librarianDTO.getBranch();

pw.println("<tr>");
pw.println("<td style='text-align:right;'>"+sno+"</td>");
pw.println("<td style='text-align:right;'>"+name+"</td>");
pw.println("<td style='text-align:center'>"+password+"</td>");
pw.println("<td style='text-align:right'>"+email_address+"</td>");
pw.println("<td style='text-align:center'>"+mobile_no+"</td>");
pw.println("<td style='text-align:center'>"+enroll_no+"</td>");
pw.println("<td style='text-align:center'>"+year+"</td>");
pw.println("<td style='text-align:center'>"+sem+"</td>");
pw.println("<td style='text-align:center'>"+branch+"</td>");
pw.println("<td style='text-align:center'><a href='/elibrary/editLibrarian?enroll_no="+enroll_no+"'>Edit</a>");
pw.println("<td style='text-align:center'><a href='/elibrary/confirmDeleteLibrarian?enroll_no="+enroll_no+"'>Delete</a>");

pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
pw.println("}");
}
catch(Exception exception)
{
System.out.println(exception);
}

}
} 