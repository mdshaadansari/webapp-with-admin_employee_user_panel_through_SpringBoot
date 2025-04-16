package com.example.project3_test.JPARepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.project3_test.model.ContactPerson;  
 //@Repository
public interface contactPerson_JPARepository extends JpaRepository<ContactPerson, Integer>{

	
	@Query(value="select clientIdInContactPerson,contactPersonName,email,phone,designation  from contactPerson inner join client on clientIdInContactPerson=clientId where clientIdInContactPerson=?",nativeQuery=true)
	List<Object[]> getAllContactPersonForClientId(String clientId);
	
	
	
	
	
	@Modifying
	@Transactional
	@Query(value="update contactPerson set clientIdInContactPerson=null where clientIdInContactPerson=?",nativeQuery=true)
	int updatecontactPerson(String clientId2);
	
}
