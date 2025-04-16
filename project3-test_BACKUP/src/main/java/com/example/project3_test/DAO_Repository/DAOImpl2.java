package com.example.project3_test.DAO_Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.example.project3_test.JPARepository.client_JPARepository;
import com.example.project3_test.JPARepository.contactPerson_JPARepository;
import com.example.project3_test.JPARepository.employee_JPARepository;
import com.example.project3_test.JPARepository.project_JPARepository;
import com.example.project3_test.exception.noMember;
import com.example.project3_test.exception.requiredFields;
import com.example.project3_test.model.Client;
import com.example.project3_test.model.ContactPerson;
import com.example.project3_test.model.Employee;
import com.example.project3_test.model.Project;
 
 @Repository 
// @Transactional(readOnly = false)	
public class DAOImpl2 implements DAOInterface2{
 
	 @Autowired
	 client_JPARepository client_JPARepository;
	 
	 @Autowired
	 employee_JPARepository employee_JPARepository;
	 
	 @Autowired
	 project_JPARepository project_JPARepository;

	 @Autowired
	 contactPerson_JPARepository contactPerson_JPARepository;
	 
	//--------------------------------createClient_Controller.java-----------------------
		//adding client and contactperson in DB  
		
	 
		@Override
		public Client insertIntoClient(Client  client) {
			System.out.println("insertIntoClient method");
			System.out.println("start inserting new client in DB");
//	 	 Serializable id=	hibernateTemplate.save(client); 
		    // Ensure all ContactPersons have a reference to Client
		    if (client.getContactPerson() != null) {
		        for (ContactPerson cp : client.getContactPerson()) {
		            cp.setClientIdInContactPerson(client);
		        }
		    }
			Client c=client_JPARepository.save(client);
		 if (c!=null) {  
		        System.out.println("client inserted successfully  "  );
		        return   c;
		    }

		    System.out.println("Failed to insert client");
		    return null;
		}	 
		
		 
		@Override
		public String getLastClientIDFromDB() {
			System.out.println("getLastClientIDFromDB method");
			//getting session
//			   Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//			   Query<String> query = (Query<String>) session.createNativeQuery( "SELECT clientId FROM client ORDER BY CAST(SUBSTRING(clientId, 8) AS UNSIGNED) DESC LIMIT 1");
	//
//				    List<String> e = query.getResultList();
			 List<String> e = client_JPARepository.getLastClientIDFromDB();
			
			return e.size()>0 &&  (!e.isEmpty())? e.get(0) : null;
			
		}

		
		//check if given email is available in client DB
		public List<String> checkClientEmail(String email){

			System.out.println("checkClientEmail--- method");
			List<String> clientDetails=new ArrayList<>();
//			String sql = "select emailClient,ClientName,clientId from client where emailClient=?";
//			List<Object[]>l=hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql).setParameter(1, email).getResultList();
			List<Object[]>l=client_JPARepository.checkClientEmail(email);
			for(Object []o:l) {
				for(int i=0;i<o.length;i++) {
					if(i==0) {
						clientDetails.add((String)o[i]);
					}else if(i==1) {
						clientDetails.add((String)o[i]);
					}else if(i==2) {
						clientDetails.add((String)o[i]);
					}
				}
			}
			System.out.println("returning from checkClientEmail--- method");
			return !clientDetails.isEmpty()?clientDetails:null;
			
			
		}
		
		
		
		
		
		
		
		
		
		 //------------------------createEmployee_Controller.java---------------

		//inserting data in Employee Table
		@Override
		  public   Employee insertIntoEmployee(Employee employee) { 
		System.out.println("insertIntoEmployee method");
		System.out.println("start inserting new employee in DB");
		
		if(employee.getProjectIdInEmployee()!=null) { 
		}
		
		
	 	 	Employee em=employee_JPARepository.save(employee);
	 	 	String id=em.getEmployeeId();
	 	 	System.out.println("end inserting new employee in DB");
	 	 	if (id !=null || !id.isEmpty()) { // Ensure it's a String
	 	        System.out.println("Employee inserted successfully with ID: " + id);
	 	        return  em;
	 	    }

	 	    System.out.println("Failed to insert employee");
	 	    return null;
	 	}
		
		
		

