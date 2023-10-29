package com.validations;

import java.time.LocalDate;
import java.util.List;

import com.classes.Customer;
import com.enums.ServicePlan;
import com.exceptions.AmountException;
import com.exceptions.LoginValidation;
import com.exceptions.PlanException;

public class ValidateAll {
	public static Customer allValidations(String fName, String lName, String email, String pass, double regAmount, LocalDate dob, String plan, List<Customer> custList) throws PlanException, AmountException, LoginValidation {
		
		
		ValidationMethods.validatePlan(plan.toUpperCase());
		ValidationMethods.validateAmount(ServicePlan.valueOf(plan),regAmount);
		ValidationMethods.validateEmail(email, custList);
		ValidationMethods.validatePass(pass);
		
		Customer c1=new Customer( fName, lName, email, pass, regAmount, dob,  plan, LocalDate.now() );
		
		return c1;
	}
	 
}
