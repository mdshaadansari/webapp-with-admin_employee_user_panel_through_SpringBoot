package com.example.project3_test.DAO_Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.project3_test.model.Client;
import com.example.project3_test.model.ContactPerson;
import com.example.project3_test.model.Employee;
import com.example.project3_test.model.Project;

 
public interface DAOInterface2 {

//--------------------------------createClient_Controller
	//adding client and contactperson in DB 
	public Client insertIntoClient(Client Client) ;
	
	

	//return last Client Id available in Client Table
	public String getLastClientIDFromDB();
	
	//check if given email is available in Client DB
			List<String> checkClientEmail(String email);
			

			 //------------------------createEmployee_Controller.java---------------

			//inserting data in Employee Table
			  public   Employee insertIntoEmployee(Employee employee) ;
			  

				//check if given email is available in Employee DB
					boolean checkemployeeEmail(String email);
			  
			  
			//return last Employee Id available in Employee Table
				String getLastEmpoyeeIDFromDB();

				 //------------------------createProject_Controller.java---------------
				//inserting data in Project Table
				Project   insertIntoProject(Project Project);
			

				//return last Project Id available in Project Table
				public String getLastProjectIDFromDB();

//------------------------add$Release_EmployeeToProject_Controller.java--------------------------------------------
				
				//return Employee already assigned to some Project or return emlpoyee not on bench
				List<String> checkEmployeeOnBenchOrNot(String employeeId);
				
				
				
				//assigning Project to emolyee, return numerical value greater than 0 if successfull else return 0
				Employee assiginProjectToEmployee(String projectIdInEmployee, String employeeId);

				
				//releasing Employee from Project,return numerical value greater than 0 if successfull else return 0
				Employee		releaseEmployeeFromProject(String projectIdInEmployee,String employeeId);

				//---------------------addContactPersonToClient_Controller.java---------------------

				public Client InsertContactPersonInClient(String clientId,ContactPerson ContactPerson ) ;

				 //---------------------------------------------addProjectToClient_Controller
				

				  //return Project info acording to projectId if Client is already assigned to Project
				  public List<String> checkProjectAssignedToClientOrNot(String projectId);
				 
				
				
				public Client assignProjectToClient(String clientId,String ProjectId ) ;

				
				//----------------------------searchClient_Controller------------------------------
				// return list,where elements are themself a list of different coloumn of cliet table
						public List<Client> getAllClient();

						
						// return list,where elements are themself a list of different coloumn of Project table(all column) based on matching clientId
				public List<Object []>  getAllProjectForClientId2(String clientId);

				
//----------------------------------searchClient_Controller-------------
				// return list,where elements are themself a list of different coloumn of Employee table( all column)
				public List<Employee> getAllEmployeeEveryColumn();
				
				
				

				public List<Object[]> getAllEmployeeByEmployeeEmail(String employeeEmail);
				

				// return list,where elements are themself a list of different coloumn( all column) of Employee table based on matching employeeId
				public Employee getAllEmployeeByEmployeeId(String employeeId);


				
				// return list having Employee and Project details based on matching employeeId
							public  List<Object[]> getEmployeeAndProjectByEmployeeId(String employeeId);


							// return list,where elements are themself a list of different coloumn of Employee  table based on Employee on bench( all column)
							public List<Object[]>getEmployeeOnBench();


//----------------------------searchProject_Controller.java-----------------

							//return list,where elements are themself a list of different coloumn(all column) of Project table
							public List<Project> getAllProjectEveryColumn();
							

							//return list,where elements are themself a list of different coloumn(all column) of Project table based on matching projectId
							public 	List<Object[]>getAllProjectEveryColumnByProjectId(String projectId);

							// return list,where elements are themself a list of different coloumn of cliet table(all column) based on projectId
							public List<Object[]> getAllClientByProjectId(String projectId);
							



							// return list,where elements are themself a list of different coloumn( all column) of Employee table based on matching ProjectId
									public List<Object[]> getAllEmployeeEveryColumnByProjectId(String projectId);
 
	//-------------------------------------Client_Dashboard_controller.java

// return list,where elements are themself a list of different coloumn of cliet table(all column) based on clientId
public Client getAllClientByClientId(String clientId);



//return list where elements are also list of every column of Project table based on clientId
public List<Object[]> getAllProjectEveryColumnByClientId(String clientId) ;
	


//fetching Employee details based on clientId  who is working for this Client
public List<Object[]> getAllEmployeeEveryColumnByClientId(String clientId) ;



//--------------------------------------------Employee_Dashboard_Conroller.java
//return list,where elements are themself a list of different coloumn(all column) of Project table based on matching projectId
	public List<Object[]> getAllProjectEveryColumnByemployeeId(String employeeId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------update_delete_client_Controller.java----------------------

	//update Client
	public Client updateClient(Client Client,String clientId) ;
	
	
	
	public Boolean deleteclient(String clientId) ;
	


	//------------------------------update_delete_employee_Controller.java----------------------

	public Employee updateEmployee(Employee employee,String employeeId) ;
	
	

public boolean deleteEmployeeByEmployeeId(String employeeId);

//------------------------------update_delete_project_Controller.java----------------------
public Project updateProject(Project project,String projectId) ;




//delete Project by projectId
public boolean deleteProjectByProjectId(String projectId) ;
}