package com.DBUtility;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public abstract class SqlHelper {
	// 驱动
	public static String driver = "com.mysql.jdbc.Driver";
	// 连接字符
	public static String url = "jdbc:mysql://localhost:3306/novelweb?characterEncoding=utf8&mysqlEncoding=utf8";
	// 账户
	public static String user = "novelweb";
	public static String password = "novel123";
	static ThreadLocal<Statement> stmt=new ThreadLocal<Statement>();
	static ThreadLocal<Connection> conn=new ThreadLocal<Connection>();
	static ThreadLocal<ResultSet> rs = new ThreadLocal<ResultSet>();

	public static Connection  ConnectionDB() {
		Connection connT=null;
	        try {
	            Class.forName(driver); // 反射加载
	            if (null == conn.get()) {
	            	connT = (Connection) DriverManager.getConnection(url, user, password);
	            	conn.set(connT);
	            	return  connT;
	            }else return conn.get();
	        } catch (ClassNotFoundException e) {
	            System.out.println("Sorry,can't find the Driver!");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	        	
	        }
			return null;
	    }
	
		/**
		 * ִ返回insert的自增ID
		 * @param sql
		 * @return
		 */
	 	public static ResultSet executeNonQueryRetuenID(String sql) {
	       try {
	    	   ConnectionDB();
	    	   stmt.set((Statement) conn.get().createStatement());
	           stmt.get().executeUpdate(sql);
	           sql="select LAST_INSERT_ID()";
	           rs.set(SqlHelper.executeQuery(sql));
	       } catch (SQLException err) {
	           err.printStackTrace();
	       }
	       return rs.get();
	   }
	 	/**
	 	 *执行update ,delete,insert
	 	 * @param sql
	 	 * @return
	 	 */
	   public static int executeNonQuery(String sql) {
	       int result = 0;
	       try {
	    	   ConnectionDB();
	    	   stmt.set((Statement) conn.get().createStatement());
	           result = stmt.get().executeUpdate(sql);
	       } catch (SQLException err) {
	           err.printStackTrace();
	       }
	       return result;
	   }

	   /**
	    *执行select
	    * @param sql
	    * @return
	    */
	   public static ResultSet executeQuery(String sql) {
	       try {
	    	   ConnectionDB();
	           stmt.set((Statement) conn.get().createStatement());
	           rs.set((ResultSet) stmt.get().executeQuery(sql));
	       } catch (SQLException err) {
	           err.printStackTrace();
	       }
	      return rs.get();
	   }
	   public static void CloseRs()
	   {
		   try{
			   if(rs.get()!=null)rs.get().close();
			   rs.remove();
		   }catch(SQLException e) {}
	   }
	   public static void CloseStm()
	   {
		   try{
			   if(stmt.get()!=null)stmt.get().close();
			   stmt.remove();
		   }catch(SQLException e) {}
		   
	   }
	   public static void CloseCon()
	   {
		   try{
			   
			   if(conn.get()!=null)conn.get().close();
			   conn.remove();
		   }catch(SQLException e) {}
	   }
	   public static void Close()
	   {
		   CloseRs();
		   CloseStm();
		   CloseCon();
	   }

}
