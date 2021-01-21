package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class CivilBooksDAO 
{
public static List<CivilBooksDTO> getAll() throws DAOException
{
List<CivilBooksDTO>civilbooks;
civilbooks=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from civilbooks");
CivilBooksDTO CivilBooksDTO;
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
CivilBooksDTO=new CivilBooksDTO();
CivilBooksDTO.setBookName(book_name);
CivilBooksDTO.setBookId(book_id);
CivilBooksDTO.setAuthorName(author_name);
CivilBooksDTO.setPublisher(publisher);
civilbooks.add(CivilBooksDTO);
}
resultSet.close();
statement.close();
connection.close();
return civilbooks;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
