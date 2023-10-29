package com.tester;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.classes.Customer;
import com.enums.*;
import com.utils.CustomerDOBComparator;
import com.utils.CustomerData;
import com.validations.ValidateAll;
import com.validations.ValidationMethods;

public class TesterCustomer {
	public static void main(String[] args)  {
		try(Scanner sc=new Scanner(System.in)){
			
			int ch=1;
			List<Customer> custList=CustomerData.populateCustomers();
			
			while(ch!=0) {

				System.out.println("\n\nSelect 1.SignUp 2.SignIn 3.Change Password 4.Unsubscribe 5.Display All customer 0.Exit");
				System.out.println("For Sorting Select 6.On Email 7.On DOB 8.On DOB & LName");
				System.out.println("9.To Show Customer with Expired Plan");
				System.out.print("Enter Choice: ");
				ch=sc.nextInt();
				
				try {
					switch(ch) {
					case 1:
						System.out.println("Sign Up...\n");
						
						System.out.print("Enter First Name :");
						String fName=sc.next();
						System.out.print("Enter Last Name :");
						String lName=sc.next();
						System.out.print("Enter email :");
						String email=sc.next();
						System.out.print("Enter password :");
						String pass=sc.next();
						System.out.print("Enter Date of Birth(yyyy-mm-dd) :");
						String dob=sc.next();
						System.out.println("Types of plans :");
						for(ServicePlan a:ServicePlan.values()) {
							System.out.print(a+" "+a.getPlans()+"  ");
						}
						System.out.print("\nEnter Plan :");
						String plan=sc.next().toUpperCase();
						System.out.print("Enter Registration Amount :");
						Double regAmount=sc.nextDouble();
							
						custList.add(ValidateAll.allValidations(fName,lName,email,pass,regAmount,LocalDate.parse(dob),plan,custList));
						
						break;
					case 2:
						System.out.println("Sign In...\n");
						System.out.println("Enter Email : ");
						System.out.println("Enter password : ");
						
						ValidationMethods.validateLogin(sc.next(), sc.next(), custList);
						
						System.out.println("Email and Password Validation Succesful...");
						
						break;
					case 3:
						System.out.println("Change Password\n");
						System.out.print("Enter Email : ");
						String mail=sc.next();
						System.out.println("Enter Old Password");
						ValidationMethods.validateLogin(mail, sc.next(), custList);
						System.out.println("Enter New Password");
						String nPass=sc.next();
						ValidationMethods.validatePass(nPass);
						custList.get(custList.indexOf(new Customer(mail))).setPass(nPass);
						break;
					case 4:
						System.out.println("Unsubscribe...\n");
						System.out.println("Enter Email : ");
						mail=sc.next();
						int id=custList.indexOf(new Customer(mail));
						custList.get(id).setPlan(ServicePlan.NONE);
						custList.get(id).setRegAmount(0);
						
						break;
					case 5:
						System.out.println("All Customers\n");
						for(Customer a: custList) {
							System.out.println(a);
						}
						
						break;
					case 6:
						System.out.println("Sorting on basis of email...");		//natural ordering
						Collections.sort(custList);
						break;
					case 7:
						System.out.println("Sorting as per date of birth...");		//custom ordering
						Collections.sort(custList,new CustomerDOBComparator());
						break;
					case 8:
						System.out.println("Sorting as per D.O.B and last name...");		//anonymous inner class
						
						Collections.sort(custList,new Comparator<Customer>() {
							@Override
							public int compare(Customer c1,Customer c2) {
								System.out.println("In compare : DOB & lName");
								int ret=c1.getDob().compareTo(c2.getDob());
								if(ret == 0) {
									int res=c1.getlName().compareTo(c2.getlName());
									if(0<res)
										return 1;
									if(0==res)
										return 0;
									return -1;
								}
								return ret;
							}
						});
						
						break;
					case 9:
						for(Customer c:custList) {
							Period p=Period.between(c.getLastSubscriptionPaidDate(), LocalDate.now());
							if(p.getMonths() >= 3) {
								System.out.println(c);
							}
						}
						break;
					case 0:
						System.out.println("Exit");
						break;
					default:
						System.out.println("Enter Correct Choice");
						
						break;
					}
					
				} catch(Exception e) {
					System.out.println(e);
				}
				
			}
			
			
			
		}
	}

}