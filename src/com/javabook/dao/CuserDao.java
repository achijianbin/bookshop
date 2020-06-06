package com.javabook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javabook.model.Cuser;
import com.javabook.view.LogOnFrm;


public class CuserDao {
/**
 * 用户注册
 * @param con
 * @param cuser
 * @return
 * @throws Exception
 */
		public int add(Connection con,Cuser cuser)throws Exception{
			String sql="insert into t_cuser(id,name,passWord,email,phone) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cuser.getId());
			pstmt.setString(2, cuser.getName());
			pstmt.setString(3, cuser.getPassWord());
			pstmt.setString(4, cuser.getEmail());
			pstmt.setString(5, cuser.getPhone());
			return pstmt.executeUpdate();
		
		}
		/**
		 * 用户登录验证
		 * @param con
		 * @param cuser
		 * @return
		 * @throws Exception
		 */
		
		public static Cuser login(Connection con,Cuser cuser)throws Exception{
			Cuser resultCuser=null;
			String sql="select * from t_cuser where id=? and passWord=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cuser.getId());
			pstmt.setString(2,cuser.getPassWord());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				resultCuser=new Cuser();
				resultCuser.setId(rs.getString("id"));
				resultCuser.setPassWord(rs.getString("passWord"));
				
			}
			return resultCuser;
		}
		/**
		 * 用户信息查询
		 * @param con
		 * @return
		 * @throws Exception
		 */
		public ResultSet list(Connection con,Cuser cuser)throws Exception{
			StringBuilder sb=new StringBuilder("select * from t_cuser");
			if(cuser.getId()!=null){
				sb.append(" and id like '%").append(cuser.getId()).append("%'");
			}
			if(cuser.getName()!=null){
				sb.append(" and name like '%").append(cuser.getName()).append("%'");
			}
			if(cuser.getEmail()!=null){
				sb.append(" and email like '%").append(cuser.getEmail()).append("%'");
			}
			if(cuser.getPhone()!=null){
				sb.append(" and phone like '%").append(cuser.getPhone()).append("%'");
			}
			
			PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
			return pstmt.executeQuery();
		}
	/**
	 * 用户信息修改
	 * @param con
	 * @return
	 * @throws Exception
	 */
		public int update(Connection con,Cuser cuser)throws Exception{
			String sql="update t_cuser set id=?,name=?,passWord=?,email=?,phone=? where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cuser.getId());
			pstmt.setString(2, cuser.getName());
			pstmt.setString(3, cuser.getPassWord());
			pstmt.setString(4, cuser.getEmail());
			pstmt.setString(5, cuser.getPhone());
			pstmt.setString(6, cuser.getId());
			return pstmt.executeUpdate();
		}
		/**
		 * 信息删除
		 * @param con
		 * @param id
		 * @return
		 * @throws Exception
		 */
		public int delete(Connection con,String id)throws Exception{
			String sql="delete from t_cuser where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		}

		/**
		 * 余额充值
		 * @param con
		 * @param cuser
		 * @return
		 * @throws Exception
		 */
		public int updatemonkey(Connection con,Cuser cuser)throws Exception{
			String sql="update t_cuser set monkey=monkey+? where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setFloat(1, cuser.getMonkey());
			pstmt.setString(2, cuser.getId());
			return pstmt.executeUpdate();
		}	
		/**
		 * 用户查看资料
		 * @param con
		 * @param cuser
		 * @return
		 * @throws Exception
		 */
		public ResultSet shuju(Connection con,Cuser cuser)throws Exception{
			StringBuilder sb=new StringBuilder("select * from t_cuser where id like ");
			String id = LogOnFrm.useNameTxt.getText();
				sb.append("'").append(id).append("'");
		
			PreparedStatement pstmt=con.prepareStatement(sb.toString());
			return pstmt.executeQuery();
		}
		/**
		 * 付款减少余额
		 * @param con
		 * @param cuser
		 * @return
		 * @throws Exception
		 */
		public int jianshaomonkey(Connection con,Cuser cuser)throws Exception{
			String sql="update t_cuser set monkey=monkey-? where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setFloat(1, cuser.getMonkey());
			pstmt.setString(2, cuser.getId());
			return pstmt.executeUpdate();
		}	

		}
		

