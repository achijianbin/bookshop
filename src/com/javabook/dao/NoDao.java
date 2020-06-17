package com.javabook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javabook.model.Cuser;
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
		StringBuilder sb=new StringBuilder("select * from t_no");
		if(no.getBookname()!=null){
			sb.append(" and bookname like '%").append(no.getBookname()).append("%'");
		}
		if(no.getCuserid()!=null){
			sb.append(" and cuserid like '%").append(no.getCuserid()).append("%'");
		}
		
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	}
	
		
