package demo.jaxrs.saml.common;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Book")
public class Book
{
	private String name;
	private long id;

	public Book()
	{
	}

	public Book(String name, long id)
	{
		this.name = name;
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String n)
	{
		name = n;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long i)
	{
		id = i;
	}

}
