# spring code exercise

Task #1
Creating a Config Service REST api using Spring Boot that implements below apis to return and update JSON documents representing an application’s config properties. 
The application needs to store the JSON documents in any SQL database using Spring Data JPA.

* GET /api/{appCode}/config/{version} – return JSON document for specified appCode and version
* POST /api/{appCode}/config/{version} – add new or update existing JSON document for specified appCode and version. JSON document should be included in the request body
* GET /api/{appCode}/config – return list of available versions in JSON sorted by last modified date in descending order

Task #2
* Creating unit tests for task #1 (controller, service and repository layers).

### Prerequisites

* Eclipse IDE with STS plug in
* JDK 1.8
* MYSQL server

### Configuration

The data base used here is MYSQL. The connection properties are available in application.properties file

### Libraries Used

* SwaggerUI - for api documentation
* Mockito, JUnit - for unit testing
* SLF4J - for logging

swagger can be accessed at the below url:

http://localhost:9098/swagger-ui.html#/code45test45controller


## Author

* **Annie Susan**

