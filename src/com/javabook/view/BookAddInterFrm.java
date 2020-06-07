package com.javabook.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import com.javabook.dao.BookDao;
import com.javabook.dao.BookTypeDao;
import com.javabook.model.Book;
import com.javabook.model.BookType;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField bookNumTxt;
	private JTextField priceTxt;
	private JTextField authorTxt;
	private JComboBox bookTypejcb;
	private JTextArea bookDescTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao  bookTypeDao = new BookTypeDao();
	private BookDao  bookDao = new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 777, 522);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u6570\u91CF\uFF1A");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		bookNumTxt = new JTextField();
		bookNumTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u79CD\u7C7B\uFF1A");
		lblNewLabel_5.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		 bookTypejcb = new JComboBox();
		 bookTypejcb.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblNewLabel_6 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		lblNewLabel_6.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		 bookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/添加 (1).png"));
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/重置.png"));
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2))
						.addComponent(lblNewLabel))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(priceTxt, Alignment.LEADING)
						.addComponent(bookNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
						.addComponent(bookTypejcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(authorTxt, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(bookNumTxt, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))))
					.addGap(293))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(92)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(473))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)
							.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(bookTypejcb, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6))
							.addGap(81)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(345, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();

	}
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.resetValue();
	}

	/**
	 * 图书添加事件处理
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		Float price= Float.valueOf(this.priceTxt.getText());
		String bookDesc=this.bookDescTxt.getText();
		String bookNumber=this.bookNumTxt.getText();
		if (StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if (StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			return;
		}
		if (StringUtil.isEmpty(String.valueOf(price))) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空");
			return;
		}
		if (StringUtil.isEmpty(bookNumber)) {
			JOptionPane.showMessageDialog(null, "图书数量不能为空");
			return;
		}
		BookType bookType=(BookType)bookTypejcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book = new Book(bookName, author, Float.parseFloat(String.valueOf(price)),bookTypeId, bookDesc,Integer.valueOf(bookNumber));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=bookDao.add(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
/**
 * 重置表单
 */
private void resetValue(){
	this.bookNameTxt.setText("");
	this.authorTxt.setText("");
	this.priceTxt.setText("");
	this.bookDescTxt.setText("");
	this.bookNumTxt.setText("");
	
}


	/**
     * 初始化图书类别下拉框
     */
	private void fillBookType(){
		Connection con=null;
		BookType bookType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			while(rs.next()){
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypejcb.addItem(bookType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
			dbUtil.closeCon(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
            
        }
	}
}
