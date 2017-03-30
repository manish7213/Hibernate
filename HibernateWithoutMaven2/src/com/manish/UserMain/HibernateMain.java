package com.manish.UserMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manish.hibernate.Address;
import com.manish.hibernate.UserDetails;

public class HibernateMain {

	public static void main(String[] args) {


		UserDetails details=new UserDetails();



		//details.setUserId(1);

		//details.setUserId(5);      //we need not set user id if we are setting userid as GenerateValues Annotated....it will auto generate the values
		details.setUserName("Second_User");


		Address homeAddr = new Address();
		homeAddr.setCity("Second_home_city");
		homeAddr.setStreet("Second_home_Street");
		homeAddr.setState("Second_home_state");
		homeAddr.setPincode("Second_home_pincode");

		Address officeAddr=new Address();
		officeAddr.setCity("Second_office_city");
		officeAddr.setStreet("Second_office_Street");
		officeAddr.setState("Second_office_state");
		officeAddr.setPincode("Second_office_pincode");

		//details.setAddress(addr);

		details.getAddresses().add(homeAddr);
		details.getAddresses().add(officeAddr);


		SessionFactory factory=new Configuration().configure().buildSessionFactory();

		Session session=factory.openSession();

		session.beginTransaction();

		session.save(details);


		session.getTransaction().commit();
		session.close();

		//Getting the data(objects)  from databse;

		//open a new session , need not build session factory becz its expensive and persist over different layers and applications

		details =null;

		session = factory.openSession();

		session.beginTransaction();
		
		details=session.get(UserDetails.class, 1);
		
		session.close();

		System.out.println(details.getAddresses().size());






	}

}
