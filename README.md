# myRetail Products API
This project is an end-to-end Proof-of-Concept for a products API, which aggregates prroduct data from mutliple sources and returns it as JSON to the caller
## Technical stack
* Java based spring-boot REST API built to Open API 3.0 specification
* Contract first design using Swagger
* Documentation and Server stub auto generated using Swagger
* Mongo-db no SQL data store
* Gradle build system
* Integration Tests using JUnit
* Unit Tests using Spock
## Environment Requirements
* Java 12 JDK
* Mongo Db
## Instructions to Build and Run
* Clone the project repository from https://github.com/ocon0178/products.git
* Open a command terminal and cd to the root directory of the project
* Build an executable fat jar file with the following command:
```shell
.\gradlew bootJar
```
* Run the application with the following command
```shell
java -jar ../target/products-0.0.1-SNAPSHOT.jar
```
* Can optionally build a war and deploy in a application server such as tomcat
```shell
.\gradlew bootWar
```
## Configuration
* Defaults:
    * Mongo host: localhost
    * Mongo port: 27017 
```properties
server.servlet.context-path=/myretail/1.0
server.port=8080

redsky.url=https://redsky.target.com/v2/pdp/tcin/{id}

logging.path=C:\\temp\\productserver\\log
#logging.config to point to external log file

spring.data.mongodb.database=products
#spring.data.mongodb.host=localhost
#spring.data.mongodb.username=
#spring.data.mongodb.password=
#spring.data.mongodb.port=27017

```
* application.properties:
    * Internal configuration can be configured prior to building the jar at /projectroot/src/main/resources/application properties
    * External configuration directory can be specified as a system property with the following syntax.  The configured directory will be consulted for application.properties files.
```shell
java -jar ../target/products-0.0.1-SNAPSHOT.jar -Dspring.config.location=your/config/dir/
``` 

```properties
server.servlet.context-path=/myretail/1.0
server.port=8080

redsky.url=https://redsky.target.com/v2/pdp/tcin/{id}

logging.path=C:\\temp\\productserver\\log
#logging.config to point to external log file

spring.data.mongodb.database=products
#spring.data.mongodb.host=localhost
#spring.data.mongodb.username=
#spring.data.mongodb.password=
#spring.data.mongodb.port=27017

```
* logback-spring.xml to configure logging.

## Documentation and Usage
* Documentation for the API is available at /myretail/1.0/
* The Documentation has full usage details
* Built in 'Try it out!' feature can be used to test
## Roadmap
* Security
* Container definition and image publishing

