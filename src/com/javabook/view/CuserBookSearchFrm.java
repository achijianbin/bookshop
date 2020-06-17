package com.javabook.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javabook.dao.BookDao;
import com.javabook.dao.BookTypeDao;
import com.javabook.dao.ShopCarDao;
import com.javabook.model.Book;
import com.javabook.model.BookType;
import com.javabook.model.ShopCar;
import com.javabook.util.DbUtil;
import com.javabook.util.doOrderNum;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class CuserBookSearchFrm extends JInternalFrame {
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private JTable bookTable;
	private JComboBox s_bookTypeJcb;
	private JComboBox bookTypeJcb_1;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private ShopCarDao shopcarDao = new ShopCarDao();
	private ShopCar shopcar = new ShopCar();
	private BookDao bookDao=new BookDao();
	private Book book=new Book();
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField priceTxt;
	private JTextField authorTxt;
	private  JTextArea bookDescTxt;
	private JTextField booknumberTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuserBookSearchFrm frame = new CuserBookSearchFrm();
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
	public CuserBookSearchFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u67E5\u8BE2\u8D2D\u4E70");
		setBounds(100, 100, 929, 725);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
						.addComponent(scrollPane)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		lblNewLabel_5.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		priceTxt = new JTextField();
		priceTxt.setEditable(false);
		priceTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_6.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u8BF7\u8F93\u5165\u8D2D\u4E70\u6570\u91CF\uFF1A");
		lblNewLabel_7.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		JLabel lblNewLabel_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_8.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		 bookTypeJcb_1 = new JComboBox();
		 bookTypeJcb_1.setFont(new Font("幼圆", Font.PLAIN, 16));
		 bookTypeJcb_1.setEnabled(false);
		
		JLabel lblNewLabel_9 = new JLabel("\u56FE\u4E66\u6982\u8FF0\uFF1A");
		lblNewLabel_9.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		 bookDescTxt = new JTextArea();
		 bookDescTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/结算.png"));
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toShopCarActionPerformed(e);
			}
		});
		
		booknumberTxt = new JTextField();
		booknumberTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		booknumberTxt.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(lblNewLabel_4)
							.addGap(7)
							.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(booknumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(82)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(32)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(bookTypeJcb_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
					.addGap(42)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_9))
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(authorTxt)
						.addComponent(bookDescTxt, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
					.addGap(20))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(32)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_9)
									.addComponent(bookTypeJcb_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(114))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(35)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_5)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_8))
								.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnNewButton_1)
									.addComponent(lblNewLabel_7)
									.addComponent(booknumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(37)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		bookTable = new JTable();
		bookTable.setFont(new Font("幼圆", Font.PLAIN, 16));
		bookTable.setRowHeight(20);
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u56FE\u4E66\u6570\u91CF", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u522B", "\u56FE\u4E66\u6982\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(138);
		scrollPane.setViewportView(bookTable);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		s_authorTxt = new JTextField();
		s_authorTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		 s_bookTypeJcb = new JComboBox();
		 s_bookTypeJcb.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/查询.png"));
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuserBookSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, 0, 91, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(45))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new Book());
		this.fillBookType("search");
		this.fillBookType("modify");
	}
	/**
	 * 加入购物车事件
	 * @param e
	 */
	private void toShopCarActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		int result=JOptionPane.showConfirmDialog(null, "是否加入购物车");
	
		if(result==0) {
		
	
		String bookname=this.nameTxt.getText();
		String price=this.priceTxt.getText();
		String buyid=doOrderNum.doOrderNum();
		String cuserid=LogOnFrm.useNameTxt.getText();
		int booknumber=Integer.valueOf(this.booknumberTxt.getText());
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		int bookid=Integer.parseInt(idTxt.getText());
		ShopCar shopcar=new ShopCar(bookname, booknumber,df.format(date),Float.parseFloat(price),cuserid,bookid,buyid);
		Connection con=null;
		try{
			con=dbUtil.getCon();		
			int addNum=ShopCarDao.add(con, shopcar);
			
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "图书已添加到购物车！");
				shopcarDao.updatebooknumber(con, shopcar);
				this.fillTable(new Book());
				 resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		}catch(Exception evt){
			evt.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception evt) {
				// TODO Auto-generated catch block
				evt.printStackTrace();
			}}}
		
		}
	
		
	
/**
 * 表格含点击事件处理
 * @param e
 */
	private void bookTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.nameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		
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
	 * 图书搜索事件
	 * @param evt
	 */
	private void cuserBookSearchActionPerformed(ActionEvent evt) {
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
	/**
	 * 表单重置处理
	 */
	private void resetValue(){
	
		
		this.booknumberTxt.setText("");
		
		}
}
