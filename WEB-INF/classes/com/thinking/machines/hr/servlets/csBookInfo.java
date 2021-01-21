package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class csBookInfo extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
List<CSBooksDTO> cs;
CSBooksDAO csbooksDAO;
csbooksDAO = new CSBooksDAO();
CSBooksDTO csbooksDTO;
csbooksDTO = new CSBooksDTO();
cs=csbooksDAO.getAll();
String name;
String book_name;
String book_id;
String author_name;
String enroll_no;
Date issue_date;
Date due_data;

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
pw.println("<a id='left11' href='/elibrary/librarianInfo1'>Librarian Info</a><br><br>");
pw.println("<a id='left12' href='/elibrary/categorie.html'>Categories</a><br><br>");
pw.println("<a id='left13' href='#'>Pending Request</a>");
pw.println("</div>");
pw.println("<div id='right'>");

for(int i=0;i<cs.size();i++){
book_name=csbooksDTO.getBookName();
System.out.println(book_name);
book_id=csbooksDTO.getBookId();
author_name=csbooksDTO.getAuthorName();

pw.println("<div id='issue'>");
pw.println("<form action='#' method='post'>");
pw.println("<h2>Issue Form</h2>");
pw.println("Book Name      : <input id='i1' type='text' id='bname' name='bname' value='name'><br>");
pw.println("Book Id        : <input id='i2' type='text' id='bid' name='bid'><br>");
pw.println("Book Author    : <input id='i3' type='text' id='bauthor' name='bauthor'><br>");
pw.println("Librarian Name : <input id='i4' type='text' id='lname' name='lname'><br>");
pw.println("Enrollment Id  : <input id='i5' type='text' id='enroll_no' name='enroll_no'><br>");
pw.println("Issue Date     : <input id='i6' type='text' id='issuedate' name='issuedate'><br>");
pw.println("Due Date       : <input id='i7' type='text' id='duedate' name='duedate'><br>");
pw.println("<button id='issued' type='submit'>Submit</button>");
pw.println("</form");

pw.println("</div>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
}}
catch(Exception exception)
{
System.out.println(exception);
}

}
} 