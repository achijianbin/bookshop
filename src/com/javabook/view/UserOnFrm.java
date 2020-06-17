package com.javabook.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javabook.dao.NoDao;
import com.javabook.model.Book;
import com.javabook.model.BookType;
import com.javabook.model.No;
import com.javabook.util.DbUtil;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserOnFrm extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil=new DbUtil();
	private NoDao noDao = new NoDao();
	private No no = new No();
	private JTextField cuserTxt;
	private JTextField booknameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOnFrm frame = new UserOnFrm();
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
	public UserOnFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u7528\u6237\u8BA2\u5355");
		setBounds(100, 100, 1107, 732);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u7528   \u6237   \u8BA2    \u5355   ");
		lblNewLabel.setIcon(new ImageIcon("images/报 表 管 理.png"));
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		cuserTxt = new JTextField();
		cuserTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		cuserTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		booknameTxt = new JTextField();
		booknameTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		booknameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(125, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(299))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 852, GroupLayout.PREFERRED_SIZE)
							.addGap(118))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(138)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cuserTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(369, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(cuserTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(booknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
		);
		
		table = new JTable();
		table.setFont(new Font("华文细黑", Font.PLAIN, 14));
		table.setRowHeight(20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u7528\u6237\u540D", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u6570\u91CF", "\u56FE\u4E66\u603B\u4EF7", "\u8BA2\u5355\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
		table.getColumnModel().getColumn(1).setPreferredWidth(62);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new No());

	}
	private void boSearchActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String bookName=this.booknameTxt.getText();
		String cuserid=this.cuserTxt.getText();
		
		
		No no=new No(bookName,cuserid);
		this.fillTable(no);
	}

	/**
	 * 初始化表格数据
	 * @param no
	 */
	private void fillTable(No no) {
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);//表格清空
		Connection con =null;
		try {	
			con=dbUtil.getCon();
			ResultSet rs=noDao.listuser(con, no);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("buyid"));
				v.add(rs.getString("cuserid"));			
				v.add(rs.getString("bookname"));
				v.add(rs.getString("bookNumber"));			
				v.add(rs.getFloat("price"));
				v.add(rs.getString("date"));
							
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
