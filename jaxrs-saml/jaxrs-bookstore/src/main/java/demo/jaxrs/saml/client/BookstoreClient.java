package demo.jaxrs.saml.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import demo.jaxrs.saml.common.Book;

public class BookstoreClient
{
	public static void main(String[] args)
	{
		Client client = ClientBuilder.newClient();
		client.register(new JacksonJaxbJsonProvider());
		WebTarget wt = client.target("http://localhost:8888/bookstore");
		Book book = wt.path("/books/123").request("application/json").get(Book.class);
		System.out.println("Successfully got the book: " + book.getName());
	}
}
