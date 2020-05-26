
# ZeroDay

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
localhost:8080/login<br />

## Diary:

Leona: 

       TODO
       
Anna:  
       
       TODO

Ciarán:

       TODO

## App Screenshots

#### Registration Page

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/1-Registration.PNG)

#### Registration Errors 

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/2-RegistrationErrors.PNG)

#### Student Welcome Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/3-StudentWelcomePage.PNG)

#### Pay Fees Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/4-PayFees.PNG)

#### Fees Already Paid Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/5-FeesAlreadyPaid.PNG)

#### Module Enrolment Page (when fees are paid - Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/6-ModuleEnrolmentExampleFeesPaid.PNG)

#### Module Enrolment Page (when fees aren't paid - Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/7-StudentCantEnrolExampleNoFeesPaid.PNG)

#### List of Student's Current Modules (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/8-ListOfCurrentlyEnrolledModules.PNG)

#### Student's Grades (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/9-ViewGrades.PNG)

#### Statistics Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/10-StatsPage.PNG)


#### List of Modules Offered by the University (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/11-ListOfModulesOfferedByUni.PNG)

#### Add New Grade (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDaAs3y/master/imgs/12-AddANewGrade.PNG)


#### Add New Module (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/13-AddANewModule.PNG)

#### Edit Module Details (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/15-EditModuleDetails.PNG)

#### List of Student Grades (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDayAs3/master/imgs/14-ListOfStudentGrades.PNG)

# References

Registration and Login: <br />
https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/ <br />

D3.js: <br />
https://stackoverflow.com/questions/31703396/d3-pie-chart-element-popout/31706125#31706125 <br />
