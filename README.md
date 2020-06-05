
# ZeroDay

Cert password: test1234

This project is a simple University Web Application that aims to secure a previous, more vulnerable version of the app. Screenshots can be seen below.

Assignment 1 can be accessed using the following link: <br />
https://github.com/LeonaMc/ZeroDay

## Team Members:
Leona McNulty, Ciarán Conlon, Anna Davison

## Database creation:
mysql> create database library;<br />
mysql> create user 'root'@'localhost' identified by 'root';<br />
mysql> grant all on library.* to 'root'@'localhost';<br />

## How to run:
1. Ensure database, user and password have all been created in MySQL Command Line Client.<br />
2. Project uses Java 8. If project doesn't run, check Java version.<br />
3. In the terminal, go to the folder where the project is stored and type the following to run the App:<br />
mvn spring-boot:run<br />
4. Go to web browser and type the following to direct you to the login page of the App:<br />
https://localhost:8443/login (localhost:8080/login should redirect to https://localhost:8443/login but this may not work<br />
in some browsers).<br />

# References

Registration and Login: <br />
https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/ <br />
