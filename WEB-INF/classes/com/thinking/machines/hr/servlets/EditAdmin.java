package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class EditAdmin extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/html");
List<AdminDTO> Admins;
AdminDAO adminDAO;
adminDAO = new AdminDAO();
AdminDTO adminDTO;
adminDTO = new AdminDTO();
Admins=adminDAO.getAll();
String name;
String password;
String email_address;
String mobile_no;
String home_address;
String admin_id;
for(int i=0;i<Admins.size();i++)
{
adminDTO=Admins.get(i);
name=adminDTO.getName();
password=adminDTO.getPassword();
email_address=adminDTO.getEmailAddress();
mobile_no=adminDTO.getMobileNo();
home_address=adminDTO.getHomeAddress();
admin_id=adminDTO.getAdminId();
pw.println("<!DOCTYPE HTML>");
pw.println("<html>");
pw.println("<head><link rel='stylesheet' type='text/css' href='adminValidate.css'>");
pw.println("<link href='https://fonts.googleapis.com/css?family=Bungee|Bungee+Shade|Covered+By+Your+Grace' rel='stylesheet'>");
pw.println("<script>");
pw.println("function cancelUpdate()");
pw.println("{");
pw.println("document.getElementById('cancelUpdate').submit();");

pw.println("}");

pw.println("</script>");

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
pw.println("<a id='left11' href='/elibrary/adminValidate'>AdminInfo</a><br><br>");
pw.println("<a id='left12' href='/LibrarianValidate'>LibrarianInfo</a><br><br>");
pw.println("<a id='left13' href='/Book'>BookInfo</a>");
pw.println("</div>");
pw.println("<div id='center' style='font-family:Arial'>"); 
pw.println("<form action='/elibrary/adminUpdate' method='get'>");
pw.println("<h1 style='font-size:80px;text-align:center'>Admin(Edit Module)</h1>");
pw.println("<div id='edit'>");
pw.println("<b>Name</b>");
pw.println("<input type='text' value='"+name+"' id='name' name='name' maxlength='35' size='30' style='margin-left:86px'><br><br>");
pw.println("<b>Password</b>");
pw.println("<input type='text' value='"+password+"' id='password' name='password' maxlength='35' size='30' style='margin-left:53px'><br><br>");
pw.println("<b>Email Address</b>");
pw.println("<input type='text' value='"+email_address+"' id='text' name='emailAddress' maxlength='35' size='30' style='margin-left:15px'><br><br>");
pw.println("<b>Mobile Number</b>");
pw.println("<input type='text' value='"+mobile_no+"' id='mobileNumber' name='mobileNumber' maxlength='35' size='30' style='margin-left:10px'><br><br>");
pw.println("<b>Home Address</b>");
pw.println("<input type='text' value='"+home_address+"' id='homeAddress' name='homeAddress' maxlength='35' size='30' style='margin-left:15px'><br><br>");
pw.println("<b>Admin Id</b>");
pw.println("<input type='text' value='"+admin_id+"' id='homeAddress' name='adminId' maxlength='35' size='30' style='margin-left:73px'><br><br><br>");
pw.println("<button type='submit' style='font-size:20px;border:2px solid purple;border-radius:8px;background-color:purple;color:white;transition-duration: 0.4s'>Update</button>");
pw.println("<button type='Button' style='font-size:20px;border:2px solid purple;border-radius:8px;background-color:purple;color:white' onClick='cancelUpdate()'>Cancel</button>");
pw.println("</div>");
pw.println("</form>");
pw.println("</div>");
pw.println("<form id='cancelUpdate' action='/elibrary/adminInfo'>");
pw.println("</form>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");

}
}
catch(Exception e){
System.out.println(e);

}
}}