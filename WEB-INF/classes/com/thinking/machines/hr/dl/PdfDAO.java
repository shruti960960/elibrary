package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;

public class PdfDAO 
{


public void add(PdfDTO pdf) throws DAOException
{
try{

Connection connection = DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("Select * from csbooks where book_id=?");
preparedStatement.setString(1,pdf.getBookId());
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{

resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Book with this BookID: "+pdf.getBookId()+"exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into csbooks(book_id,book_name,author_name,publisher,book_pdf)values(?,?,?,?,?)");

preparedStatement.setString(1,pdf.getBookId());
preparedStatement.setString(2,pdf.getBookName());
preparedStatement.setString(3,pdf.getBookAuthor());
preparedStatement.setString(4,pdf.getBookPublisher());
preparedStatement.setString(5,pdf.getBookPdf());


preparedStatement.executeUpdate();
resultSet.close();
connection.close();

}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
}