		//return last Employee Id available in Employee Table
		@Override
		public String getLastEmpoyeeIDFromDB() {
			System.out.println("getLastEmpoyeeIDFromDB method");
			//getting session
//			   Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//			   NativeQuery query = session.createNativeQuery( "SELECT employeeId FROM employee ORDER BY CAST(SUBSTRING(employeeId, 5) AS UNSIGNED) DESC LIMIT 1");
//		    List<String> e = query.getResultList();
			
			 List<String> e = employee_JPARepository.getLastEmpoyeeIDFromDB();
				     
			if(e.size()>0 && !e.isEmpty()) {
			return e.get(0);
			}else {
					return null;
		}
		}
		
		
		
		
		

		//check if given email is available in Employee DB
		  @Override
	     public	boolean checkemployeeEmail(String email) {
			System.out.println("getemployeeEmail method"); 
	/*		List<employee> l=	(List<employee>) hibernateTemplate.find("from employee where employeeEmail=?0", email);
		*/	
			List<Employee> l= employee_JPARepository.findByEmployeeEmail(email);
			System.out.println("checking is that email is already in DB\t"+email );
			if( l.size()>0 && ! l.isEmpty()) {
				System.out.println("YES email is already in DB\t"+email );
				return true;
			}else {
				System.out.println("No email is not in DB\t"+email );
				return false;
			} 
		} 
		  
		
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

			 //------------------------createProject_Controller.java---------------

		  
			 
			@Override
			public String getLastProjectIDFromDB() {
				System.out.println("getLastProjectIDFromDB method");
		 
					 
					//getting session
//					   Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//					   Query<String> query = (Query<String>) session.createNativeQuery( "SELECT projectId FROM project ORDER BY CAST(SUBSTRING(projectId, 9) AS UNSIGNED) DESC LIMIT 1");
		//
//						    List<String> e = query.getResultList();
						     
				List<String> e = 	project_JPARepository.getLastProjectIDFromDB();
				
					if(e.size()>0 && !e.isEmpty()) {
					return e.get(0);
					}else {
							return null;
				}
			}
			
			

			@Override
			public  Project   insertIntoProject(Project project) { 
				System.out.println("insertIntoproject method");
				System.out.println("start inserting new project in DB");
//		 	 	Serializable id=hibernateTemplate.save(project);
		 	 	Project p=project_JPARepository.save(project);
		 	 	String id=p.getProjectId();
				System.out.println("end inserting new project in DB");
				if (id !=null || !id.isEmpty()) { // Ensure it's a String
			        System.out.println("project inserted successfully with ID: " + id);
			        return  p;
			    }

			    System.out.println("Failed to insert project");
			    return null;
			}
			//------------------add$Release_EmployeeToProject_Controller.java--------------------------------------------------------
			
			

			 
			public List<String> checkEmployeeOnBenchOrNot(String employeeId){
				System.out.println("checkEmployeeOnBenchOrNot method"); 
				List<String> checkEmployeeOnBenchOrNot= new ArrayList();
			
				String employeeIdOfEmployeeWhoIsAlreadyAssignedToSomeProject=null;
				String employeeNameOfEmployeeWhoIsAlreadyAssignedToSomeProject=null;
				String projectIdInEmployeeOfEmployeeWhoIsAlreadyAssignedToSomeProject=null;
				
//			List<Object[]>l=	(List<Object[]>) hibernateTemplate.find("select employeeName,employeeId,projectIdInEmployee  from employee where employeeId=?0 and projectIdInEmployee is not null", employeeId);
				List<Object[]>l=	employee_JPARepository.checkEmployeeOnBenchOrNot(employeeId);
			for(Object []o:l) {
				for(int i=0;i<o.length;i++) {
					if(i==0) {
						employeeNameOfEmployeeWhoIsAlreadyAssignedToSomeProject=o[i].toString();
					}else if(i==1) {
						employeeIdOfEmployeeWhoIsAlreadyAssignedToSomeProject=o[i].toString();
					}else if(i==2) {
						projectIdInEmployeeOfEmployeeWhoIsAlreadyAssignedToSomeProject=o[i].toString();
					}
				}
			}
			checkEmployeeOnBenchOrNot.add(employeeNameOfEmployeeWhoIsAlreadyAssignedToSomeProject);
			checkEmployeeOnBenchOrNot.add(employeeIdOfEmployeeWhoIsAlreadyAssignedToSomeProject);
			checkEmployeeOnBenchOrNot.add(projectIdInEmployeeOfEmployeeWhoIsAlreadyAssignedToSomeProject);
			return   employeeIdOfEmployeeWhoIsAlreadyAssignedToSomeProject!=null ? checkEmployeeOnBenchOrNot:null;
			
			
			}
			
			
			
			
			public Employee assiginProjectToEmployee(String projectIdInEmployee,String employeeId) {
				System.out.println("assiginProjectToEmployee method"); 
				 
				
//				employee e=hibernateTemplate.get(employee.class, employeeId);
				Optional<Employee> e=employee_JPARepository.findById(employeeId); 
				Optional<Project> p=project_JPARepository.findById(projectIdInEmployee);
				
				if(!e.isPresent() || !p.isPresent() ) {
					throw new  noMember();
				
				}else {		
				e.get().setProjectIdInEmployee(p.get());
//			 	hibernateTemplate.update(e);
				Employee employee=employee_JPARepository.save(e.get());
			 	return employee;			
				}
			}
			
			
			 
