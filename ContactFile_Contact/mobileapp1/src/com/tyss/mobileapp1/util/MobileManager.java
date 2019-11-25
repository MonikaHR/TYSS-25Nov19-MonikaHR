package com.tyss.mobileapp1.util;

import com.tyss.mobileapp1.dao.MobileDAO;
import com.tyss.mobileapp1.dao.MobileDAOImpl;

public class MobileManager {

	private MobileManager() {}


	public static MobileDAO getMobileDAO() {
		return new MobileDAOImpl();
	}
}
