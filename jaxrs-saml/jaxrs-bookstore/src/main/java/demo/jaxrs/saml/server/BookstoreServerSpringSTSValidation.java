package demo.jaxrs.saml.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookstoreServerSpringSTSValidation {

	public static void main(String argv[]) throws InterruptedException {
		
        // Initialize the spring context and fetch our test client
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:server-context-sts-validation.xml" });
	       Thread.sleep(100000000);
        
        System.out.println("Shutdown server ...");
        context.close();
	}
}
