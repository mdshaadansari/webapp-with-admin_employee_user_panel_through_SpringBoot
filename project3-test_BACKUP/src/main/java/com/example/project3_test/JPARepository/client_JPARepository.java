package com.example.project3_test.JPARepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.project3_test.model.Client;  
//@Repository
public interface client_JPARepository extends JpaRepository<Client, String>{

	//===================for admin==================================
	
		 @Query(value="select adminEmail,adminName from admin where adminEmail=?",nativeQuery=true)
		public List<Object[]> checkAdminEmail(String email);
		//=================================================================================================================

	
 
@Query(value = "select emailClient,ClientName,clientId from client where emailClient=?" ,nativeQuery = true)
	public List<Object[]> checkClientEmail(String email);
	 
	
	@Query(value= "SELECT clientId FROM client ORDER BY CAST(SUBSTRING(clientId, 8) AS UNSIGNED) DESC LIMIT 1",nativeQuery=true)
	 List<String>  getLastClientIDFromDB();
	
	
	@Query(value="select clientId from client",nativeQuery=true)
	List<String> findClientIDBy();
	

	@Query(value="select clientName from client",nativeQuery=true)
	List<String> findClientNameBy();
	
	
	@Query(value="select clientid,clientName,emailClient,clientRelationshaipDate from client inner join project on clientId=clientIdInProject where projectId=?",nativeQuery=true)
	List<Object[]> getAllClientByProjectId(String projectId);
}
