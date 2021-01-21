package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;
public class NovelDAO 
{
public static List<NovelDTO> getAll() throws DAOException
{
List<NovelDTO>novels;
novels=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from novels");
NovelDTO NovelDTO;
String novel_name;
String novel_id;
String author_name;
String publisher;
while(resultSet.next())
{
novel_name=resultSet.getString("book_name").trim();
novel_id=resultSet.getString("book_id").trim();
author_name=resultSet.getString("author_name").trim();
publisher=resultSet.getString("publisher").trim();
NovelDTO=new NovelDTO();
NovelDTO.setBookName(novel_name);
NovelDTO.setBookId(novel_id);
NovelDTO.setAuthorName(author_name);
NovelDTO.setPublisher(publisher);
novels.add(NovelDTO);
}
resultSet.close();
statement.close();
connection.close();
return novels;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}
}
