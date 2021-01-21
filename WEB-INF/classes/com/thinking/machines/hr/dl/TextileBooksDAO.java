package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class TextileBooksDAO 
{
public static List<TextileBooksDTO> getAll() throws DAOException
{
List<TextileBooksDTO>textileBooks;
textileBooks=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from textilebooks");
TextileBooksDTO TextileBooksDTO;
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
TextileBooksDTO=new TextileBooksDTO();
TextileBooksDTO.setBookName(book_name);
TextileBooksDTO.setBookId(book_id);
TextileBooksDTO.setAuthorName(author_name);
TextileBooksDTO.setPublisher(publisher);
textileBooks.add(TextileBooksDTO);
}
resultSet.close();
statement.close();
connection.close();
return textileBooks;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
