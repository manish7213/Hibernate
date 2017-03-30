package com.manish.UserMain;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manish.hibernate.Address;
import com.manish.hibernate.UserDetails;

public class HibernateMain {

	public static void main(String[] args) {


		UserDetails details=new UserDetails();
		Address homeAddr = new Address();
		Address officeAddr=new Address();

		details.setUserId(1);

		//details.setUserId(5);      //we need not set user id if we are setting userid as GenerateValues Annotated....it will auto generate the values
		details.setUserName("First_User");

		details.setDescription("First description");
		details.setJoinedDate(new Date());
		
		homeAddr.setCity("First_home_city");
		homeAddr.setStreet("First_home_Street");
		homeAddr.setState("First_home_state");
		homeAddr.setPincode("First_home_pincode");
		
		
		officeAddr.setCity("First_office_city");
		officeAddr.setStreet("First_office_Street");
		officeAddr.setState("First_office_state");
		officeAddr.setPincode("First_office_pincode");
		
		//details.setAddress(addr);
		
		details.setHomeAddress(homeAddr);
		details.setOfficeAddress(officeAddr);
		

		SessionFactory factory=new Configuration().configure().buildSessionFactory();

		Session session=factory.openSession();

		session.beginTransaction();

		session.save(details);


		session.getTransaction().commit();
		//session.close();

		//Getting the data(objects)  from databse;

		//open a new session , need not build session factory becz its expensive and persist over different layers and applications

		/*details =null;

		session = factory.openSession();

		session.beginTransaction();



		details=session.get(UserDetails.class, 5);

		System.out.println("User "+details.getUserId()+" has name "+details.getUserName()+" description is "+details.getDescription()+" address is "+details.getAddress());
		 */







	}

}
