
# ZeroDay

Previous project commits were made to the following repository (changed due to project restructure):
https://github.com/LeonaMc/ZD

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
3. Go to the folder where the project is stored and type the following to run the App:<br />
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
       Creation Module Managment section. Allow students to view available modules & enrol and 
       unenrol in a module, view a list of
       available modules and view a list of modules that they are currently enroled in. 
       Creation of Staff Functionality such that the staff can add new module, view all modules
       and edit pre-existing modules.
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

#### Login Page

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/1Login.PNG)
#### Registration Page

![alt text](https://raw.githubusercontent.com/LeonaMc/ZeroDay/master/2Registration.PNG)

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
