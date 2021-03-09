/**
 * MIT License
 * 
 * Copyright (c) 2019 KK
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.netikalyan.restful.service;

import com.netikalyan.restful.model.Person;
import com.netikalyan.restful.model.Response;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class PersonServiceImpl implements IPersonService {

	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
	static {
		persons.put(1001, new Person("Kalyan", 36, 1001));
		persons.put(1002, new Person("Beda", 30, 1002));
		persons.put(1003, new Person("Ravi", 32, 1003));
		persons.put(1004, new Person("Kasthuri", 33, 1003));
	}

	@Override
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/add")
	public Response addPerson(Person p) {
		Response response = new Response();
		if (persons.get(p.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	@Override
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Response response = new Response();
		if (persons.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	@Override
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public Person getPerson(@PathParam("id") int id) {
		return persons.get(id);
	}

	@Override
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/all")
	public Person[] getAllPersons() {
		Person[] p = new Person[persons.size()];
		int i = 0;
		for (Person person : persons.values()) {
			p[i++] = person;
		}
		return p;
	}

}
