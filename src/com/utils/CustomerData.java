package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.classes.Customer;

public class CustomerData {
	public static List<Customer> populateCustomers() {
		List<Customer> customers=new ArrayList<>();
		customers.add(new Customer("Shubham","Panwar","shubh@gmail.com","Shubh@12345",2000.0,LocalDate.parse("2000-02-12"),"GOLD",LocalDate.parse("2023-07-06")));
		customers.add(new Customer("Vaishnav","Puram","vaish@gmail.com","Vaish@12345",10000.0,LocalDate.parse("1999-02-12"),"PLATINUM",LocalDate.parse("2023-08-12")));
		customers.add(new Customer("Nikhil","Gaikwad","nikhil@gmail.com","Nikhil@12345",1000.0,LocalDate.parse("1999-02-12"),"SILVER",LocalDate.parse("2023-06-28")));
		customers.add(new Customer("Gaurav","Arudkar","gaurav@gmail.com","Gaurav@12345",1000.0,LocalDate.parse("1997-02-12"),"SILVER",LocalDate.parse("2023-04-23")));
		customers.add(new Customer("Rajat","Kuralkar","rajat@gmail.com","Rajat@12345",2000.0,LocalDate.parse("2002-02-12"),"GOLD",LocalDate.parse("2023-09-10")));
		customers.add(new Customer("Rishikesh","Sankpal","rishi@gmail.com","Rishi@12345",10000.0,LocalDate.parse("2002-02-12"),"PLATINUM",LocalDate.parse("2023-10-07")));
		customers.add(new Customer("Ishan","Omase","ishan@gmail.com","Ishan@12345",5000.0,LocalDate.parse("2003-02-12"),"DIAMOND",LocalDate.parse("2023-03-11")));
		customers.add(new Customer("Shadab","Karim","shadab@gmail.com","Shadab@12345",1000.0,LocalDate.parse("2001-02-12"),"SILVER",LocalDate.parse("2023-09-25")));
		
		return customers;
	}
}
