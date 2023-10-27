package com.classes;
import java.time.LocalDate;
import com.enums.ServicePlan;

public class Customer {
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	private int id;
	public static int idCounter;
	private String fName,lName;
	private String email,pass;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	
	static {
		idCounter=1000;
	}
	
	public Customer(String fName, String lName, String email, String pass, double regAmount, LocalDate dob,
			String plan) {
		super();
		this.id = idCounter;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pass = pass;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = ServicePlan.valueOf(plan);
	}

	public Customer(String email) {
		this.email=email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pass=" + pass
				+ ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}
	
	@Override
	public boolean equals(Object anotherObj) {
		if(anotherObj instanceof Customer) {
			return this.email.equals(((Customer)anotherObj).email);
		}
		return false;
	}
}