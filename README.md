# RESTful Web services in Java
REST, an acronym for REpresentational State Transfer, is an architectural style for developing applications that can be accessed over the network. **[JAX-RS](https://docs.oracle.com/javaee/6/tutorial/doc/giepu.html)** (Java API for RESTful Web Services) is the Java API for creating REST web services. It uses annotations to simplify the development and deployment of web services.

The project uses **[Jersey](https://jersey.github.io/)**, an open source framework that extends the JAX-RS toolkit with additional features and utilities to further simplify RESTful service and client development.

PersonRestfulDB exposes the following methods over HTTP.

| URI | HTTP Method | Description |
| --- | --- | --- |
|/person/add | POST | Adds a person |
|/person/{id}/delete|GET|Delete the person with ‘id’ in the URI|
| /person/all | GET | Get all persons |
| /person/{id} | GET | Get the person with ‘id’ in the URI |

