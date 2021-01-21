package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import java.util.*;
public class CSBooksView extends HttpServlet
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
pw.println("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"adminValidate.css\">");
pw.println("<link href=\"https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace\" rel=\"stylesheet\">");
pw.println("</head>");
pw.println("<body>");
pw.println("<div id='menubar'>");
pw.println("<div id='left'></div>");
pw.println("<div id=right>");
pw.println("<ul>");
pw.println("<li><a class='active' href='/elibrary1/index.html'>Home</a></li>");
pw.println("<li><a class='active' href='/elibrary1/contact.html'>Contact</a></li>");
pw.println("<li><a class='active1' href='/elibrary1/disclaimer.html'>Disclaimer</a></li>");
pw.println("<li><a class='active' href='/elibrary1/login.html'>Logout</a></li>");
pw.println("</ul></div>");
pw.println("</div><br>");
pw.println("<div class='container'>");
pw.println("");
pw.println("<div id='left1' style='padding-top:10px;height:78.7vh'>");
pw.println("<img src='admin123.png' style='padding-top:20px'></img><br>");
pw.println("<b><a id='left11' href='/elibrary/adminInfo'>AdminInfo</a></b><br>");
pw.println("<b><a id='left12' href='/elibrary/librarianInfo'>LibrarianInfo</a></b><br>");
pw.println("<b><a id='left13' href='/elibrary/bookInfo.html'>BookInfo</a></b><br>");
pw.println("<b><a id='left14' style='font-family:Arial Rounded MT Bold;text-decoration:none;padding-left:55px;padding-right:55px' href=''>View Request</a><b><br>");
pw.println("<b><a id='left14' style='font-family:Arial Rounded MT Bold;text-decoration:none;padding-left:70px;padding-right:70px' href=''>Add Book</a><b><br>");
pw.println("<b><a id='left14' style='font-family:Arial Rounded MT Bold;text-decoration:none;padding-left:60px;padding-right:60px' href=''>Book Search</a><b><br>");
pw.println("</div>");
pw.println("");
pw.println("<div id='center1'>");
pw.println("<table border='1' style='border:2px solid black;margin-top:10px;margin-left:20px'>");
pw.println("<thead style='background-color:#DA99F5'>");
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
pw.println("<th style='width:150px'>Book Pdf</th>");
pw.println("<th style='width:60px'>Edit</th>");
pw.println("<th style='width:60px'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody class='tbody'>");
CSBooksDTO csBooksDTO;
String book_id;
String book_name;
String author_name;
String publisher;
byte[] book_pdf;
int sno=0;
CSBooksDAO csBooksDAO=new CSBooksDAO();
List<CSBooksDTO>csbs;
csbs=csBooksDAO.getAll();
for(int x=0;x<csbs.size();x++)
{
sno++;
csBooksDTO=csbs.get(x);
book_id=csBooksDTO.getBookId();
book_name=csBooksDTO.getBookName();
author_name=csBooksDTO.getAuthorName();
publisher=csBooksDTO.getPublisher();
book_pdf=csBooksDTO.getBookPdf();
pw.println("<tr>");
pw.println("<td style='text-align:right;'>"+sno+".</td>");
pw.println("<td style='text-align:center'>"+book_id+"</td>");
pw.println("<td style='text-align:right'>"+book_name+"</td>");
pw.println("<td style='text-align:center'>"+author_name+"</td>");
pw.println("<td style='text-align:center'>"+publisher+"</td>");
pw.println("<td style='text-align:center'><a href='"+book_pdf+"'>Book</a></td>");

pw.println("<td style='text-align:center'><a href='/elibrary1/editCSBooks?book_id="+book_id+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/elibrary1/deleteCSBooks?book_id="+book_id+"'>Delete</a></td>");
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