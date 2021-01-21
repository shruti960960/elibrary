package com.thinking.machines.hr.dl;
public class AdminDTO implements java.io.Serializable,Comparable<AdminDTO>
{
private String name;
private String password;
private String emailAddress;
private String mobileNumber;
private String homeAddress;
String id;
public AdminDTO()
{
this.name="";
this.password="";
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
public void setAdminId(String id)
{
this.id=id;
}
public String getAdminId()
{
return this.id;
}
public void setEmailAddress(String emailAddress)
{
this.emailAddress=emailAddress;
}
public String getEmailAddress()
{
return this.emailAddress;
}
public void setMobileNo(String mobileNumber)
{
this.mobileNumber=mobileNumber;
}
public String getMobileNo()
{
return this.mobileNumber;
}
public void setHomeAddress(String homeAddress)
{
this.homeAddress=homeAddress;
}
public String getHomeAddress()
{
return this.homeAddress;
}
public boolean equals(Object object)
{
if(!(object instanceof AdminDTO)) return false;
AdminDTO other=(AdminDTO)object;
return this.name==other.name;
}
public int compareTo(AdminDTO other)
{
return this.name.compareToIgnoreCase(other.name);
}
public int hashCode()
{
return name.hashCode();
}
}