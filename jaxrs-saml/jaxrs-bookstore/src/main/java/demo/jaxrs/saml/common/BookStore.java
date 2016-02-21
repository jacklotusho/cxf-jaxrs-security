/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package demo.jaxrs.saml.common;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/bookstore")
@Produces("application/json")
@Consumes("application/json")
public interface BookStore {

    @GET
    @Path("/books/{id}")
	Response getBook(@PathParam("id") Long id);

    @PUT
    @Path("/books/{id}")
	Response updateBook(@PathParam("id") Long id, Book book);
	
	@POST
	@Path("/books")
	Response createBook(Book book);

    @DELETE
    @Path("/books/{id}")
	Response removeBook(@PathParam("id") Long id);
}


