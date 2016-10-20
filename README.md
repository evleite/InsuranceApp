# InsuranceApp
Case insurance contract project for Spring Boot

## Location
InsuranceApp is located on [https://github.com/pedalv/InsuranceApp.git](https://github.com/pedalv/InsuranceApp.git)

## Tools
[Apache Maven](https://maven.apache.org/download.cgi) version: 3.3.9
Maven home: D:\Tools\java\apache-maven-3.3.9
[Java version](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html): 1.8.0_101, vendor: Oracle Corporation
Java home: C:\Program Files (x86)\Java\jdk1.8.0_101\jre
OS name: "windows 10", version: "10.0", arch: "x86", family: "dos"
Download [IntelliJ IDEA](http://www.jetbrains.com/idea/download/index.html#section=windows)

## Create project
- [Start Spring Boot](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#getting-started)
- [Create pom file](http://start.spring.io/)
- Compile project and create jar file
```bash
$ mvn clean compile package
```
Building jar: ..\InsuranceApp\target\InsuranceApp-0.0.1-SNAPSHOT.jar
- Run project from IntelliJ IDEA or from command line (below)
```bash
$ java -jar InsuranceApp-0.0.1-SNAPSHOT.jar 
```
- See all dependencies
```bash
$ mvn dependency:tree
```
- Open the projet [InsuranceApp](http://localhost:8080) in a browser

## Task Description
- The client would like estabelish an insurance contract with a company that give him/her the best deal.
- An expert team will help him/her to find the best product available in the market from several companies.
- A service will return to client from the company that gave him/her the best deal.

## Identities
- Klient: Person looks for an insurance contract. 
- Integrasjonslag: Expert team responsavel to find the best product from all companies available.
- Fagsystem: Products(1) available in Gjensidige, If, etc in accordance with clients needs.
- Brevtjeneste: Service(2) information return to the must happy client.
(1) List with all products available from company A located in their DB.
(2) List of services with all details located in a common DB for all companies

## Overall flow
* Opprett avtale: Klient -> Integrasjonslag
+ Model:  type of product user want, information about user.
+ GET /api/v1/productuser (What is the product user want + user information - form) -> [Get](http://localhost:8080/api/v1/productuser) 
+ POST /api/v1/productuser (Send the product user want + user information - create) -> [POST](http://localhost:8080/api/v1/productuser) 

* Opprett kunde: Integrasjonslag -> Fagsystem
+ Model: create user in the company with best deal available.
+ POST /api/v1/user (Send user information to create client in company A - create) -> [POST](http://localhost:8080/api/v1/user) 
* Kundenummer: Fagsystem -> Integrasjonslag
+ GET eller POST /api/v1/user (Send user client information - return clientnumber) -> [GET eller POST](http://localhost:8080/api/v1/user) 

* Opprett avtale: Integrasjonslag -> Fagsystem
+ Model: type of product user want
+ POST /api/v1/product (Send information about product user want - form) -> [POST](http://localhost:8080/api/v1/product) 
* avtalenummer: Fagsystem -> Integrasjonslag
+ GET eller POST /api/v1/service (Send number of the best service available - return servicenumber) -> [GET eller POST](http://localhost:8080/api/v1/service) 

* Send avtale til kunde: Integrasjonslag(Brevtjneste) -> Klient 
+ Model: type of service user get
+ GET eller POST /api/v1/servicestatus (Get service information from  servicenumber - return serviceinformation) -> [GET eller POST](http://localhost:8080/api/v1/servicestatus) 
* Status på utsendelse: Klient -> Integrasjonslag(Brevtjneste) 
+ Model: service payment status from user
+ GET /api/v1/status (Get confirmation of payment - Status) -> [GET](http://localhost:8080/api/v1/status) 

* Oppdater status til "avtale sendt": Integrasjonslag -> Fagsystem
+ Model: service payment status from user
+ GET /api/v1/status (Get confirmation of payment from user - return Status) -> [GET](http://localhost:8080/api/v1/status) 
* avtalestatus: Fagsystem -> Integrasjonslag 
+ Model: service status from company A - Insurance is active
+ GET /api/v1/status (Get confirmation that insurance is active now - return Status) -> [GET](http://localhost:8080/api/v1/status) 

* avtalenummer og status: Integrasjonslag -> Klient
+ Model: service information and it is active
+ GET eller POST /api/v1/servicestatus (Get confirmation that insurance is active now - return Service+Status) -> [GET eller POST](http://localhost:8080/api/v1/servicestatus) 

## Model
product: What product user want - Product description
user: User information 
service: Type of insurance service user got - Service information 
status: payment by user and service status - Pending, Active, Cancel 

## REST API
- GET and POST /api/v1/productuser (view) -> [GET and POST](http://localhost:8080/api/v1/productuser) 
- POST and GET /api/v1/user (create) -> [POST and GET](http://localhost:8080/api/v1/user) 
- POST and GET /api/v1/product (view) -> [POST and GET](http://localhost:8080/api/v1/product) 
- GET /api/v1/service (view) -> [GET](http://localhost:8080/api/v1/service) 
- GET or POST /api/v1/servicestatus (view) -> [GET or POST](http://localhost:8080/api/v1/servicestatus) 
- GET /api/v1/status (view) -> [GET](http://localhost:8080/api/v1/status) 
- GET or POST /api/v1/servicestatus (view) -> [GET or POST](http://localhost:8080/api/v1/servicestatus) 