package com.example.project3_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.JPARepository.client_JPARepository;
import com.example.project3_test.JPARepository.contactPerson_JPARepository;
import com.example.project3_test.JPARepository.employee_JPARepository;
import com.example.project3_test.JPARepository.project_JPARepository;
import com.example.project3_test.config.AppConfiguration;



@SpringBootApplication 
 
 //@ComponentScan(basePackages={"com.example.project2_test"})
/*
@EntityScan(basePackages = {"com.example.project2_test.model.Client",
		"com.example.project2_test.model.Employee",
		"com.example.project2_test.model.Project",
		"com.example.project2_test.model.ContactPerson"}) 
 @EnableJpaRepositories(basePackages  ="com.example.project2_test.JPARepository")
 */ 
public class MySpringBootApplication implements CommandLineRunner{
	@Autowired 
	DAOInterface2 DAOImpl2;	
	
	@Autowired 
	client_JPARepository client_JPARepository;
	
	@Autowired 
	 contactPerson_JPARepository contactPerson_JPARepository;
	  
	 @Autowired 
	 employee_JPARepository employee_JPARepository;
	  
	 @Autowired 
	 project_JPARepository project_JPARepository;
	 @Autowired  
	 AppConfiguration AppConfiguration;
	 static ApplicationContext ctx;
	public static void main(String a[]) {
		System.err.println("starting MySpringBootApplication");
		System.err.println("YES, ,,,starting MySpringBootApplication");
 ApplicationContext ctx=	 SpringApplication.run(MySpringBootApplication.class, a); 
//ViewResolver v=(ViewResolver)ctx.getBean(ViewResolver.class);

//System.err.println("ViewResolver\t-"+v);
		System.err.println("end starting MySpringBootApplication");
		System.err.println("YES,,, ,,end starting MySpringBootApplication");
	}
	
	
	 
	public void run(String... args) throws Exception {
		System.err.println("in run method");
		  
			System.err.println(DAOImpl2);
			System.err.println(client_JPARepository);
			System.err.println(contactPerson_JPARepository);
			System.err.println(employee_JPARepository);
			System.err.println(project_JPARepository);
			System.err.println("configuration class where we have viewresolver\t"+AppConfiguration);
	 
	}

}
