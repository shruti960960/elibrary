package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class ArchitectureBooksDAO 
{
public static List<ArchitectureBooksDTO> getAll() throws DAOException
{
List<ArchitectureBooksDTO>architectureBooks;
architectureBooks=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from architecturebooks");
ArchitectureBooksDTO ArchitectureBooksDTO;
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
ArchitectureBooksDTO=new ArchitectureBooksDTO();
ArchitectureBooksDTO.setBookName(book_name);
ArchitectureBooksDTO.setBookId(book_id);
ArchitectureBooksDTO.setAuthorName(author_name);
ArchitectureBooksDTO.setPublisher(publisher);
architectureBooks.add(ArchitectureBooksDTO);
}
resultSet.close();
statement.close();
connection.close();
return architectureBooks;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
