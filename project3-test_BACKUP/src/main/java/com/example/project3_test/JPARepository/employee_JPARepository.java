package com.example.project3_test.JPARepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.project3_test.model.Employee;
//@Repository
public interface employee_JPARepository extends JpaRepository<Employee, String>{

	
	//===================employeeLogin.jsp and url fired from employeeLogin.jsp for servlets==================================
	
	
@Query(value = "select employeeEmail,employeeName,employeeId from employee where employeeEmail=?" ,nativeQuery = true)
	public List<Object[]> checkEmployeeEmail(String email);
	
	
 @Query(value="select * from employee where employeeEmail=?",nativeQuery=true)
	List<Employee> findByEmployeeEmail(String email);
	
	
	
	@Query(value =  "SELECT employeeId FROM employee ORDER BY CAST(SUBSTRING(employeeId, 5) AS UNSIGNED) DESC LIMIT 1",nativeQuery = true)
	 List<String> getLastEmpoyeeIDFromDB();
	
	@Query(value="select employeeId from employee",nativeQuery=true)
	List<String> findEmployeeIdBy();
	
	@Query(value="select ProjectIdInEmployee from employee",nativeQuery=true)
	List<String> findProjectIdInEmployeeBy();
	
	@Query(value="select EmployeeName from employee",nativeQuery=true)
	List<String> findEmployeeNameBy();
	
	@Query(value="select EmployeeDept from employee",nativeQuery=true)
	List<String> findEmployeeDeptBy();
 
	
	
	@Query(value="select employeeId,projectIdInEmployee,employeeName,employeeDept  from employee inner join project on projectIdInEmployee=projectId where projectIdInEmployee=?",nativeQuery=true)
	List<Object[]> getAllEmployeeForProjectId(String projectId);
	
	
	
	@Query(value="select employeeName,employeeId,projectIdInEmployee  from employee where employeeId=? and projectIdInEmployee is not null",nativeQuery=true)
	List<Object[]> checkEmployeeOnBenchOrNot(String employeeId);
	
	@Query(value="select employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee from employee inner join project on projectIdInEmployee=projectId where projectId=?",nativeQuery=true)
	List<Object[]> getAllEmployeeEveryColumnByProjectId(String projectId);
	
	
	@Query(value="select  employeeEmail,employeePhone,projectId,projectName,projectDateOfStart,projectDateOfEnd from employee inner join project on projectIdInEmployee=projectId where employeeId=?",nativeQuery =true)
	List<Object[]>getEmployeeAndProjectByEmployeeId(String employeeId);
	
	
	@Query(value="select employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee from employee where projectIdInEmployee is null",nativeQuery=true)
	List<Object[]>getEmployeeOnBench();
	

	@Query(value="select employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee from employee where employeeEmail=?",nativeQuery=true)
	List<Object[]> getAllEmployeeByEmployeeEmail(String employeeEmail);
	
	
	

	@Modifying
	@Transactional
	@Query(value="update employee set projectIdInEmployee=null where projectIdInEmployee=?",nativeQuery=true)
	int updateEmployee(String projectId);
	
	
	
	
	
	@Query(value=" SELECT  employeeId,employeeName,employeeDept,employeeEmail,employeePhone,employeeDOJ,projectIdInEmployee   FROM client  INNER JOIN project ON client.clientId = project.clientIdInProject  INNER JOIN employee ON project.projectId = employee.projectIdInEmployee  WHERE client.clientId = ?",nativeQuery=true)
	List<Object[]>getAllEmployeeEveryColumnByClientId(String clientId);
	
	
	
}
