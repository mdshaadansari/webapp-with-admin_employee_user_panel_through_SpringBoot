*implemented Spring Boot (RESTfull backend) in old project(webapp) i created with Servlet back then at company, 
*i also have uploaded repository having this same webaap with servlet as well as in other repository you will find this webapp with Spring,
*below points are just summary in my words what is assigned throughout the development in sprint.

-webapp is for managing project that came from client,
-CRUD- admin can onboard/release employee on project
-admin,employee,client can login with otp 
-however employee, client account creation can be only done by admin, and login credentials will be sent over their email
-their are lot of robust filters to search client, project, employee based on different criteria
-must go to screenshots of whole project i provided in webapp-screenshot folder
-i will also upload recording video of webapp when i get free....


---------------------------------------------------
Project :- develeped a admin, client, employee panel 
--------------------------------------------------
MVC Design Pattern | DAO Implementation ....
--------------------------------------------------
Tech Stack :-   SPRING BOOT | REST | Data JPA | MYSQL
--------------------------------------------------


below points are just summary in my words that wahts going on in this app
	| -> define a category employee 
		| -> employee-id [employee id gets generated automatically in the given format [JTC-001 | JTC-002 ...]]
		| -> employee-name
		| -> employee-dept
		| -> employee-email [employee-email must be unique [red :- email is already in use [JSP] | green :- successful registration]]
		| -> employee-phone. 
		| -> employee-date-of-joining [dd-mm-yyyy [current-date]]
		| -> project
	| -> admin-module :- 
		| -> admin can add an employee. 
		| -> admin can get all the employee.
		| -> admin can get an employee on the basis of employee-id.
		| -> admin can get an employee on the basis of email.
		| -> admin can get all the employees on the basis of date-range. 
		| -> admin can delete an employee.
		| -> admin can add an employee.
		| -> admin can update the employee data except employee-id and employee-email.
		| -> admin can get the project details on the basis of employee-id.
		| -> admin can on-board an employee on a project.
			| -> an employee has only project at a time.
		| -> admin can release an employee from a project. 
		| -> because an employee can on the bench (no-project) it means admin can get all the employee which in on the bench. 
	| -> define a category project.
		| -> project-id [project id gets generated automatically in the given format [project-001 | project-002 ...]]
		| -> project-name 
		| -> project-start-date
		| -> project-end-date
		| -> client
		| -> employee
	| -> admin-module :- 
		| -> admin can add a project. 
		| -> admin can get all the project.
		| -> admin can get a project on the basis of project-id.
		| -> admin can get the clients information of the basis of project-id.
		| -> admin can get all the employee on the basis of project-id
		| -> admin can delete a project.
		| -> admin can update the project information except project-id.
	| -> define a category client.
		| -> client-id [client id gets generated automatically in the given format [client-001 | client-002 ...]]
		| -> client-name [company-name] 
		| -> contact-person-details [name | email | phone | designation]
			| -> a client can have more then one content-person.
		| -> client-relationship-date
		| -> projects.
	| -> admin-module :- 
		| -> admin can add a client
		| -> admin can get all the clients.
		| -> admin can get the project details from the client-id.
		| -> admin can update the client information.
		| -> admin can delete a client. 
	| -> client can login :- 
		| -> client provides their email at the time of login.
		| -> your application send an OTP on the client email-id which will use by the client to login.
		| -> OTP [6-digits]
		| -> only 5 unsuccessful login attempt is allowed.
		| -> after 5th unsuccessful login attempt account gets ban for next 5 mins.
		| -> after every unsuccessful login an error message occurs on login page. 
		| -> after the successful login control moves to the client dash-board, where client can get all their details, project details, project specific employee  details.
	| -> employee can login :- 
		| -> employee provides their email at the time of login.
		| -> your application send an OTP on the client email-id which will use by the employee to login.
		| -> OTP [6-digits]
		| -> only 5 unsuccessful login attempt is allowed.
		| -> after 5th unsuccessful login attempt account gets ban for next 5 mins.
		| -> after every unsuccessful login an error message occurs on login page. 
		| -> after the successful login control moves to the employee dash-board, where employee can get all their details, project details.
