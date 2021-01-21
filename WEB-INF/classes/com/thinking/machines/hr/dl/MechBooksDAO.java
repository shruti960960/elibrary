package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class MechBooksDAO 
{
public static List<MechBooksDTO> getAll() throws DAOException
{
List<MechBooksDTO>mechbooks;
mechbooks=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from mechbooks");
MechBooksDTO MechBooksDTO;
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
MechBooksDTO=new MechBooksDTO();
MechBooksDTO.setBookName(book_name);
MechBooksDTO.setBookId(book_id);
MechBooksDTO.setAuthorName(author_name);
MechBooksDTO.setPublisher(publisher);
mechbooks.add(MechBooksDTO);
}
resultSet.close();
statement.close();
connection.close();
return mechbooks;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
