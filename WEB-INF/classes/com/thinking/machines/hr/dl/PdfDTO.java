package com.thinking.machines.hr.dl;
import javax.servlet.http.*;
public class PdfDTO implements java.io.Serializable,Comparable<PdfDTO>
{
private String bookid="";
private String bookname="";
private String bookauthor="";
private String bookpublisher="";
private String filepart;

public PdfDTO()
{
this.bookid="";
this.bookname="";
this.bookauthor="";
this.bookpublisher="";
this.filepart="";
}

public void setBookId(String bookid)
{
this.bookid=bookid;
}
public String getBookId()
{
return this.bookid;
}

public void setBookName(String bookname)
{
this.bookname=bookname;
}
public String getBookName()
{
return this.bookname;
}

public void setBookAuthor(String bookauthor)
{
this.bookauthor=bookauthor;
}
public String getBookAuthor()
{
return this.bookauthor;
}

public void setBookPublisher(String bookpublisher)
{
this.bookpublisher=bookpublisher;
}
public String getBookPublisher()
{
return this.bookpublisher;
}

public void setBookPdf(String filepart)
{
this.filepart=filepart;
}
public String getBookPdf()
{
return this.filepart;
}

public boolean equals(Object object)
{
if(!(object instanceof PdfDTO)) return false;
PdfDTO other=(PdfDTO)object;
return this.bookname==other.bookname;
}
public int compareTo(PdfDTO other)
{
return this.bookname.compareToIgnoreCase(other.bookname);
}
public int hashCode()
{
return bookname.hashCode();
}
}