package com.javabook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javabook.model.BookType;

/**
 * ͼ�����Dao��
 * @author Administrator
 *
 */
public class BookTypeDao {
	/**
	 * ͼ��������
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BookType bookType )throws Exception{
		String sql="insert into t_bookType1(bookTypeName,bookTypeDesc) values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
		
	}
	/**
	 * ��ѯͼ����𼯺�
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BookType bookType)throws Exception{
		StringBuilder sb=new StringBuilder("select * from t_bookType1");
		if(bookType.getBookTypeName()!=null){
			sb.append(" and bookTypeName like '%").append(bookType.getBookTypeName()).append("%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}


/**
 * ɾ��ͼ�����
 * @param con
 * @param id
 * @return
 * @throws Exception
 */
	public int delete(Connection con,String id)throws Exception{
		
		String sql="delete from t_bookType1 where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * ����ͼ�����
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,BookType bookType)throws Exception{
	
		String sql="update t_bookType1 set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
	
}
