package com.javabook.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javabook.dao.CuserDao;
import com.javabook.dao.ShopCarDao;
import com.javabook.model.Cuser;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class CuserManageInterFrm extends JInternalFrame {
	private JTextField s_idTxt;
	private JTextField s_nameTxt;
	private JTextField s_emailTxt;
	private JTextField s_phoneTxt;
	private JTable cusertable;
	private DbUtil dbUtil = new DbUtil();
	private CuserDao cuserDao = new CuserDao();
	private ShopCarDao shopcarDao = new ShopCarDao();
	private Cuser cuser=new Cuser();
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField passwordTxt;
	private JTextField emailTxt;
	private JTextField phoneTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuserManageInterFrm frame = new CuserManageInterFrm();
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
	public CuserManageInterFrm() {
		setTitle("\u4F1A\u5458\u7EF4\u62A4");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 977, 642);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(170, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u6635\u79F0\uFF1A");
		lblNewLabel_5.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_6.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		passwordTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u90AE\u7BB1\uFF1A");
		lblNewLabel_7.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		emailTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		lblNewLabel_8.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		phoneTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/修改（列表）.png"));
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuserUpateActionperformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/删除筛选项.png"));
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuserDeleteActionPerformed(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(28)
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(91))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8)
								.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_1))))
					.addGap(86))
		);
		panel_1.setLayout(gl_panel_1);
		
		cusertable = new JTable();
		cusertable.setFont(new Font("幼圆", Font.PLAIN, 16));
		cusertable.setRowHeight(20);
		cusertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				cuserTableMousePressed(met);
			}
		});
		cusertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u6635\u79F0", "\u5BC6\u7801", "\u90AE\u7BB1", "\u624B\u673A\u53F7\u7801", "\u91D1\u989D"
			}
		));
		scrollPane.setViewportView(cusertable);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		s_idTxt = new JTextField();
		s_idTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6635\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		s_nameTxt = new JTextField();
		s_nameTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u90AE\u7BB1\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		s_emailTxt = new JTextField();
		s_emailTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_emailTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		s_phoneTxt = new JTextField();
		s_phoneTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		s_phoneTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon("images/查询.png"));
		button.setFont(new Font("幼圆", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuserSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addComponent(lblNewLabel_3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(s_emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(482, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(s_phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		this.fillTable(cuser);
	}
	/**
	 * 删除用户事件处理
	 * @param evt
	 */
	private void cuserDeleteActionPerformed(ActionEvent evt) {
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
				boolean flag=shopcarDao.existShopCarBycuserid(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "当前用户购物车下有图书，不能删除此用户");
					return;
				}
				int deleteNum=cuserDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Cuser());
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
	 * 修改事件处理
	 * @param evt
	 */
	private void cuserUpateActionperformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=this.idTxt.getText();	
		String name=this.nameTxt.getText();
		String password=this.passwordTxt.getText();
		String email=this.emailTxt.getText();
		String phone=this.phoneTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(name)){
			JOptionPane.showMessageDialog(null, "昵称不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
	

		Cuser cuser= new Cuser(id,name,password,email,phone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=cuserDao.update(con,cuser);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "用户信息修改成功！");
				resetValue();
				this.fillTable(new Cuser());
			}else{
				JOptionPane.showMessageDialog(null, "用户信息修改失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "用户信息修改失败！");
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
		this.nameTxt.setText("");
		this.passwordTxt.setText("");
		this.emailTxt.setText("");
		this.phoneTxt.setText("");
		

	}
	/**
	 * 表格行点击事件处理
	 * @param met
	 */
	private void cuserTableMousePressed(MouseEvent met) {
		// TODO 自动生成的方法存根
		int row=this.cusertable.getSelectedRow();
		this.idTxt.setText((String)cusertable.getValueAt(row, 0));
		this.nameTxt.setText((String)cusertable.getValueAt(row, 1));
		this.passwordTxt.setText((String)cusertable.getValueAt(row, 2));
		this.emailTxt.setText((String)cusertable.getValueAt(row, 3));
		this.phoneTxt.setText((String)cusertable.getValueAt(row, 4));
		
	
		
	}
	/**
	 * 用户搜索事件处理
	 * @param e
	 */
	private void cuserSearchActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String id=this.s_idTxt.getText();
		String name=this.s_nameTxt.getText();
		String email=this.s_emailTxt.getText();
		String phone=this.s_phoneTxt.getText();
		
		 cuser=new Cuser(id,name,email,phone);
		this.fillTable(cuser);
	}

	/**
	 * 初始化表格数据
	 */
	private void fillTable(Cuser cuser) {
		DefaultTableModel dtm=(DefaultTableModel)cusertable.getModel();
		dtm.setRowCount(0);//表格清空
		Connection con = null;
		try {	
			con=dbUtil.getCon();
			ResultSet rs=cuserDao.list(con, cuser);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("passWord"));	
				v.add(rs.getString("email"));			
				v.add(rs.getString("phone"));
				v.add(rs.getFloat("monkey"));
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

