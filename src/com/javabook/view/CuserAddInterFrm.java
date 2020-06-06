package com.javabook.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.javabook.dao.CuserDao;
import com.javabook.model.Cuser;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class CuserAddInterFrm extends JInternalFrame {
	private JTextField userIdTxt;
	private JTextField passwordTxt;
	private JTextField userNameTxt;
	private JTextField userEmailTxt;
	private JTextField userPhoneTxt;
	private DbUtil dbUtil = new DbUtil();
	private CuserDao cuserDao = new CuserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuserAddInterFrm frame = new CuserAddInterFrm();
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
	public CuserAddInterFrm() {
		setTitle("\u4F1A\u5458\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 494, 540);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("\u6635  \u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("\u90AE  \u7BB1\uFF1A");
		lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblS = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		lblS.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		userIdTxt = new JTextField();
		userIdTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		userIdTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		passwordTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		userNameTxt.setColumns(10);
		
		userEmailTxt = new JTextField();
		userEmailTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		userEmailTxt.setColumns(10);
		
		userPhoneTxt = new JTextField();
		userPhoneTxt.setFont(new Font("幼圆", Font.PLAIN, 18));
		userPhoneTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon("images/添加 (1).png"));
		button.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuserAddActionPerformed();
			}
		});
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/重置.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reseetValueActionPerformed(e);
				
			}
		});
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
									.addComponent(lblS))
								.addComponent(lblNewLabel_3)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(userEmailTxt)
						.addComponent(userNameTxt)
						.addComponent(passwordTxt)
						.addComponent(userIdTxt)
						.addComponent(userPhoneTxt))
					.addContainerGap(623, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userIdTxt))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(userEmailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblS)
						.addComponent(userPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(69))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void cuserAddActionPerformed() {
		// TODO 自动生成的方法存根
		String id=this.userIdTxt.getText();
		String passWord=this.passwordTxt.getText();
		String name=this.userNameTxt.getText();
		String email=this.userEmailTxt.getText();
		String phone=this.userPhoneTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "昵称不能为空");
			return;
		}	
	
		Cuser cuser=new Cuser(id,name,passWord,email,phone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=cuserDao.add(con, cuser);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "添加成功！");
			
			}else{
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败！");
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
	 * 重置事件处理
	 * @param evt
	 */
	private void reseetValueActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		this.userIdTxt.setText("");
		this.passwordTxt.setText("");
		this.userEmailTxt.setText("");
		this.userPhoneTxt.setText("");
		this.userNameTxt.setText("");
	}
}
