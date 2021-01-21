package com.thinking.machines.hr.dl;
public class ECBooksDTO implements java.io.Serializable,Comparable<ECBooksDTO>
{
private String book_id;
private String book_name;
private String author_name;
private String publisher;
public ECBooksDTO()
{
this.book_name="";
this.book_id="";
this.author_name="";
this.publisher="";
}
public void setBookId(String book_id)
{
this.book_id=book_id;
}
public String getBookId()
{
return this.book_id;
}
public void setBookName(String book_name)
{
this.book_name=book_name;
}
public String getBookName()
{
return this.book_name;
}
public void setAuthorName(String author_name)
{
this.author_name=author_name;
}
public String getAuthorName()
{
return this.author_name;
}
public void setPublisher(String publisher)
{
this.publisher=publisher;
}
public String getPublisher()
{
return this.publisher;
}
public boolean equals(Object object)
{
if(!(object instanceof ECBooksDTO)) return false;
ECBooksDTO other=(ECBooksDTO)object;
return this.book_name==other.book_name;
}
public int compareTo(ECBooksDTO other)
{
return this.book_name.compareToIgnoreCase(other.book_name);
}
public int hashCode()
{
return book_id.hashCode();
}
}