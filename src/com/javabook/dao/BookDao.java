package com.javabook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javabook.model.Book;
import com.javabook.util.StringUtil;

/**
 * 图书Dao类
 * @author Administrator
 *
 */
public class BookDao {
	
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
		public int add(Connection con,Book book)throws Exception{
			String sql="insert into t_book(bookName,author,price,bookTypeId,bookDesc,bookNumber) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setFloat(3, book.getPrice());
			pstmt.setInt(4, book.getBookTypeId());
			pstmt.setString(5, book.getBookDesc());
			pstmt.setInt(6, book.getBookNumber());
			return pstmt.executeUpdate();
		
		}
	/**
	 * 	图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
			public ResultSet list(Connection con,Book book)throws Exception{
				StringBuilder sb=new StringBuilder("select * from t_book b,t_bookType1 bt where b.bookTypeId=bt.id");
				if(StringUtil.isNotEmpty(book.getBookName())){
					sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
				}
				if(StringUtil.isNotEmpty(book.getAuthor())){
					sb.append(" and b.author like '%").append(book.getAuthor()).append("%'");
				}
				if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1){
					sb.append(" and b.bookTypeId=").append(book.getBookTypeId());
				}
				PreparedStatement pstmt=con.prepareStatement(sb.toString());
				return pstmt.executeQuery();
			}
		
			/**
			 * 图书信息删除
			 * @param con
			 * @param id
			 * @return
			 * @throws Exception
			 */
			public int delete(Connection con,String id)throws Exception{
				String sql="delete from t_book where id=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				return pstmt.executeUpdate();
			}
			/**
			 * 图书信息修改
			 * @param con
			 * @param book
			 * @return
			 * @throws Exception
			 */
			public int update(Connection con,Book book)throws Exception{
				String sql="update t_book set bookName=?,author=?,price=?,bookDesc=?,bookTypeId=?,bookNumber=? where id=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, book.getBookName());
				pstmt.setString(2, book.getAuthor());
				pstmt.setFloat(3, book.getPrice());
				pstmt.setString(4, book.getBookDesc());
				pstmt.setInt(5, book.getBookTypeId());
				pstmt.setInt(6, book.getBookNumber());
				pstmt.setInt(7, book.getId());
				return pstmt.executeUpdate();
			}
			/**
			 * 指定图书类别下是否存在图书
			 * @param con
			 * @param bookTypeId
			 * @return
			 * @throws Exception
			 */
			public boolean existBookByBookTypeId(Connection con,String bookTypeId)throws Exception{
				String sql="select * from t_book where bookTypeId=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, bookTypeId);
				ResultSet rs=pstmt.executeQuery();
				return rs.next();
			}
		}

