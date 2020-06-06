package com.javabook.util;


import java.sql.Connection;
import java.sql.DriverManager;
import com.javabook.view.*;

/**
  * 数据库工具类
  * @author Administrator
  *
  */
public class DbUtil {

	private String dbUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName="+SqlLogOnFrm.getSqlName();//数据库连接地址
	private String dbUserName=SqlLogOnFrm.getUserName();//用户名
	private String dbPassword=SqlLogOnFrm.getPass();//密码
	private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";	//驱动名称
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * 关闭数据库
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	
}