			public Employee		releaseEmployeeFromProject(String employeeId,String projectId) {
				System.out.println("releaseEmployeeFromProject method"); 
				
				
				System.out.println(employeeId); 
				System.out.println(projectId); 
//				employee e=hibernateTemplate.get(employee.class, employeeId);

				
				Optional<Employee>e=employee_JPARepository.findById(employeeId);
				System.err.println(e.isPresent());
				//System.err.println(e.get().getProjectIdInEmployee().getProjectId()); 
				//System.err.println(e.get().getProjectIdInEmployee()); 
				if(e.isPresent() && e.get().getProjectIdInEmployee()!=null && e.get().getProjectIdInEmployee().getProjectId().equals(projectId)) {
//				e.setProjectIdInEmployee(null);
//			 	hibernateTemplate.update(e);
					e.get().setProjectIdInEmployee(null);
					Employee ee=employee_JPARepository.save(e.get());
			 	return ee ;			
				}else{
					return null;
				}

				 
			}
			
			
			
			
			
			
			
			
			
			
			
			//---------------------addContactPersonToClient_Controller.java---------------------
			@Override
			public Client InsertContactPersonInClient(String clientId,ContactPerson ContactPerson ) {
				System.out.println("InsertContactPersonInClient method");
				System.out.println("start inserting new ContactPerson in client in DB"); 
				
				if(ContactPerson.getContactPersonDesignation()==null||ContactPerson.getContactPersonEmail()==null||ContactPerson.getContactPersonName()==null
						||ContactPerson.getContactPersonPhone()==null
						) {
					throw new requiredFields();
				}
					
				
				
				Optional<Client> c=client_JPARepository.findById(clientId );
				
				if(c.isPresent()) {
					List l=c.get().getContactPerson();
					l.add(ContactPerson);
					c.get().setContactPerson(l);
					ContactPerson.setClientIdInContactPerson(c.get());
					Client Client=client_JPARepository.save(c.get());
					return Client;
				}else {
					throw new noMember();
				}
				
			 
			
			
			}
			
 //---------------------------------------------addProjectToClient_Controller

			
			public List<String> checkProjectAssignedToClientOrNot(String projectId){
				System.out.println("checkProjectAssignedToClientOrNot method"); 
				List<String> checkProjectAssignedToClientOrNot= new ArrayList();


				String projectIdOfProjectWhichAlreadyHaveClient=null;
				String projectNameOfProjectWhichAlreadyHaveClient=null;
				String clientIdInProjectOfClientWhichAlreadyHaveProject=null;
				
				
				
//				Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
	// 
//				String sql2="select projectId,projectName,clientIdInProject  from project where projectId=? and clientIdInProject is not null";
//				Query<Object[]> q=(Query<Object[]>) session.createNativeQuery(sql2);
//				q.setParameter(1, projectId);
//				List<Object[]>l=	(List<Object[]>)q.getResultList(); 
				List<Object[]>l=project_JPARepository.checkProjectAssignedToClientOrNot(projectId);

				for(Object[]o:l) {
					for(int i=0;i<o.length;i++) {
						if(i==0) {
							projectIdOfProjectWhichAlreadyHaveClient=(String)o[i];
						}else if(i==1) {
							projectNameOfProjectWhichAlreadyHaveClient=(String)o[i];
						}else if(i==2) {
							clientIdInProjectOfClientWhichAlreadyHaveProject=(String) o[i];
						}
					}
				}

				checkProjectAssignedToClientOrNot.add(projectIdOfProjectWhichAlreadyHaveClient);
				checkProjectAssignedToClientOrNot.add(projectNameOfProjectWhichAlreadyHaveClient);
				checkProjectAssignedToClientOrNot.add(clientIdInProjectOfClientWhichAlreadyHaveProject);
				return projectIdOfProjectWhichAlreadyHaveClient!=null?checkProjectAssignedToClientOrNot:null;
				 
				
			}
			//================================================================================
	 
			
			
			
			
			

