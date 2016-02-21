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

package demo.jaxrs.saml.server;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import demo.jaxrs.saml.common.Book;
import demo.jaxrs.saml.common.BookStore;

public class BookStoreImpl implements BookStore {
    private Map<Long, Book> books = new HashMap<Long, Book>();
    @Context
    private UriInfo uriInfo;

    public BookStoreImpl() {
        init();
    }
    
    @Override
    public Response getBook(Long id) {
        Book b = books.get(id);
        if (b == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(b).build();
    }

    @Override
    public Response updateBook(Long id, Book book) {
        Book b = books.get(id);

        if (b == null) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            b.setName(book.getName());
            return Response.ok().build();
        }
    }
    
    @Override
	public Response createBook(Book book) {
		Book b = books.get(book.getId());

		if (b != null) {
			return Response.status(Status.CONFLICT).build();
		} else {
			books.put(book.getId(), book);
			UriBuilder ub = uriInfo.getAbsolutePathBuilder();
			URI uri = ub.path(
					Long.toString(book.getId())).build();
			return Response.created(uri).link(uri, "new book").build();
		}
	}

    @Override
    public Response removeBook(Long id) {
        Book b = books.get(id);

        if (b == null) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            books.remove(id);
            return Response.ok().build();
        }
    }

    private void init() {
        books.clear();
        
        Book book = new Book();
        book.setId(123);
        book.setName("CXF in Action");
        books.put(book.getId(), book);
    }
    
}


