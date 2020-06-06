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

public class NoFrm extends JInternalFrame {
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
					NoFrm frame = new NoFrm();
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
	public NoFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1068, 616);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 898, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFont(new Font("Ó×Ô²", Font.PLAIN, 17));
		table.setRowHeight(20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u53F7", "\u7528\u6237\u540D", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u6570\u91CF", "\u56FE\u4E66\u603B\u4EF7", "\u8BA2\u5355\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(143);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		table.getColumnModel().getColumn(5).setPreferredWidth(168);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new No());
	}
	private void fillTable(No no) {
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);//±í¸ñÇå¿Õ
		Connection con =null;
		try {	
			con=dbUtil.getCon();
			ResultSet rs=noDao.list(con, no);
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
