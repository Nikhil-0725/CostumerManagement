package com.classes;
import java.time.LocalDate;
import com.enums.ServicePlan;

public class Customer implements Comparable<Customer> {
	
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

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
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

	public LocalDate getLastSubscriptionPaidDate() {
		return lastSubscriptionPaidDate;
	}

	private int id;
	public static int idCounter;
	private String fName,lName;
	private String email,pass;
	private double regAmount;
	private LocalDate dob,lastSubscriptionPaidDate;
	private ServicePlan plan;
	
	static {
		idCounter=1000;
	}
	
	public Customer(String fName, String lName, String email, String pass, double regAmount, LocalDate dob,
			String plan, LocalDate lastSubscriptionPaidDate) {
		super();
		this.id = idCounter;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pass = pass;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = ServicePlan.valueOf(plan);
		this.lastSubscriptionPaidDate=lastSubscriptionPaidDate;
	}

	public Customer(String email) {
		this.email=email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pass=" + pass
				+ ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + ", lastSubscriptionPaidDate=" + lastSubscriptionPaidDate + "]";
	}
	
	@Override
	public boolean equals(Object anotherObj) {
		if(anotherObj instanceof Customer) {
			return this.email.equals(((Customer)anotherObj).email);
		}
		return false;
	}
	
	@Override
	public int compareTo(Customer anotherCustomer) {		// to override compareTo must implement Comparable<T>
		System.out.println("Inside compareTo");
		return this.email.compareTo(((Customer)anotherCustomer).email);
	}
}
