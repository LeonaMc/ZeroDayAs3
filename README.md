
# ZeroDay

Previous project commits were made to the following repository (changed due to project restructure):
https://github.com/LeonaMc/ZD

# Collaborators
Leona McNulty 
Anna Davison 
Ciarán Conlon

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

# SQL Commands:
create database library;
create user 'root'@'localhost' identified by 'root';
grant all privileges on *.* to 'root'@'localhost';

# Group Leader:
Leona McNulty
# Team Members:
Ciarán Conlon, Anna Davison

# Diary:
Leona: 

       
       Grade Page creation and directing from welcome staff to grade page
       
       Register and Login: Students can register to the WebApp: Users can
       register by providing their personal details (name, surname, student ID,
       address, phone number, email address). The student will be able to create
       a username and a password that can be used during future logins.
       
       Duplicate username detection. No field can be empty on registration form.
       Password must be 8 words or more and less than 32 words. Autologin.
       Mobile number must be 7 or more/15 or less digits (International Standard)
       -- See UserValidator.java for more details. Country of origin selector
       implemented.

       Refactoring & Debugging code

       Grade Page creation and directing from welcome staff to grade page.
       
       Students can login and logout from the WebApp.

Anna:  
       
       Fix 'save' button when adding a new module
       Edit page doesn't save
       
       No registration functionality is required for staff.    The assumption is
       that staff is already registered in the system and does not need to do so.

       Students can cancel their registration.

       Payment: Students have to pay their fees for the current academic year in order to be able to enrol in a module.

Ciarán: 
      
       Staff can modify module info. Staff are allowed to modify information about modules.
