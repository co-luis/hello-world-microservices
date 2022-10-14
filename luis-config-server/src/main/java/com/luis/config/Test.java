package com.luis.config;
import java.util.*;
import java.util.stream.Collectors;


/*
 * Write a program to store employees record with following data points by using Java Collection Object
	EmpId
	EmpName
	EmpCity
	EmpCountry
	EmpSalary
	EmpDepratmentName
	
1. Sort the employees record by employee name
2. Filter the employee records based upon the name starting with A
3. Calculate the total salary of all the employees by using Java8 functional programming

 */

class Employee implements Comparable<Employee>{
	private String empId;
	private String empName;
	private int empSalary;
	public Employee() {
		
	}
	
	public Employee(String empId, String empName, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public String getEmpName() {
		return this.empName;
	}
	public int getEmpSalary() {
		return this.empSalary;
	}

	@Override
	public int compareTo(Employee o) {
		return empName.compareTo(o.getEmpName());
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
}

public class Test {
	
	public static void main(String [] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("1","Ben",150));
		employeeList.add(new Employee("2","Allan",100));
		employeeList.add(new Employee("2","Alice",500));

		Collections.sort(employeeList);
		employeeList.forEach(i->System.out.println(i.toString()));
		int[] totalSalary = {0};
		List<Employee> newList = employeeList.stream().filter(e->{return e.getEmpName().startsWith("A");}).collect(Collectors.toList());
		
		newList.forEach(i->System.out.println(i.toString()));

		employeeList.forEach(e->{
			totalSalary[0]+= e.getEmpSalary();
		});
		
		System.out.println("totalSalary="+totalSalary[0]);
	}

}
