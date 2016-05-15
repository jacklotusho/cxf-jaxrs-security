# Start CXF JAX-RS based SAML authentication

1. in root folder:
   mvn clean install

2. in sts project:
   mvn tomcat7:run

3. in jaxrs-bookstore project
   3.1) start jax-rs service:
        mvn exec:java -Dexec.mainClass="demo.jaxrs.saml.server.BookstoreServerSpring"
   
        alternatively to use STS token validation start service with:
        mvn exec:java -Dexec.mainClass="demo.jaxrs.saml.server.BookstoreServerSpringSTSValidation"

   3.2) start jax-rs client:
        mvn exec:java -Dexec.mainClass="demo.jaxrs.saml.client.BookstoreClientSpring"
