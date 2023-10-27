package com.enums;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000),NONE(0);
	
	private double planCost;
	private ServicePlan(double planCost) {
		this.planCost=planCost;
	}
	public double getPlans() {
		return planCost;
	}
	public void setPlans(double planCost) {
		this.planCost = planCost;
	}
	
	@Override
	public String toString() {
		return name();
	}
}