			public Client assignProjectToClient(String clientId,String ProjectId ) {
				Optional<Project>project=project_JPARepository.findById(ProjectId);
				Optional<Client>client=client_JPARepository.findById(clientId);
				if(project.isPresent()  &&  client.isPresent()) {
					project.get().setClientIdInProject(client.get());
					Project p=project_JPARepository.save(project.get());
					
					
					return client.get();
				}
				throw new requiredFields();
			}
			

			//----------------------------searchClient_Controller------------------------------
			
			
			// return list,where elements are themself a list of different coloumn of cliet table
			public List<Client> getAllClient(){
				System.out.println("getAllClient method"); 
				List<Client>l=new ArrayList<Client>();
				l=client_JPARepository.findAll();	 
				if(l.size()>0) {
			return l;
				}
				return null;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// return list,where elements are themself a list of different coloumn of Project table(all column) based on matching clientId
			 public List<Object []> getAllProjectForClientId2(String clientId){
				System.out.println("getAllProjectForClientId2 method");
				
				 
				  
				 List<Object []>  qq  =  project_JPARepository.getAllProjectForClientId2(clientId);
				 System.out.println(qq);
				 System.err.println(qq.size()>0);
				 qq.forEach(n->System.out.println(n));
						return qq.size()>0?qq:null;
			  
	}
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 //--------------------------searchClient_Controller----------
			 
			 
				// return list,where elements are themself a list of different coloumn of Employee table( all column)
				
			 public List<Employee> getAllEmployeeEveryColumn( ){
			 				System.out.println("getAllEmployeeEveryColumn method"); 
			 				 
//			 				 List<employee>l= hibernateTemplate.loadAll(employee.class);
			 				 
			 				 List<Employee>l=employee_JPARepository.findAll();  
			 					
			 							return  l.size()>0?l:null;
			 							 
			 	}

			 			
			 
			 
			 
			 
			 
			 
			 
			 

public List<Object[]> getAllEmployeeByEmployeeEmail(String employeeEmail){
	System.out.println("getAllEmployeeByEmployeeEmail method");  
//	 String sql="select employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee from employee where employeeEmail=?";
//		 List<Object[]>l=hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql).setParameter(1, employeeEmail) .getResultList();
	 
	 List<Object[]>l   = employee_JPARepository.getAllEmployeeByEmployeeEmail(employeeEmail); 
				return l.size()>0? l:null; 
}
			 
			 
			 





public Employee getAllEmployeeByEmployeeId(String employeeId1){
System.out.println("getAllEmployeeByEmployeeId method"); 
//employee e=hibernateTemplate.get(employee.class, employeeId1);

Optional<Employee> e=employee_JPARepository.findById(employeeId1); 
return e.isPresent()?e.get():null; 
}
	
		
		




// return list having Employee and Project details based on matching employeeId 
public  List<Object[]> getEmployeeAndProjectByEmployeeId(String employeeId){
	System.out.println("getEmployeeAndProjectByEmployeeId  method"); 
	  
//	 String sql="select  employeeEmail,employeePhone,projectId,projectName,projectDateOfStart,projectDateOfEnd from employee inner join project on projectIdInEmployee=projectId where employeeId=?";
//	 List<Object[]>l=hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql).setParameter(1, employeeId).getResultList();
	 
	 List<Object[]>l= employee_JPARepository. getEmployeeAndProjectByEmployeeId(employeeId);
	  
		return l.size()>0?l:null;
	 
}









// return list,where elements are themself a list of different coloumn of Employee  table based on Employee on bench( all column)
public List<Object[]> getEmployeeOnBench(){
	System.out.println("getEmployeeOnBench method"); 
//		 String sql="select employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee from employee where projectIdInEmployee is null";
//		 List<Object[]>l=hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql).getResultList();
		 List<Object[]>l=employee_JPARepository.	  getEmployeeOnBench();
		 
			
					return l.size()>0? l:null;
		 
		  
}



//----------------------------searchProject_Controller.java

public List<Project> getAllProjectEveryColumn(){ 
		System.out.println("getAllProjectEveryColumn method"); 
//		List<project> p=hibernateTemplate.loadAll(project.class);
		
		List<Project> p=	project_JPARepository.findAll();
		 
		return p.size()>0?p:null;
}
	



public 	List<Object[]> getAllProjectEveryColumnByProjectId(String projectId){ 
		System.out.println("getAllProjectEveryColumnByProjectId method"); 
//		String sql="select projectId,projectName,projectDateOfStart,projectDateOfEnd,clientIdInProject  from project where projectId=?";
//	List<Object[]>l=(List<Object[]>)	hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql).setParameter(1, projectId).getResultList();

	
	List<Object[]>l=project_JPARepository. getAllProjectEveryColumnByProjectId(projectId);
		 
		
		
		return l.size()>0?l:null;
		 
}





//return list,where elements are themself a list of different coloumn of cliet table(all column) based on projectId


public List<Object[]> getAllClientByProjectId(String projectId){
	System.out.println("getAllClientByProjectId method"); 
//	String sql = "select clientid,clientName,emailClient,clientRelationshaipDate from client inner join project on clientId=clientIdInProject where projectId=?";
//
//	
//	List<Object[]>l=(List<Object[]>)	hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql).setParameter(1, projectId).getResultList();
	 List<Object[]>l=client_JPARepository.getAllClientByProjectId(projectId);
	 

return l.size()>0? l:null; 

	}






//return list,where elements are themself a list of different coloumn( all column) of Employee table based on matching ProjectId

public List<Object[]> getAllEmployeeEveryColumnByProjectId(String projectId){
	System.out.println("getAllEmployeeEveryColumnByProjectId method"); 
	 
//	 String sql="select employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee from employee inner join project on projectIdInEmployee=projectId where projectId=?";
//		List<Object[]>l=(List<Object[]>)	hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql).setParameter(1, projectId).getResultList();
	 List<Object[]>l=employee_JPARepository. getAllEmployeeEveryColumnByProjectId(projectId);
 
		return l.size()>0?l:null;
	 


}



public  Client  getAllClientByClientId(String clientId){
	System.out.println("getAllClientByClientId method"); 
	
	Optional<Client>c=client_JPARepository.findById(clientId);
	
//	client c=hibernateTemplate.get(client.class, clientId);
	 
return c.isPresent()?c.get():null;	
	
	  
}








public List<Object[]> getAllProjectEveryColumnByClientId(String clientId){ 
		System.out.println("getAllProjectEveryColumnByClientId method"); 

//String sql1=" select projectId, projectName,projectDateOfStart,projectDateOfEnd,clientIdInProject from project p inner join client c on p.clientIdInProject=c.clientId where c.clientId=?";
//List<Object[]>l= hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql1).setParameter(1, clientId).getResultList();
		List<Object[]>l=project_JPARepository.getAllProjectEveryColumnByClientId(clientId);
 
	 
	
			return l.size()>0? l:null;
}
  



public List<Object[]> getAllEmployeeEveryColumnByClientId(String clientId) {

	System.out.println("getAllEmployeeEveryColumnByClientId method"); 
//String sql2=" SELECT  employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee   FROM client  INNER JOIN project ON client.clientId = project.clientIdInProject  INNER JOIN employee ON project.projectId = employee.projectIdInEmployee  WHERE client.clientId = ?"; 
//List<Object[]>l= hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql2).setParameter(1, clientId).getResultList();
	List<Object[]>l= employee_JPARepository.getAllEmployeeEveryColumnByClientId(clientId);
System.out.println(l.size()+"size()");
 
	return l.size()>0? l : null;
	 
}
    

//--------------------------------------------Employee_Dashboard_Conroller.java
//return list,where elements are themself a list of different coloumn(all column) of Project table based on matching projectId

	public List<Object[]> getAllProjectEveryColumnByemployeeId(String employeeId){
		System.out.println("getAllProjectEveryColumnByemployeeId method");
 

//String sql1="select projectId, projectName,projectDateOfStart,projectDateOfEnd,clientIdInProject from project p inner join employee e on p.projectId=e.projectIdInEmployee where e.employeeId=?";
//List<Object[]>l= hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql1).setParameter(1, employeeId).getResultList();
		System.err.println(employeeId);
List<Object[]>l=project_JPARepository. getAllProjectEveryColumnByemployeeId(employeeId);

System.err.println(l);
System.err.println(l.size()>0);


return l.size()>0?	l:null;

	}

	//------------------------------update_delete_client_Controller.java----------------------

@Override
public Client updateClient(Client client,String clientId) {
	System.out.println("updateClient method");

//client c=hibernateTemplate.get(client.class, clientId);
	if(client.getClientName()==null||client.getEmailClient()==null|client.getClientRelationshaipDate()==null) {
		throw new requiredFields();
	}
	Optional<Client>c=client_JPARepository.findById(clientId);
	 
if(c.isPresent()) {
//c.setClientID(clientId);
c.get().setClientName(client.getClientName());
c.get().setEmailClient(client.getEmailClient());
c.get().setClientRelationshaipDate(client.getClientRelationshaipDate());
//hibernateTemplate.update(c);
Client cc=client_JPARepository.save(c.get());
return cc;
}
//throw new noMember(); 
return null;
	 
}


public Boolean deleteclient(String clientId) {
	

Optional<Client>cc=client_JPARepository.findById(clientId);
	if(!cc.isPresent()) {
		throw new noMember();
	}
//getting projectId
List<String> projectId=project_JPARepository.getProjectIdForClientId(clientId);

//update project set clientIdInProject=null where clientIdInProject=?
project_JPARepository.updateProject(clientId);

//update employee set projectIdInEmployee=null where projectIdInEmployee=?
for(String p:projectId) {
employee_JPARepository.updateEmployee(p);
}

client_JPARepository.deleteById(clientId);
Optional<Client>c=client_JPARepository.findById(clientId);
if(c.isPresent()) {
	return false;
}else {
	return true;
}

}



//------------------------------update_delete_employee_Controller.java----------------------

public Employee updateEmployee(Employee employee,String employeeId) { 
System.out.println("updateEmployee method");


//employee e=hibernateTemplate.get(employee.class, employeeId);

Optional<Employee>e=employee_JPARepository.findById(employeeId);

if(employee.getEmployeeName()==null||employee.getEmployeeDept()==null
||employee.getEmployeeDOJ()==null||employee.getEmployeeEmail()==null
||employee.getEmployeePhone()==null
		) {
	throw new requiredFields();
}

if(e.isPresent()) {
	 
	e.get().setEmployeeName(employee.getEmployeeName());
	e.get().setEmployeeEmail(employee.getEmployeeEmail());
	e.get().setEmployeeDept(employee.getEmployeeDept());
	e.get().setEmployeePhone(employee.getEmployeePhone());
	e.get().setEmployeeDOJ(employee.getEmployeeDOJ()); 
//	hibernateTemplate.update(e);
	Employee ee=employee_JPARepository.save(e.get());
	return ee;
	
}
 return null;
 
}




public boolean deleteEmployeeByEmployeeId(String employeeId) {
	System.out.println("deleteEmployeeByEmployeeId method");

//	employee e=hibernateTemplate.get(employee.class, employeeId);

Optional<Employee>e=employee_JPARepository.findById(employeeId);
	if(e.isPresent()) {
//		hibernateTemplate.delete(e);
		employee_JPARepository.delete(e.get());
	}else {
		throw new noMember();
	}
	Optional<Employee>em=employee_JPARepository.findById(employeeId);
	return !em.isPresent()?true:false;
	
	}

//

//------------------------------update_delete_project_Controller.java----------------------
public Project updateProject(Project project,String projectId) {
	System.out.println("updateProject method");

	
	
	
	
	//String sql = "update project set  projectId=? ,projectName=? ,projectDateOfStart=?,projectDateOfEnd=?,clientIdInProject=?   where projectId=?";
	
//	project p=hibernateTemplate.get(project.class, projectId);
	Optional<Project>p=project_JPARepository.findById(projectId);
	if(project.getProjectName()==null||project.getStartDate()==null||project.getEndDate()==null) {
		throw new requiredFields();
	}
	
	if(p.isPresent()) { 
		p.get().setProjectName(project.getProjectName());
		p.get().setStartDate(project.getStartDate());
		p.get().setEndDate(project.getEndDate()); 
//	hibernateTemplate.update(p);
		Project pp =project_JPARepository.save(p.get()); 
	return pp;
	}
	 return null;
	
	
}










//delete Project by projectId
public boolean deleteProjectByProjectId(String projectId) {
System.out.println("deleteProjectByProjectId method");
	 
Optional<Project> p=project_JPARepository.findById(projectId);
if(!p.isPresent()) {
	throw new noMember();
}


//update employee set projectIdInEmployee=null where projectIdInEmployee=? 
employee_JPARepository.updateEmployee(projectId); 

	   
project_JPARepository.deleteById(projectId);

Optional<Project> project=project_JPARepository.findById(projectId);
  
return !project.isPresent()?true:false;

}








 }