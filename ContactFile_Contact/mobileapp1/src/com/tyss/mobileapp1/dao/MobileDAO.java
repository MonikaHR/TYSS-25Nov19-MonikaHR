package com.tyss.mobileapp1.dao;

import java.util.List;

import com.tyss.mobileapp1.dto.MobileBean;

public interface MobileDAO {
    public List<MobileBean> getAllContactsData();
	

	public MobileBean searchContactData(String name);

	public int AddContact(MobileBean bean);
	public int deleteContact(String name);
	public int updateContact(MobileBean bean);

}
