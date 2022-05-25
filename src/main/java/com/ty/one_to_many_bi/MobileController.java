package com.ty.one_to_many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MobileController {
    public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setCost(14000);
		mobile.setName("samsung");
		
		Sim sim1 = new Sim();
		sim1.setImei(262626262l);
		sim1.setMobile(mobile);
		sim1.setProvider("airtel");
		sim1.setType("4-g");
		
		Sim sim2 = new Sim();
		sim2.setImei(1234566l);
		sim2.setMobile(mobile);
		sim2.setProvider("jio");
		sim2.setType("3-g");
		
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		
		mobile.setSims(sims);
		
		entityTransaction.begin();
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(mobile);
		entityTransaction.commit();
		
		System.out.println("---------------------done-----------------------------");
	}
}
