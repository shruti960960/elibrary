package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class ECBooksDAO 
{
public static List<ECBooksDTO> getAll() throws DAOException
{
List<ECBooksDTO>ECbooks;
ECbooks=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from Electronicsbooks");
ECBooksDTO ECBooksDTO;
String book_name;
String book_id;
String author_name;
String publisher;
while(resultSet.next())
{
book_name=resultSet.getString("book_name").trim();
book_id=resultSet.getString("book_id").trim();
author_name=resultSet.getString("author_name").trim();
publisher=resultSet.getString("publisher").trim();
ECBooksDTO=new ECBooksDTO();
ECBooksDTO.setBookName(book_name);
ECBooksDTO.setBookId(book_id);
ECBooksDTO.setAuthorName(author_name);
ECBooksDTO.setPublisher(publisher);
ECbooks.add(ECBooksDTO);
}
resultSet.close();
statement.close();
connection.close();
return ECbooks;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
