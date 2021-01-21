package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/fileUploadPdf")
@MultipartConfig

public class FileUploadPdf extends HttpServlet {
 
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        
PrintWriter pw=null;
pw=response.getWriter();
response.setContentType("text/html"); 
String bookId = request.getParameter("bid");
String bookName = request.getParameter("bname");
String bookAuthor = request.getParameter("bauthor");
String bookPublisher = request.getParameter("bpublisher");
Part filePart = request.getPart("bfile");


InputStream pdfFileBytes = null;
try {
 
if (!filePart.getContentType().equals("application/pdf"))
{
pw.println("<br/> Invalid File");
return;
}
 
else if (filePart.getSize()>2048576 ) { //2mb
{
pw.println("<br/> File size too big");
return;
}
}

pdfFileBytes = filePart.getInputStream();  // to get the body of the request as binary data
 
byte[] bytes = new byte[pdfFileBytes.available()];
String filepdf;
pdfFileBytes.read(bytes);  //Storing the binary data in bytes array.
filepdf = new String(bytes);

PdfDTO pdfDto = new PdfDTO();
pdfDto.setBookId(bookId);
pdfDto.setBookName(bookName);
pdfDto.setBookAuthor(bookAuthor);
pdfDto.setBookPublisher(bookPublisher);
pdfDto.setBookPdf(filepdf);

PdfDAO pdfDao = new PdfDAO();
pdfDao.add(pdfDto);

pw.println("<center><h1>SuccessFully Stored</h1></center>");

}
catch(Exception exception)
{
System.out.println(exception); //remove after testing
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
{
doGet(request,response);
}}