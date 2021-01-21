package com.thinking.machines.hr.dl;
public class DTOtrial implements java.io.Serializable,Comparable<DTOtrial>
{
private String bookname;
private byte[] bookpdf;

public DTOtrial()
{
this.bookname="";
this.bookpdf=new byte[10000];
}
public void setBookName(String bookname)
{
this.bookname=bookname;
}
public String getBookName()
{
return this.bookname;
}

public void setBookPdf(byte[] bookpdf)
{
this.bookpdf=bookpdf;
}
public byte[] getBookPdf()
{
return this.bookpdf;
}


public boolean equals(Object object)
{
if(!(object instanceof AdminDTO)) return false;
DTOtrial other=(DTOtrial)object;
return this.bookname==other.bookname;
}
public int compareTo(DTOtrial other)
{
return this.bookname.compareToIgnoreCase(other.bookname);
}
public int hashCode()
{
return bookname.hashCode();
}
}