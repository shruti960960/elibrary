package com.thinking.machines.hr.dl;
public class LibrarianDTO implements java.io.Serializable,Comparable<LibrarianDTO>
{
private String name="";
private String password="";
private String emailAddress="";
private String mobileNo="";
private String enrollmentNumber="";
private int year;
private int sem;
private String branch="";

public LibrarianDTO()
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

public void setEmailAddress(String emailAddress)
{
this.emailAddress=emailAddress;
}
public String getEmailAddress()
{
return this.emailAddress;
}

public void setMobileNo(String mobileNo)
{
this.mobileNo=mobileNo;
}
public String getMobileNo()
{
return this.mobileNo;
}

public void setEnrollmentNumber(String enrollmentNumber)
{
this.enrollmentNumber=enrollmentNumber;
}
public String getEnrollmentNumber()
{
return this.enrollmentNumber;
}

public void setYear(int year)
{
this.year=year;
}
public int getYear()
{
return this.year;
}

public void setSemester(int sem)
{
this.sem=sem;
}
public int getSemester()
{
return this.sem;
}

public void setBranch(String branch)
{
this.branch=branch;
}
public String getBranch()
{
return this.branch;
}

public boolean equals(Object object)
{
if(!(object instanceof LibrarianDTO)) return false;
LibrarianDTO other=(LibrarianDTO)object;
return this.name==other.name;
}
public int compareTo(LibrarianDTO other)
{
return this.name.compareToIgnoreCase(other.name);
}
public int hashCode()
{
return name.hashCode();
}
}