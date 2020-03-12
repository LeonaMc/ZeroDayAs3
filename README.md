
# ZeroDay

Previous project commits were made to the following repository (changed due to project restructure): <br />
https://github.com/LeonaMc/ZD

This project is a simple University Web Application. Staff mode can be accessed from the login page without registeration, student mode requires registration. Screenshots of the app can be seen below.

# Collaborators
Leona McNulty<br />
Anna Davison<br />
Ciarán Conlon<br />

# Group Leader:
Leona McNulty
# Team Members:
Ciarán Conlon, Anna Davison

# Database creation:
create database library;<br />
create user 'root'@'localhost' identified by 'root';<br />
grant all privileges on *.* to 'root'@'localhost';<br />

# How to run:
1. Ensure database, user and password have all been created in MySQL Command Line Client.<br />
2. Project uses Java 8. If project doesn't run, check Java version.<br />
3. In the terminal, go to the folder where the project is stored and type the following to run the App:<br />
mvn spring-boot:run<br />
4. Go to web browser and type the following to direct you to the login page of the App:<br />
localhost:8080/login<br />

# Diary:

Leona: 

       Creation and styling of login and registration pages. 
       Allow student to logout.
       Allow user to create username and password that can be used for future logins.
       Avoid duplicate username registration. Produce error messages when registration is 
       filled out incorrectly or a field is blank. For example, password must be 8 characters or
       more and less than 32 characters long. Mobile number must be 7 or more/15 or 
       less digits (International Standard). See UserValidator.java and validation.properties for
       more details on error messages.
       Reject unregistered users at sign-in. 
       Creation of Module Managment section. Allow students to view available modules & enrol and 
       unenrol in a module, if the module is full then the user can't enrol. This is set to 2 for 
       testing purposes.
       Allow students to view a list of available modules that they are currently enroled in. 
       Allow student to view statistics using third party library https://d3js.org/ to visualise statistics. 
       Students can view the number of students with x nationality and the amount of 
       students that are male vs female.
       Creation of Staff Functionality such that the staff can add new module, view all modules
       and edit pre-existing modules.
       Get functionality to check student has paid before they enrol working.
       Get functionality that allows staff to input grades working. Get these grades to appear on
       a new page for staff to view.
       Allow students to view their grades.
       Refactoring & Debugging.

Anna:  
       
       Functionality for 'save' button when adding a new module
       Functionality for 'save' button on editform page
       Create a Staff Mode hyperlink
       Allow students to cancel their registration.
       Create a page for students to pay fees. 
       Create error messages when user input for payment of fees is invalid.
       Debugging.


Ciarán:

       Staff can modify module info. Staff are allowed to modify information about modules.
       Grade entry form and function for staff to list all grades.
       Model and repository related to grade objects.
       Students can view their own grades.


# App Screenshots

#### Registration Page

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/1-Registration.PNG)

#### Registration Errors 

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/2-RegistrationErrors.PNG)

#### Student Welcome Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/3-StudentWelcomePage.PNG)

#### Pay Fees Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/4-PayFees.PNG)

#### Fees Already Paid Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/5-FeesAlreadyPaid.PNG)

#### Module Enrolment Page (when fees are paid - Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/6-ModuleEnrolmentExampleFeesPaid.PNG)

#### Module Enrolment Page (when fees aren't paid - Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/7-StudentCantEnrolExampleNoFeesPaid.PNG)

#### List of Student's Current Modules (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/8-ListOfCurrentlyEnrolledModules.PNG)

#### Student's Grades (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/9-ViewGrades.PNG)

#### Statistics Page (Student Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/10-StatsPage.PNG)


#### List of Modules Offered by the University (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/11-ListOfModulesOfferedByUni.PNG)

#### Add New Grade (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/12-AddANewGrade.PNG)


#### Add New Module (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/13-AddANewModule.PNG)

#### List of Student Grades (Staff Mode)

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/imgs/14-ListOfStudentGrades.PNG)


# Project Details

A web application that can be used by the students to enroll to modules, visualize their grades, and also visualize statistics
to build a web application that can be used by students to search for information about modules.

It will have the following functionality:

View School Statistics: allow students to visualize statistics about the school (e.g., percentage of male and female among students and
staff); students nationalities.

Students can register to the WebApp: Users can register by providing their personal details (name, surname,  student ID, address,
phone number, email address). The student will be able to create a username and a password that can be used during future logins.
Students can login and logout from the WebApp.

Students have to pay their fees for the current academic year in order to be able to enrol in a module.

Students can visualize the modules they are currently enrolled in and their grades: After login is performed successfully, students
should be able to view the modules they are enrolled in and their grades.

View Available Modules: students should be able to look for modules provided by the school on a specific topic. When a module is
visualized, it should be possible to see the module name, the module topics, the name of the module coordinator, and view module
statistics (number of enrolled students, grades distributions for previous editions of the module).

Students can enroll in a module: After a module is selected, the student can enrol in the module if there is still availability
(number of registered students does not exceed a max number of students).

Students can cancel their enrolment for modules that have not terminated.

Students can cancel their registration.

No registration functionality is required for staff. The assumption is that staff is already registered in the system and does not need
to do so.

Staff can modify module info. Staff are allowed to modify information about modules.

Staff can input grades. Staff are allowed to input grades for students when a module terminates.


# References

Registration and Login: <br />
https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/ <br />

D3.js: <br />
https://stackoverflow.com/questions/31703396/d3-pie-chart-element-popout/31706125#31706125 <br />
