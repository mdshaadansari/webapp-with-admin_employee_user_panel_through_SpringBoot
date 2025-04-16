package com.example.project3_test.JPARepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.project3_test.model.Project;
//@Repository
public interface project_JPARepository extends JpaRepository<Project, String>{

	@Query(value="SELECT projectId FROM project ORDER BY CAST(SUBSTRING(projectId, 9) AS UNSIGNED) DESC LIMIT 1",nativeQuery = true)
	List<String> getLastProjectIDFromDB();
	
	@Query(value="select projectId from project",nativeQuery=true)
	List <String> findProjectIdBy();
	
	
	@Query(value="select projectId from project",nativeQuery=true)
	List <String> findById();
	
	@Query(value="select projectName from project",nativeQuery=true)
	List<String> findProjectNameBy();

	
	
	@Query(value="select projectId,clientIdInProject,projectName from project",nativeQuery=true)
	List<Object[]> getAllProject();
	
	

	@Query(value="select projectId,clientIdInProject,projectName  from project inner join client on clientIdInProject=clientID where clientIdInProject=?",nativeQuery=true)
	List<Object[]> getAllProjectForClientId(String clientId);
	
	
	@Query(value="select projectId,projectName,clientIdInProject  from project where projectId=? and clientIdInProject is not null",nativeQuery=true)
	List<Object[]> checkProjectAssignedToClientOrNot(String projectId);
	
	@Query(value="select projectId,projectName,projectDateOfStart,projectDateOfEnd,clientIdInProject  from project inner join client on clientIdInProject=clientId where clientId=?",nativeQuery=true)
	List<Object[]> getAllProjectForClientId2(String clientId);
	
	
	
	@Query(value="select projectId,projectName,projectDateOfStart,projectDateOfEnd,clientIdInProject  from project where projectId=?",nativeQuery=true) 
	List<Object[]> getAllProjectEveryColumnByProjectId(String projectId);
	
	

	@Query(value="select projectId  from project inner join client on clientIdInProject=clientID where clientIdInProject=?",nativeQuery=true)
	List<String> getProjectIdForClientId(String clientId);
	
	@Modifying
	@Transactional
	@Query(value="update project set clientIdInProject=null where clientIdInProject=?",nativeQuery=true)
	int updateProject(String clientId2);
	
	
	@Query(value=" select projectId, projectName,projectDateOfStart,projectDateOfEnd,clientIdInProject from project p inner join client c on p.clientIdInProject=c.clientId where c.clientId=?",nativeQuery=true)
	List<Object[]> getAllProjectEveryColumnByClientId(String clientId);
	
	
	
	@Query(value="select projectId, projectName,projectDateOfStart,projectDateOfEnd,clientIdInProject from project p inner join employee e on p.projectId=e.projectIdInEmployee where e.employeeId=?",nativeQuery=true)
	List<Object[]>getAllProjectEveryColumnByemployeeId(String employeeId);
	
	
	
}
