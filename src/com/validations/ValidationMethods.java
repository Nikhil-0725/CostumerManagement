package com.validations;
import java.util.List;
import java.util.regex.Pattern;

import com.classes.Customer;
import com.enums.ServicePlan;
import com.exceptions.AmountException;
import com.exceptions.LoginValidation;
import com.exceptions.PlanException;

public class ValidationMethods {
	public static void validatePlan(String plan) throws PlanException {
		boolean flag=false;
		for(ServicePlan a:ServicePlan.values()) {
			if(a.toString().equals(plan)) {
				flag=true;
			}
		}
		if(!flag) {
			throw new PlanException("You have not selected proper plan...");
		}
	}
	
	public static void validateAmount(ServicePlan plan, double amount) throws AmountException {
		if(plan.getPlans()!=amount) {
			throw new AmountException("Your Plan Amount Does Not Match");
		}
		
	}
	
	public static void validateEmail(String email, List<Customer> custList) throws LoginValidation {
		String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//		System.out.println(Pattern.compile(regexPattern).matcher(email).matches());
		if(!(Pattern.compile(regexPattern).matcher(email).matches())) // OR  (!email.matches(regexPattern))
			throw new LoginValidation("Enter Valid Password.");
		
//		Customer c1=new Customer(email);
		if(custList.contains(new Customer(email)))
			throw new LoginValidation("Duplicate Email");
	}
	
	
//	(?=.*[0-9]) represents a digit must occur at least once.
//	(?=.*[a-z]) represents a lower case alphabet must occur at least once.
//	(?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
//	(?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
//	(?=\\S+$) white spaces don’t allowed in the entire string.
//	{8,20} represents at least 8 characters and at most 20 characters.
	
	public static void validatePass(String pass) throws LoginValidation {
		String regexPattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
//		System.out.println(Pattern.compile(regexPattern).matcher(pass).matches());
		if(!(Pattern.compile(regexPattern).matcher(pass).matches()))		//	OR (!email.matches(regexPattern))
			throw new LoginValidation("Enter Valid Password.");
	}
	
	public static void validateLogin(String email, String pass,List<Customer> custList) throws LoginValidation {
		Customer c1=new Customer(email);
		int id=custList.indexOf(c1);
		if(!custList.contains(c1))
			throw new LoginValidation("Wrong Email Entered");
		if(!(pass.equals(custList.get(id).getPass()))) 
			throw new LoginValidation("Wrong Password Entered");
	}

}