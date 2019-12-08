**Developer**: Luis Fernando Pereira  

**Email**: lyufer@gmail.com  

## Requirements
  
Java 11, Maven 3.1+ 

## Build

`mvn clean install`

## Run:

**With Maven**  
  
`mvn exec:java -pl employees-service -Dexec.mainClass=com.masglobal.consulting.employees.EmployeesApiApplication`  

**With Java**  

`java -jar employees-service/target/employees-service-0.0.1-SNAPSHOT.jar`


## Endpoint documentation Swagger 

`http://localhost:8080/api/swagger/swagger-ui.html`

[Swagger-UI](http://localhost:8080/api/swagger/swagger-ui.html)