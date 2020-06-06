package com.javabook.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import com.javabook.dao.CuserDao;
import com.javabook.model.Cuser;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CuserPersonalFrm extends JInternalFrame {
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField passwordTxt;
	private JTextField emailTxt;
	private JTextField phoneTxt;
	private JTextField monkeyTxt;
	private DbUtil dbUtil=new DbUtil();
	private CuserDao cuserDao=new CuserDao();
	private Cuser cuser=new Cuser();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuserPersonalFrm frame = new CuserPersonalFrm();
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
	public CuserPersonalFrm() {
		setTitle("\u4E2A\u4EBA\u8D44\u6599");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 642, 471);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6635  \u79F0:");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		passwordTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u90AE  \u7BB1\uFF1A");
		lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		emailTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		phoneTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4F59  \u989D\uFF1A");
		lblNewLabel_5.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		monkeyTxt = new JTextField();
		monkeyTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		monkeyTxt.setEnabled(false);
		monkeyTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/修改（列表）.png"));
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuserUpateActionperformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(148)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
										.addGap(37))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addGap(34))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(53)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(monkeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
					.addGap(68))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(monkeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(76, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(252)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(155))
		);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new Cuser());

	}
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

	private void fillTable(Cuser cuser) {
	
		
		Connection con =null;
		try {	
			con=dbUtil.getCon();
			ResultSet rs=cuserDao.shuju(con, cuser);
			
			while(rs.next()) {
				idTxt.setText(rs.getString("id"));
				nameTxt.setText(rs.getString("name"));
				passwordTxt.setText(rs.getString("passWord"));
				emailTxt.setText(rs.getString("email"));
				phoneTxt.setText(rs.getString("phone"));
				monkeyTxt.setText(rs.getString("monkey"));
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
