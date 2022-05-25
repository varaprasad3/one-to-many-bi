package com.ty.one_to_many_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HospitalController {
    public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital = new Hospital();
		hospital.setName("apollo");
		hospital.setGstnum(23242342l);
		hospital.setWebsite("www.apollo.com");
		
		Branch branch = new Branch();
		branch.setHospital(hospital);
		  branch.setName("rajajinagar");
		branch.setPhno(6309326176l);
		branch.setAddress("nanana nagar");
		
		Branch branch1 = new Branch();
		branch1.setHospital(hospital);
		branch1.setName("rajajinagar");
		branch1.setPhno(6309326176l);
		branch1.setAddress("nanana nagar");
		
		entityTransaction.begin();
		entityManager.persist(branch);
		entityManager.persist(branch1);
		entityManager.persist(hospital);
		entityTransaction.commit();
		
		System.out.println("-----------------done-----------------------");
		
		
	}
}
