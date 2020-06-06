package com.javabook.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javabook.dao.BookDao;
import com.javabook.dao.BookTypeDao;
import com.javabook.dao.ShopCarDao;
import com.javabook.model.Book;
import com.javabook.model.BookType;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private  JComboBox bookTypeJcb_1 ;
	private JComboBox s_bookTypeJcb;

	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private ShopCarDao shopcarDao = new ShopCarDao();
	private BookDao bookDao=new BookDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private JTextField bookNumberTxt;
	private JTextField priceTxt;
	private JTextField authorTxt;
	private JTextArea bookDescTxt;
	






	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 880, 655);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7\uFF1A");
		label_3.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label_4.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		bookNameTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u6570\u91CF\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		bookNumberTxt = new JTextField();
		bookNumberTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		bookNumberTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		label_6.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		priceTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		label_7.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		authorTxt = new JTextField();
		authorTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		authorTxt.setColumns(10);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label_8.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		bookTypeJcb_1 = new JComboBox();
		bookTypeJcb_1.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		JLabel label_9 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		label_9.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		 bookDescTxt = new JTextArea();
		 bookDescTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setIcon(new ImageIcon("images/修改（列表）.png"));
		button_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookUpateActionperformed(evt);
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setIcon(new ImageIcon("images/删除筛选项.png"));
		button_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookDeleteActionPerformed(evt);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(29)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(239)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(authorTxt)
										.addComponent(bookNumberTxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_8)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(bookTypeJcb_1, 0, 103, Short.MAX_VALUE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))))
							.addGap(114)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(label_7)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(bookNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(bookTypeJcb_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(39)
							.addComponent(label_9))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		label.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		s_authorTxt = new JTextField();
		s_authorTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		 s_bookTypeJcb = new JComboBox();
		 s_bookTypeJcb.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon("images/查询.png"));
		button.setFont(new Font("幼圆", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_2)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.setFont(new Font("幼圆", Font.PLAIN, 16));
		bookTable.setRowHeight(20);
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				bookTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(bookTable);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u56FE\u4E66\u6570\u91CF", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u522B", "\u56FE\u4E66\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		getContentPane().setLayout(groupLayout);
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());
		

	}
	/**
	 * 图书删除事件处理
	 * @param evt
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				boolean flag=shopcarDao.existShopCarBybookid(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "用户购物车下此有图书，不能删除此此图书");
					return;
				}
				int deleteNum=bookDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Book());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 图书修改事件处理
	 * @param evt
	 */
	private void bookUpateActionperformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		String bookNumber=this.bookNumberTxt.getText();
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "图书价格不能为空！");
			return;
		}
		
		
		
		BookType bookType=(BookType) bookTypeJcb_1.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(Integer.parseInt(id),  bookName, author, Float.parseFloat(price),  bookTypeId,  bookDesc,Integer.valueOf(bookNumber));
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=bookDao.update(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "图书修改成功！");
				resetValue();
				this.fillTable(new Book());
			}else{
				JOptionPane.showMessageDialog(null, "图书修改失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书修改失败！");
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
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.bookDescTxt.setText("");
		this.bookNumberTxt.setText("");
		if(this.bookTypeJcb_1.getItemCount()>0){
			this.bookTypeJcb_1.setSelectedIndex(0);
		}
	}

	/**
	 * 表格含点击事件处理
	 * @param met
	 */
	private void bookTableMousePressed(MouseEvent met) {
		// TODO 自动生成的方法存根
		int row=this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		this.bookNumberTxt.setText((String)bookTable.getValueAt(row, 3));
		this.priceTxt.setText(bookTable.getValueAt(row, 4) +"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row, 6));
		String bookTypeName=(String)this.bookTable.getValueAt(row, 5);
		int n=this.bookTypeJcb_1.getItemCount();
		for(int i=0;i<n;i++){
			BookType item=(BookType)this.bookTypeJcb_1.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)){
				this.bookTypeJcb_1.setSelectedIndex(i);
			}
		}
		
	}

	/**
	 * 图书查询事件处理
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		BookType bookType=(BookType) this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(bookName,author,bookTypeId);
		this.fillTable(book);
	}
	/**
	 * 初始化下拉框
	 * @param type 下拉框类型
	 */
	private void fillBookType(String type) {
		Connection con = null;
		BookType bookType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			if("search".equals(type)){
				bookType=new BookType();
				bookType.setBookTypeName("请选择...");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while(rs.next()){
				bookType=new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.s_bookTypeJcb.addItem(bookType);
				}else if("modify".equals(type)){
					this.bookTypeJcb_1.addItem(bookType);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
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
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel)bookTable.getModel();
		dtm.setRowCount(0);//表格清空
		Connection con =null;
		try {	
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con, book);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));			
				v.add(rs.getString("author"));
				v.add(rs.getString("bookNumber"));			
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookDesc"));			
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {	
		try {
			dbUtil.closeCon(con);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		}	
	}
}
	


