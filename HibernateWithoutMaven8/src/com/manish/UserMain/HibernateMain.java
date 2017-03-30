package com.manish.UserMain;

/* This Project demonstrates the  INHERITANCE  ,TABLE PER CLASS strategy,  Means separate table are created for each parent and child classes,
 * and since tables are separated we don't need Discriminator column. All the tables that we get is well normalised unlike single table strategy becz single table strategy 
 * contains abundant of NULL column values so recommended over single table strategy(Default inheritance strategy) */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.manish.hibernate.FourWheeler;
import com.manish.hibernate.TwoWheeler;
import com.manish.hibernate.Vehicle;

public class HibernateMain {

	public static void main(String[] args) {


		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("bike");
		bike.setSteeringHandle("bike steeringHandle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("porsche");
		car.setSteeringWheel("porsche steeringWheel");
		
		

		SessionFactory factory=new Configuration().configure().buildSessionFactory();

		Session session=factory.openSession();

		session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		

		session.getTransaction().commit();
		session.close();

		



	}

}
