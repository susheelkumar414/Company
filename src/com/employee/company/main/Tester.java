package com.employee.company.main;

import com.employee.company.dao.EmployeeDAO;
import com.employee.company.dto.EmployeeDTO;

public class Tester {
	
	public static void main(String[] args) {
		
		System.out.println("main method started");
		
		EmployeeDTO edto=new EmployeeDTO();
		
		edto.setId(1);
		edto.setEmpName("DEF");
		edto.setEmpId("DEF123");
		edto.setEmpSalary(30000);
		
		
		EmployeeDAO edao=new EmployeeDAO();
		//edao.create(edto);//creating data in database
		//edao.getEmployee(3);//getting dto object from database
		//edao.update("GHI123",3 );
		edao.delete(1);

		System.out.println("main method ended");


	}

}
