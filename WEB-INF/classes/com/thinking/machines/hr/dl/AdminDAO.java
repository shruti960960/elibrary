package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
import java.util.*;

public class AdminDAO 
{
public static List<AdminDTO> getAll() throws DAOException
{
List<AdminDTO> Admins;
Admins=new LinkedList<>();
try
{
Connection connection = DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from admininfo");
AdminDTO AdminDTO;
String name;
String password;
String email_address;
String mobile_no;
String home_address;
String admin_id;
while(resultSet.next())
{
name=resultSet.getString("name").trim();
password=resultSet.getString("password").trim();
email_address=resultSet.getString("email_address").trim();
mobile_no=resultSet.getString("mobile_no").trim();
home_address=resultSet.getString("home_address").trim();
admin_id=resultSet.getString("admin_id").trim();
AdminDTO=new AdminDTO();
AdminDTO.setName(name);
AdminDTO.setPassword(password);
AdminDTO.setEmailAddress(email_address);
AdminDTO.setMobileNo(mobile_no);
AdminDTO.setHomeAddress(home_address);
AdminDTO.setAdminId(admin_id);
Admins.add(AdminDTO);
}
resultSet.close();
statement.close();
connection.close();
}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return Admins;
}


public void update(AdminDTO admin) throws DAOException
{
try{

String name=admin.getName();
String password=admin.getPassword();
String email_address=admin.getEmailAddress();
String mobile_no=admin.getMobileNo();
String home_address=admin.getHomeAddress();
String admin_id=admin.getAdminId();

Connection connection=DAOConnection.getConnection();
PreparedStatement prepareStatement;
prepareStatement=connection.prepareStatement("select * from admininfo where admin_id=?");
prepareStatement.setString(1,admin_id);
ResultSet resultSet;
resultSet=prepareStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
prepareStatement.close();
connection.close();
throw new DAOException("Invalid Id :"+admin_id);
}
resultSet.close();
prepareStatement.close();
prepareStatement=connection.prepareStatement("update admininfo set name=?,password=?,email_address=?,mobile_no=?,home_address=? where admin_id=?");
prepareStatement.setString(1,name);
prepareStatement.setString(2,password);
prepareStatement.setString(3,email_address);
prepareStatement.setString(4,mobile_no);
prepareStatement.setString(5,home_address);
prepareStatement.setString(6,admin_id);
prepareStatement.executeUpdate();
resultSet.close();
prepareStatement.executeUpdate();
resultSet.close();
prepareStatement.close();
connection.close();
}
catch(Exception e)
{
throw new DAOException(e.getMessage());
}}


public boolean validate(AdminDTO admin) throws DAOException
{
try
{
String name=admin.getName();
String password=admin.getPassword();
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select name,password from admininfo where name=? and password=?");
preparedStatement.setString(1,name);
preparedStatement.setString(2,password);
ResultSet resultSet=preparedStatement.executeQuery();
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
} 