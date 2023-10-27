package com.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.classes.Customer;
import com.enums.*;
import com.validations.ValidateAll;
import com.validations.ValidationMethods;

public class TesterCustomer {
	public static void main(String[] args)  {
		try(Scanner sc=new Scanner(System.in)){
			
			int ch=1;
			List<Customer> custList=new ArrayList<>();
			
			while(ch!=0) {

				System.out.println("\n\nSelect 1.SignUp 2.SignIn 3.Change Password 4.Unsubscribe 5.Display All customer 0.Exit");
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
						
						
						break;
					case 5:
						System.out.println("All Customers\n");
						for(Customer a: custList) {
							System.out.println(a);
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