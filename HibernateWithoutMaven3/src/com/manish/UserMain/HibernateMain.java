package com.manish.UserMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manish.hibernate.UserDetails;
import com.manish.hibernate.Vehicle;

public class HibernateMain {

	public static void main(String[] args) {


		UserDetails user=new UserDetails();
		Vehicle vehicle=new Vehicle();


		//user.setUserId(1);

		//user.setUserId(5);      //we need not set user id if we are setting userid as GenerateValues Annotated....it will auto generate the values
		user.setUserName("First_User");
		
		vehicle.setVehicleName("Car");
		
		user.setVehicle(vehicle);

		SessionFactory factory=new Configuration().configure().buildSessionFactory();

		Session session=factory.openSession();

		session.beginTransaction();

		session.save(user);
		session.save(vehicle);


		session.getTransaction().commit();
		session.close();

		



	}

}
