package com.DBUtility;

import java.sql.SQLException;

import com.bean.AuthorBean;
import com.bean.Man;
import com.bean.UserBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class SqlLogin {

	/**
	 * 根据user返回对应的Man
	 * @param Man
	 * @return 
	 */
	public Man CheckLogin(Man user,String man) {
		PreparedStatement stam = null;
		if(man.equals("reader"))
		{
			try {
				Connection con=SqlHelper.ConnectionDB();
				stam = (PreparedStatement) con.prepareStatement(
						"select * from  reader  where username=? and password=?;");
				stam.setString(1, user.getUserName());
				stam.setString(2, user.getPwd());
				ResultSet rs=(ResultSet) stam.executeQuery();
				if(rs.next())
				{
					UserBean user1=new UserBean(user);
					user1.setBirthday(rs.getDate("Birthday"));
					user1.setReaderName(rs.getString("ReaderName"));
					user1.setId(rs.getInt("ReaderID"));
					user1.setSex(rs.getString("Sex"));
					user1.setLastLoginTime(rs.getString("LastLoginTime"));
					user1.setNickName(rs.getString("NickName"));
					user1.setStatus(rs.getString("Status"));
					return user1;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				SqlHelper.Close();
			}
		}else{
			try {
				Connection con=SqlHelper.ConnectionDB();
				stam = (PreparedStatement) con.prepareStatement(
						"select * from  "+man+"  where username=? and password=?;");
				stam.setString(1, user.getUserName());
				stam.setString(2, user.getPwd());
				ResultSet rs=(ResultSet) stam.executeQuery();
				if(rs.next())
				{
					AuthorBean user1=new AuthorBean(user);
					user1.setAuthorID(rs.getInt("AuthorID"));
					user1.setAuthorName(rs.getString("AuthorName"));
					user1.setBirthday(rs.getDate("Birthday"));
					user1.setSex(rs.getString("Sex"));
					user1.setLastLoginTime(rs.getString("LastLoginTime"));
					user1.setStatus(rs.getString("Status"));
					return user1;
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					SqlHelper.Close();
				}
		}
		return null;
	}
}
