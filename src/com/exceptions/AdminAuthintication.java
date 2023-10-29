package com.exceptions;

import com.classes.Admin;

public class AdminAuthintication {
	public static boolean authanticateAdmin(String mail, String pass) {
		if(mail.equals(Admin.adminUserName) && pass.equals(Admin.password))
			return true;
		return false;
	}
}
