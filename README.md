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
- Run project from IntelliJ IDEA or from CMD (below)
```bash
$ java -jar InsuranceApp-0.0.1-SNAPSHOT.jar 
```
- See all dependencies
```bash
$ mvn dependency:tree
```
- Open the projet [InsuranceApp](http://localhost:8080) in a browser