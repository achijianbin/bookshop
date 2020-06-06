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
import com.javabook.model.No;
import com.javabook.util.DbUtil;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class UserOnFrm extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil=new DbUtil();
	private NoDao noDao = new NoDao();
	private No no = new No();

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
		setBounds(100, 100, 1010, 654);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u7528   \u6237   \u8BA2    \u5355   ");
		lblNewLabel.setIcon(new ImageIcon("images/报 表 管 理.png"));
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 852, GroupLayout.PREFERRED_SIZE)
							.addGap(65))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(299))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(83, Short.MAX_VALUE))
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
