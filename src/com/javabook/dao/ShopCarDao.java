package com.javabook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javabook.model.No;
import com.javabook.model.ShopCar;
import com.javabook.view.LogOnFrm;

public class ShopCarDao {
	/**
	 * 添加进购物车
	 * @param con
	 * @param shopcar
	 * @return
	 * @throws Exception
	 */
	public static int add(Connection con,ShopCar shopcar)throws Exception{
		String sql="insert into t_shopcar(bookname,price,booknumber,date,cuserid,bookid,buyid) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, shopcar.getBookname());
		
		pstmt.setFloat(2, shopcar.getPrice());
		pstmt.setInt(3, shopcar.getBooknumber());
		pstmt.setString(4, shopcar.getDate());
		pstmt.setString(5, shopcar.getCuserid());
		pstmt.setInt(6, shopcar.getBookid());
		pstmt.setString(7, shopcar.getBuyid());
		return pstmt.executeUpdate();
	
	}
	/**
	 * 用户购物车物品查询
	 * @param con
	 * @param shopcar
	 * @return
	 * @throws Exception
	 */
public ResultSet list(Connection con,ShopCar shopcar)throws Exception{
	StringBuilder sb=new StringBuilder("select * from t_shopcar where cuserid like");
	String id = LogOnFrm.useNameTxt.getText();
	sb.append("'").append(id).append("'");
	PreparedStatement pstmt=con.prepareStatement(sb.toString());
	return pstmt.executeQuery();
}
/**
 * 更新图书数量
 * @param con
 * @param shopcar
 * @return
 * @throws Exception
 */
public int updatebooknumber(Connection con,ShopCar shopcar)throws Exception{
	
	String sql="update t_book set bookNumber=bookNumber - (select sum(b.booknumber) from t_shopcar b where bookid=? and cuserid=?)    where id=? ";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(3, shopcar.getBookid());
	pstmt.setInt(1, shopcar.getBookid());
	pstmt.setString(2, shopcar.getCuserid());
	return pstmt.executeUpdate();
}
/**
 * 删除购物车订单
 * @param con
 * @param id
 * @return
 * @throws Exception
 */
public int delete(Connection con,String id)throws Exception{
	String sql="delete from t_shopcar where shopid=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, id);
	return pstmt.executeUpdate();
}
/**
 * 购物车总价计算
 * @param con
 * @param shopcar
 * @return
 * @throws Exception
 */
public static ResultSet zongjia(Connection con,ShopCar shopcar)throws Exception{
	StringBuilder sb=new StringBuilder("SELECT SUM(price) AS OrderTotal FROM t_shopcar where cuserid like");
	String id = LogOnFrm.useNameTxt.getText();
	sb.append("'").append(id).append("'");
	PreparedStatement pstmt=con.prepareStatement(sb.toString());
	
	return pstmt.executeQuery();


}
/**
 * 
 * @param con
 * @param shopcar
 * @return
 * @throws Exception
 */
public ResultSet dingdan(Connection con,ShopCar shopcar)throws Exception{
	StringBuilder sb=new StringBuilder("select * from t_shopcar where cuserid like ");
	String id = LogOnFrm.useNameTxt.getText();
		sb.append("'").append(id).append("'");

	PreparedStatement pstmt=con.prepareStatement(sb.toString());
	return pstmt.executeQuery();
}

/**
 * 购物车订单添加至订单
 * @param con
 * @param shopcar
 * @param no
 * @return
 * @throws Exception
 */
public static int addtable(Connection con,ShopCar shopcar,No no)throws Exception{
	StringBuilder sb=new StringBuilder("insert into t_no(buyid,cuserid,bookname,date,booknumber,price) select buyid ,cuserid,bookname,date,booknumber,price from t_shopcar where cuserid like ");
	String id = LogOnFrm.useNameTxt.getText();
	sb.append("'").append(id).append("'");

PreparedStatement pstmt=con.prepareStatement(sb.toString());

	return pstmt.executeUpdate();
}
/**
 * 付款后购物车物品清空
 * @param con
 * @param id
 * @return
 * @throws Exception
 */
public int deletecar(Connection con,String id)throws Exception{
	StringBuilder sb=new StringBuilder("delete from t_shopcar where cuserid like");
			String id1 = LogOnFrm.useNameTxt.getText();
	sb.append("'").append(id1).append("'");

PreparedStatement pstmt=con.prepareStatement(sb.toString());
return pstmt.executeUpdate();
}
/**
 * 指定用户下购物车是否存在图书
 * @param con
 * @return
 * @throws Exception
 */
public boolean existShopCarBycuserid(Connection con,String cuserid)throws Exception{
	String sql="select * from t_shopcar where cuserid=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, cuserid);
	ResultSet rs=pstmt.executeQuery();
	return rs.next();
}
/**
 * 指定购物车是否存在图书
 * @param con
 * @return
 * @throws Exception
 */
public boolean existShopCarBybookid(Connection con,String bookid)throws Exception{
	String sql="select * from t_shopcar where bookid=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, bookid);
	ResultSet rs=pstmt.executeQuery();
	return rs.next();
}
}
