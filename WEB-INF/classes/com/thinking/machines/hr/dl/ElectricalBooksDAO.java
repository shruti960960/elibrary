package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class ElectricalBooksDAO 
{
public static List<ElectricalBooksDTO> getAll() throws DAOException
{
List<ElectricalBooksDTO>mechbooks;
mechbooks=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from electicalbooks");
ElectricalBooksDTO ElectricalBooksDTO;
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
ElectricalBooksDTO=new ElectricalBooksDTO();
ElectricalBooksDTO.setBookName(book_name);
ElectricalBooksDTO.setBookId(book_id);
ElectricalBooksDTO.setAuthorName(author_name);
ElectricalBooksDTO.setPublisher(publisher);
mechbooks.add(ElectricalBooksDTO);
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
