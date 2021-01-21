package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import java.util.*;
public class LibTextileBooksView extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
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
pw.println("<a id='left11' href='/elibrary/librarianCompleteInfo'>Librarian Info</a><br><br>");
pw.println("<a id='left12' href='/elibrary/categorie.html'>Categories</a><br><br>");
pw.println("<a id='left13' href='#'>Pending Request</a>");
pw.println("</div>");
pw.println("<div id='right'>");

pw.println("<table border='1' style='border:2px solid black;margin-top:10px;margin-left:20px'>");
pw.println("<thead style='background-color:#43A1BA'>");
pw.println("<tr>");
//pw.println("<th colspan='11' style='text-align:right;border:2px solid black;background-color:#DDA0DD'>");

pw.println("</th>");
pw.println("</tr>");
pw.println("<tr style='font-size:20px'>");
pw.println("<th style='width:60px'>S.No</th>");
pw.println("<th style='width:80px'>Book_Id</th>");
pw.println("<th style='width:150px'>Book_Name</th>");
pw.println("<th style='width:80px'>Author_Name</th>");
pw.println("<th style='width:150px'>Publisher</th>");
pw.println("<th style='width:60px'>Edit</th>");
pw.println("<th style='width:60px'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody class='tbody'>");
TextileBooksDTO textileBooksDTO;
String book_id;
String book_name;
String author_name;
String publisher;
int sno=0;
TextileBooksDAO textileBooksDAO=new TextileBooksDAO();
List<TextileBooksDTO>textilebooks;
textilebooks=textileBooksDAO.getAll();
for(int x=0;x<textilebooks.size();x++)
{
sno++;
textileBooksDTO=textilebooks.get(x);
book_id=textileBooksDTO.getBookId();
book_name=textileBooksDTO.getBookName();
author_name=textileBooksDTO.getAuthorName();
publisher=textileBooksDTO.getPublisher();
pw.println("<tr>");
pw.println("<td style='text-align:right;'>"+sno+".</td>");
pw.println("<td style='text-align:center'>"+book_id+"</td>");
pw.println("<td style='text-align:right'>"+book_name+"</td>");
pw.println("<td style='text-align:center'>"+author_name+"</td>");
pw.println("<td style='text-align:center'>"+publisher+"</td>");
pw.println("<td style='text-align:center'><a href='/elibrary1/editTextileBooks?book_id="+book_id+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/elibrary1/deleteTextileBooks?book_id="+book_id+"'>Delete</a></td>");
pw.println("</tr>");
}

pw.println("");
pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("");
pw.println("");
pw.println("</div>");
pw.println("");
pw.println("");
pw.println("</body>");
pw.println("</html>");
}catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}