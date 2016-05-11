package com.DBUtility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.bean.NovelBean;
import com.bean.OrderBean;
import com.bean.OrderDetailBean;
import com.mysql.jdbc.ResultSet;

/**
 * 订单
 * @author zhangyi
 *
 */
public class SqlOrder {

	public boolean insertList(ArrayList<NovelBean> ShoppingCar,int SessionReaderID) throws SQLException
	{
		int ReaderOrderID=0;
		float totalPrice=0;
		for (NovelBean novelBean : ShoppingCar) {
			totalPrice+=novelBean.getPrice();
		}
		String date=new Date().toLocaleString();
		String tprice=totalPrice+"";
		
		String sql=String.format("insert into readerorder (ReaderID,OrderDatetime,OrderTotalPrice) "
				+ "values ('%s','%s','%s');",SessionReaderID,date,tprice);
		System.out.println(sql);
		ResultSet rs= SqlHelper.executeNonQueryRetuenID(sql);
		try {
			if(rs.next())
			{
				try {
					ReaderOrderID=rs.getInt(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		boolean b=false;
		for (NovelBean novelBean : ShoppingCar) {
			sql=String.format("insert into readerorderdetail(ReaderOrderID,NovelID) "
					+ " values ('%s','%s') ;",ReaderOrderID+"",novelBean.getNovelID()+"");
			System.out.println(sql); 
			b=SqlHelper.executeNonQuery(sql)==1;
		}	
		SqlHelper.Close();
		return b;
	}
	/**
	 *查询所有订单（未分页）
	 * @param readerid
	 * @return
	 */
	public ArrayList<OrderBean> getOrderList(int readerid)
	{
		String sql=String.format("select * from readerorder where readerid='%s' order by OrderDatetime",readerid);
		ResultSet rs=SqlHelper.executeQuery(sql);
		ArrayList<OrderBean> list=new ArrayList<OrderBean>();
		try {
			while(rs.next())
			{
				OrderBean ob=new OrderBean();
				ob.setReaderOrderID(rs.getInt("ReaderOrderID"));
				ob.setReaderID(rs.getInt("ReaderID"));
				ob.setOrderDatetime(rs.getDate("OrderDatetime"));
				ob.setOrderTotalPrice(rs.getFloat("OrderTotalPrice"));
				list.add(ob);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return null;
	}
	/**
	 *订单详单
	 * @param ReaderOrderID
	 * @return
	 */
	public ArrayList<OrderDetailBean> getOrderDetailList(int ReaderOrderID)
	{
		String sql=String.format("select * from readerorderdetail rod left join "
				+ "novel n on rod.NovelId=n.NovelID left join author a on n.AuthorID=a.AuthorID  "
				+ "where ReaderOrderID='%s'",ReaderOrderID);
		ResultSet rs=SqlHelper.executeQuery(sql);
		ArrayList<OrderDetailBean> list=new ArrayList<OrderDetailBean>();
		try {
			while(rs.next())
			{
				OrderDetailBean odb=new OrderDetailBean();
				odb.setReaderOrderDetailID(rs.getInt("ReaderOrderDetailID"));
				odb.setReaderOrderID(rs.getInt("ReaderOrderID"));
				odb.setNovelID(rs.getInt("NovelID"));
				odb.setNovelName(rs.getString("NovelName"));
				odb.setNovelAuthor(rs.getString("AuthorName"));
				odb.setPrice(rs.getFloat("Price"));
				list.add(odb);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.Close();
		}
		return null;
	}
	
}
