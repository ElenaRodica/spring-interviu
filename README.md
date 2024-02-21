# spring-interviu
API that acts as a store management tool

Local instructions

Build and run the project on your machine

Do maven clean from Maven Lifecycle to compile the project
After that you can run the application running the SpringInterviuApplication  class that has a main method
This will show the class in the configuration pannel and for subsequent runs, you can run the application from there.


H2 console can be accessible from http://localhost:8080/h2-console , when you have the application running

User and password for authentication are configured in the application.properties file 

Flyway scripts should be runned automatically when H2 console is accessed. 

You can test from Postman different requests for different endpoints. 


Possible Response Status Codes :

ResponseCode 	Description
200 	Request successfully processed, return body
400 	Bad request: Body is missing or can not process body
405     Method Not allowed
500     Internal Server Eror

