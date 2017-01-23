package demo.jaxrs.saml.client;

import javax.ws.rs.core.Response;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.jaxrs.saml.common.Book;
import demo.jaxrs.saml.common.BookStore;

public class BookstoreClientSpring
{
	private static final long NEW_BOOK_ID = 999L;
	private static final long EXISTING_BOOK_ID = 123L;

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext(new String[] { "classpath:client-context.xml" });

		BookStore client = (BookStore) context.getBean("bookStoreProxy");

		invoke(client);

		context.close();
	}

	private static void invoke(BookStore client)
	{
		Response response = client.getBook(EXISTING_BOOK_ID);
		Book myBook = response.readEntity(Book.class);
		System.out.println("Successfully got the book: " + myBook.getName());

		myBook.setName(myBook.getName() + ", updated edntion");
		response = client.updateBook(EXISTING_BOOK_ID, myBook);
		if (response.getStatus() == Response.Status.OK.getStatusCode())
		{
			System.out.println("Book was successfully updated");
		}

		Book newBook = new Book();
		newBook.setId(NEW_BOOK_ID);
		newBook.setName("My new book");
		response = client.createBook(newBook);
		if (response.getStatus() == Response.Status.CREATED.getStatusCode())
		{
			System.out.println("Book was successfully created: " + response.getLocation());
		}

		response = client.removeBook(NEW_BOOK_ID);
		if (response.getStatus() == Response.Status.OK.getStatusCode())
		{
			System.out.println("Book was successfully removed");
		}
	}
}
