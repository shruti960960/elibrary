package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class CSBooksDAO 
{
public static List<CSBooksDTO> getAll() throws DAOException
{
List<CSBooksDTO>csbs;
csbs=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from csbooks");
CSBooksDTO CSBooksDTO;
String book_name;
String book_id;
String author_name;
String publisher;
byte[] bookpdf;

while(resultSet.next())
{
book_name=resultSet.getString("book_name").trim();
book_id=resultSet.getString("book_id").trim();
author_name=resultSet.getString("author_name").trim();
publisher=resultSet.getString("publisher").trim();
bookpdf=resultSet.getBytes("book_pdf");
CSBooksDTO=new CSBooksDTO();
CSBooksDTO.setBookName(book_name);
CSBooksDTO.setBookId(book_id);
CSBooksDTO.setAuthorName(author_name);
CSBooksDTO.setPublisher(publisher);
CSBooksDTO.setBookPdf(bookpdf);
csbs.add(CSBooksDTO);
}
resultSet.close();
statement.close();
connection.close();
return csbs;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
