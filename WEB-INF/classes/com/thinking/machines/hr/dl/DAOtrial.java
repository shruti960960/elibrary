package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;

public class DAOtrial
{
public static List <DTOtrial> getAll() throws DAOException
{
List<DTOtrial> trials;
trials=new LinkedList<>();
try
{
Connection connection = DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from books");
DTOtrial dtotrial = new DTOtrial();
while(resultSet.next())
{
String bookname=resultSet.getString("book_name");
byte[] pdf=resultSet.getBytes("book_pdf");

dtotrial.setBookName(bookname);
dtotrial.setBookPdf(pdf);
trials.add(dtotrial);
}
resultSet.close();
statement.close();
connection.close();
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return trials;
}}