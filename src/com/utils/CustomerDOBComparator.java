package com.utils;

import java.util.Comparator;
import com.classes.Customer;

public class CustomerDOBComparator implements Comparator<Customer> {
	@Override
	public int compare(Customer c1, Customer c2) {
		System.out.println("in compare :age");
		if( c1.getDob().isBefore(c2.getDob()) )
			return -1;
		if( c1.getDob().isEqual(c2.getDob()))
			return 0;
		return 1;
	}
}
