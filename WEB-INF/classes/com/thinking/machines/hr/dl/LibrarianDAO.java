package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;

public class LibrarianDAO 
{
public static List<LibrarianDTO> getAll() throws DAOException
{
List<LibrarianDTO> Librarians;
Librarians=new LinkedList<>();
try
{
Connection connection = DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from librarianinfo order by name");
LibrarianDTO LibrarianDTO;
String name;
String password;
String email_address;
String mobile_no;
String enrollment_no;
int year;
int sem;
String branch;
while(resultSet.next ())
{
name=resultSet.getString("name").trim();
password=resultSet.getString("password").trim();
email_address=resultSet.getString("email_address").trim();
enrollment_no=resultSet.getString("enrollment_no").trim();
year=resultSet.getInt("year");
sem=resultSet.getInt("sem");
branch=resultSet.getString("branch").trim();
mobile_no=resultSet.getString("mobile_no");
LibrarianDTO=new LibrarianDTO();
LibrarianDTO.setName(name);
LibrarianDTO.setPassword(password);
LibrarianDTO.setEmailAddress(email_address);
LibrarianDTO.setMobileNo(mobile_no);
LibrarianDTO.setEnrollmentNumber(enrollment_no);
LibrarianDTO.setYear(year);
LibrarianDTO.setSemester(sem);
LibrarianDTO.setBranch(branch);
Librarians.add(LibrarianDTO);
}
resultSet.close();
statement.close();
connection.close();
}
catch(Exception exception)
{
System.out.println(exception.getMessage());
}
return Librarians;
}




public void add(LibrarianDTO librarian) throws DAOException
{
try{

Connection connection = DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("Select * from librarianinfo where enrollment_no=?");
preparedStatement.setString(1,librarian.getEnrollmentNumber());
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{

resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Student with this enrollment number: "+librarian.getEnrollmentNumber()+"exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into librarianinfo(name,password,email_address,mobile_no,enrollment_no,year,sem,branch)values(?,?,?,?,?,?,?,?)");

preparedStatement.setString(1,librarian.getName());
preparedStatement.setString(2,librarian.getPassword());
preparedStatement.setString(3,librarian.getEmailAddress());
preparedStatement.setString(4,librarian.getMobileNo());
preparedStatement.setString(5,librarian.getEnrollmentNumber());
preparedStatement.setInt(6,librarian.getYear());
preparedStatement.setInt(7,librarian.getSemester());
preparedStatement.setString(8,librarian.getBranch());

preparedStatement.executeUpdate();
resultSet.close();
connection.close();

}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());//remove after testing
}
}

public void update(LibrarianDTO librarian) throws DAOException
{
try{

String name=librarian.getName();
String password=librarian.getPassword();
String email_address=librarian.getEmailAddress();
String mobile_no=librarian.getMobileNo();
String enrollment_no=librarian.getEnrollmentNumber();
int year=librarian.getYear();
int sem=librarian.getSemester();
String branch=librarian.getBranch();

Connection connection=DAOConnection.getConnection();
PreparedStatement prepareStatement;
prepareStatement=connection.prepareStatement("select * from librarianinfo where enrollment_no=?");

prepareStatement.setString(1,enrollment_no);


ResultSet resultSet;
resultSet=prepareStatement.executeQuery();

if(resultSet.next()==false)
{

resultSet.close();
prepareStatement.close();
connection.close();
throw new DAOException("Already exists :"+enrollment_no);
}
resultSet.close();
prepareStatement.close();

prepareStatement=connection.prepareStatement("update librarianinfo set name=?,password=?,email_address=?,mobile_no=?,enrollment_no=?,year=?,sem=?,branch=? where enrollment_no=?");
prepareStatement.setString(1,name);
prepareStatement.setString(2,password);
prepareStatement.setString(3,email_address);
prepareStatement.setString(4,mobile_no);
prepareStatement.setString(5,enrollment_no);
prepareStatement.setInt(6,year);
prepareStatement.setInt(7,sem);
prepareStatement.setString(8,branch);
prepareStatement.setString(9,enrollment_no);
prepareStatement.executeUpdate();
resultSet.close();
prepareStatement.close();
connection.close();
}
catch(Exception e)
{
throw new DAOException(e.getMessage());
}}


public void delete(String enroll_no) throws DAOException
{
try{
System.out.println(enroll_no);
Connection connection = DAOConnection.getConnection();
PreparedStatement prepareStatement;
prepareStatement=connection.prepareStatement("select * from librarianinfo where enrollment_no=?");
prepareStatement.setString(1,enroll_no);
ResultSet resultSet;
resultSet=prepareStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
prepareStatement.close();
connection.close();
throw new DAOException("Invalid enrollment :"+enroll_no);
}
resultSet.close();
prepareStatement.close();
//One check pending related to if this designation has been alloted to an employee
prepareStatement=connection.prepareStatement("delete from librarianinfo where enrollment_no=?");
prepareStatement.setString(1,enroll_no);
prepareStatement.executeUpdate();
prepareStatement.close();
connection.close();
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}}




public boolean validate(LibrarianDTO librarian) throws DAOException
{
try
{
String name=librarian.getName();
String password=librarian.getPassword();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from librarianinfo where name=? and password=?");
preparedStatement.setString(1,name);
preparedStatement.setString(2,password);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
}
catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return true;
}

public LibrarianDTO getByEnroll(String enroll_no) throws DAOException
{
try{
Connection connection=DAOConnection.getConnection();
PreparedStatement prepareStatement;
prepareStatement=connection.prepareStatement("select * from librarianinfo where enrollment_no=?");
prepareStatement.setString(1,enroll_no);
ResultSet resultSet;
resultSet=prepareStatement.executeQuery();

if(resultSet.next()==false)
{
resultSet.close();
prepareStatement.close();
connection.close();
throw new DAOException("Invalid Enrollment :"+enroll_no);
}
LibrarianDTO librarian=new LibrarianDTO();
librarian.setName(resultSet.getString("name"));
librarian.setPassword(resultSet.getString("password"));
librarian.setEmailAddress(resultSet.getString("email_address"));
librarian.setMobileNo(resultSet.getString("mobile_no"));
librarian.setEnrollmentNumber(resultSet.getString("enrollment_no"));
librarian.setYear(resultSet.getInt("year"));
librarian.setSemester(resultSet.getInt("sem"));
librarian.setBranch(resultSet.getString("branch"));
resultSet.close();
prepareStatement.close();
connection.close();

return librarian;
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}

} 