package com.javabook.util;


import java.sql.Connection;
import java.sql.DriverManager;
import com.javabook.view.*;

/**
  * ���ݿ⹤����
  * @author Administrator
  *
  */
public class DbUtil {

	private String dbUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName="+SqlLogOnFrm.getSqlName();//���ݿ����ӵ�ַ
	private String dbUserName=SqlLogOnFrm.getUserName();//�û���
	private String dbPassword=SqlLogOnFrm.getPass();//����
	private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";	//��������
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * �ر����ݿ�
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}


	
}
