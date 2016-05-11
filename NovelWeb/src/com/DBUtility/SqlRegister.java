package com.DBUtility;

import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bean.Man;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SqlRegister {
	/**
	 * 检测用户名是否存在
	 * @param user
	 * @param man
	 * @return
	 */
	public boolean CheckNameExistByName(Man user, String man) {
		PreparedStatement stam = null;
		try {
			Connection con = SqlHelper.ConnectionDB();
			stam = (PreparedStatement) con.prepareStatement("select * from "
					+ man + "  where username=?;");
			stam.setString(1, user.getUserName());
			boolean b = stam.executeQuery().first();
			return b;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public boolean Register(Man user, String man) {
		String sql=null;
		String d=new java.util.Date().toLocaleString();
		if(man.equals("reader"))
		{
			sql=String.format("insert into reader "
					+ "(ReaderName,NickName,Sex,Status,Birthday,LastLoginTime,username,password) "
					+ "values ('%s','%s','保密','enable','1954-10-1','"+d+"','%s','%s');",
					user.getUserName(),user.getUserName(),user.getUserName(),user.getPwd());
		}else
		{
			sql=String.format("insert into "
					+ "author (AuthorName,Sex,Status,Birthday,LastLoginTime,username"
					+ ",password) values ('%s','保密','enable','1954-10-1','"+d+"','%s','%s');",
					user.getUserName(),user.getUserName(),user.getPwd());
		}
		boolean b = SqlHelper.executeNonQuery(sql) == 1;
		SqlHelper.Close();
		return b;
	}
}
