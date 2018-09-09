package com.employee.company.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.employee.company.dto.EmployeeDTO;
import com.hibernate.utility.SingletonFactory;

public class EmployeeDAO {
	
	SessionFactory factory=SingletonFactory.getSessionFactory();

	public EmployeeDAO() {
		System.out.println("EmployeeDAO Object created");
	}
	
	public void create(EmployeeDTO edto) {
		
		System.out.println("create method started");
		
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(edto);
		
		tx.commit();
		
		session.close();
		factory.close();
		
		System.out.println("create method ended");

	}

	public void getEmployee(int id) {
		
		System.out.println("getEmployee method started");
		
		EmployeeDTO dtoFromDB = null;
		Session session = factory.openSession();
		try {
			
		dtoFromDB=session.get(EmployeeDTO.class, id);
			if(dtoFromDB!=null) {

				System.out.println("EmployeeDetails\n"+dtoFromDB);
			}
			else {
				System.out.println("No record found with id(pk)"+id);
			}
		
		}
		catch(HibernateException e) {
			
			System.out.println("Exception occured while fetching the employee data");
		
		}
		finally {
			session.close();
		}
		
			
		}
	public void update(String name,int id) {
		
		System.out.println("update method started");
		
		EmployeeDTO dtoFromDB=null;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			dtoFromDB=session.get(EmployeeDTO.class, id);
			if(dtoFromDB!=null) {
				
				System.out.println("EmployeeDeatailsFom DB"+dtoFromDB);
				dtoFromDB.setEmpName(name);
				session.update(dtoFromDB);
				tx.commit();
				
			}
			else {
				System.out.println("No Record found with id(PK)"+id);
			}
			
			}
		catch(HibernateException e){
			
			System.out.println("Exception occured");
			tx.rollback();
			
		}
		finally {
			session.close();
		}
		System.out.println("update menthod ended");
		
	}
	
	public void delete(int id) {
		

		
		System.out.println("delete method started");
		
		EmployeeDTO dtoFromDB=null;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			dtoFromDB=session.get(EmployeeDTO.class,id);
			if(dtoFromDB!=null) {
				
				System.out.println("EmployeeDeatailsFom DB"+dtoFromDB);
				//dtoFromDB.setEmpId(name);
				session.delete(dtoFromDB);
				tx.commit();
				
			}
			else {
				System.out.println("No Record found with id(PK)"+id);
			}
			
			}
		catch(HibernateException e){
			
			System.out.println("Exception occured");
			tx.rollback();
			
		}
		finally {
			session.close();
		}
		System.out.println("delete menthod ended");
		
	
		
	}

	
}

