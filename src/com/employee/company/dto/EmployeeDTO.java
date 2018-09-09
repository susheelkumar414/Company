package com.employee.company.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EmployeeDetails")
public class EmployeeDTO implements Serializable {
	
	
	public EmployeeDTO() {
		System.out.println("Employee Object created");
	}
	@Id
	@GenericGenerator(name="myid",strategy="increment")
	@GeneratedValue(generator="myid")
	@Column(name="e_id")
	private int id;

	@Column(name="e_name")
	private String empName;
	
	@Column(name="e_sal")
	private double empSalary;
	
	@Column(name="e_empId")
	private String empId;
	
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", empName=" + empName + ", empSalary=" + empSalary + ", empId=" + empId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
}
