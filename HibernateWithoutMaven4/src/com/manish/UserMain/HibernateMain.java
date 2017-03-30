package com.manish.UserMain;

/* This Project demonstrates the OneToMany and ManyToOne with scenario when third table need not be created combinnig vehicle and user*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manish.hibernate.UserDetails;
import com.manish.hibernate.Vehicle;

public class HibernateMain {

	public static void main(String[] args) {


		UserDetails user=new UserDetails();
		Vehicle vehicle1=new Vehicle();
		Vehicle vehicle2=new Vehicle();


		//user.setUserId(1);

		//user.setUserId(5);      //we need not set user id if we are setting userid as GenerateValues Annotated....it will auto generate the values
		user.setUserName("First_User");
		
		vehicle1.setVehicleName("Car");
		vehicle2.setVehicleName("Jeep");
		
		vehicle1.setUser(user);
		
		vehicle2.setUser(user);
		
		user.getVehicles().add(vehicle1);
		user.getVehicles().add(vehicle2);

		SessionFactory factory=new Configuration().configure().buildSessionFactory();

		Session session=factory.openSession();

		session.beginTransaction();

		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);


		session.getTransaction().commit();
		session.close();

		



	}

}
