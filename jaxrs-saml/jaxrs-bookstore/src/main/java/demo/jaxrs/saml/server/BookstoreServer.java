package demo.jaxrs.saml.server;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

public class BookstoreServer
{
	public static void main(String argv[])
	{

		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(BookStoreImpl.class);
		sf.setProvider(new JacksonJaxbJsonProvider());
		sf.setAddress("http://localhost:8888/");
		sf.create();
	}
}
