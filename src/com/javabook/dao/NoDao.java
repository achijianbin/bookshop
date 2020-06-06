package com.javabook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javabook.model.No;
import com.javabook.view.LogOnFrm;

public class NoDao {

	/**
	 * 用户查询订单
	 * @param con
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,No no)throws Exception{
		StringBuilder sb=new StringBuilder("select * from t_no where cuserid like");
		String cuserid = LogOnFrm.useNameTxt.getText();
		sb.append("'").append(cuserid).append("'");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 管理员查看全部订单
	 * @param con
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public ResultSet listuser(Connection con,No no)throws Exception{
		PreparedStatement pstmt=con.prepareStatement("select * from t_no ");
		return pstmt.executeQuery();
	}
}
