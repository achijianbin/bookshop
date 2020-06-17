package com.javabook.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javabook.dao.CuserDao;
import com.javabook.model.Cuser;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics;

public class SignUpFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userIdTxt;
	private DbUtil dbUtil = new DbUtil();
	private CuserDao cuserDao = new CuserDao();
	private JTextField userNameTxt;
	private JTextField userEmailTxt;
	private JTextField userPhoneTxt;
	private JPasswordField passwordTxt;
	private JPasswordField passwordEnterTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrm frame = new SignUpFrm();
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
	public SignUpFrm() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 631);
		contentPane = new JPanel(){
			 public void paintComponent(Graphics g) {
				   int x = 0, y = 0;
				   ImageIcon icon = new ImageIcon("images/3a9c0bf79052982247e073ebdaca7bcb0b46d402.jpg");
				   g.drawImage(icon.getImage(), x, y, getSize().width,
				     getSize().height, this);// 图片会自动缩放
  
    }
};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801:");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		userIdTxt = new JTextField();
		userIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/注册.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				signValueActionPerformed(evt);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/重置.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				reseetValueActionPerformed(evt);
			}
		});
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon("images/后退.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
	
			}
		});
		
		JLabel label = new JLabel("\u6635  \u79F0:");
		label.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u90AE \u7BB1:");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		userEmailTxt = new JTextField();
		userEmailTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u624B\u673A\u53F7\u7801:");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		userPhoneTxt = new JTextField();
		userPhoneTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		passwordEnterTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(148)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userPhoneTxt, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
						.addComponent(userIdTxt, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
						.addComponent(userEmailTxt)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(passwordEnterTxt))
							.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
					.addGap(200))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(117)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordEnterTxt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(userEmailTxt)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(label_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(userPhoneTxt)))
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
	/**
	 * 注册事件处理
	 */
	private void signValueActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=this.userIdTxt.getText();
		String passWord=String.valueOf( passwordTxt.getPassword());
		String passWordEnter=String.valueOf( passwordEnterTxt.getPassword());
		String name=this.userNameTxt.getText();
		String email=this.userEmailTxt.getText();
		String phone=this.userPhoneTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}

		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(passWordEnter)) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "昵称不能为空！");
			return;
		}
		if(StringUtil.isSame(passWord, passWordEnter)) {
			JOptionPane.showMessageDialog(null, "两次密码不一致！");
			return;
		}
		if(StringUtil.isLength(id)) {
			JOptionPane.showMessageDialog(null, "用户名不能超过八位数字！");

		}
		else if(StringUtil.isPasLength(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能小于八位数字！");
		}
		else if(!StringUtil.isEmail(email)){
			JOptionPane.showMessageDialog(null, "邮箱格式不正确！");
		}
		else if(!StringUtil.isMobile(phone)){
			JOptionPane.showMessageDialog(null, "手机号码格式不正确！");
		}
		else {
		Cuser cuser=new Cuser(id,name,passWord,email,phone);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=cuserDao.add(con, cuser);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "注册成功！");
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "注册失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "注册失败！");
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
 * 重置事件处理
 */
	private void reseetValueActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		this.userIdTxt.setText("");
		this.passwordTxt.setText("");
		this.passwordEnterTxt.setText("");
		this.userEmailTxt.setText("");
		this.userPhoneTxt.setText("");
		this.userNameTxt.setText("");
	}
}
