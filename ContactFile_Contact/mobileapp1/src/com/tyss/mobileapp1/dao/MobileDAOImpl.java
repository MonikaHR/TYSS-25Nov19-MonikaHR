package com.tyss.mobileapp1.dao;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tyss.mobileapp1.dto.MobileBean;

public class MobileDAOImpl implements MobileDAO{
	
	public List<MobileBean> getAllContactsData() {
		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "select * from contact";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			

			conn = DriverManager.getConnection(url);

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			ArrayList<MobileBean> result = new ArrayList<MobileBean>();

			while(rs.next()) {
				MobileBean bean = new MobileBean();
				String name = rs.getString("name");
				bean.setName(name);
				int number = rs.getInt("number");
				bean.setNumber(number);
				String contact_group = rs.getString("contact_group");
				bean.setContact_group(contact_group);
				

				result.add(bean);
			}            //While
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}        //end of  select
	
	
	
	public MobileBean searchContactData(String name) {

		String  url ="jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String  sql = "select * from contact where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				MobileBean bean = new MobileBean();
				bean.setName(rs.getString("name"));
				bean.setNumber(rs.getInt("number"));
				bean.setContact_group(rs.getString("contact_group"));
				
				return bean;
			}  else {
				return null;
			}
					} catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}         //end of search


	public int AddContact(MobileBean bean) {
		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "insert into contact values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getNumber());
			pstmt.setString(3, bean.getContact_group());

			int j = pstmt.executeUpdate();
			return j;
			

		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}

		}//end of try-catch-finally

	}//end of insertContact
	
	public int deleteContact(String name) {
			String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
			String sql = "delete from contact where name = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url);
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, name);
				
				int m = pstmt.executeUpdate();
				return m;
				
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}
			finally {
				try {
					if(conn!=null) {
						conn.close();
					}if(pstmt!=null) {
						pstmt.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}//end of deleteContactData
	
	public int updateContact(MobileBean bean) {
		String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=root";
		String sql = "update contact set number=? where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getName());	
			pstmt.setInt(2, bean.getNumber());
			pstmt.setString(3, bean.getContact_group());
			int count9 = pstmt.executeUpdate();
			return count9;

		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}if(pstmt!=null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}//end of updateContact
	

}