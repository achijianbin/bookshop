package com.javabook.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.javabook.dao.CuserDao;
import com.javabook.dao.UserDao;
import com.javabook.model.Cuser;
import com.javabook.model.User;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;
import com.javabook.util.YanzhenUtil;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	public static JTextField useNameTxt;
	private JPasswordField passwordTxt;
	private JRadioButton user;
	private  JRadioButton cuser;

	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	private YanzhenUtil vcode = new YanzhenUtil();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setTitle("\u56FE\u4E66\u552E\u4E66\u7CFB\u7EDF\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 578, 413);
		contentPane = new JPanel(){
			 public void paintComponent(Graphics g) {
				   int x = 0, y = 0;
				   ImageIcon icon = new ImageIcon("images/71d0f91004cd49ad941a57219b33a225.jpeg");
				   g.drawImage(icon.getImage(), x, y, getSize().width,
				     getSize().height, this);// 图片会自动缩放
    
      }
  };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u552E\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("images/图书 (2).png"));
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 21));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setIcon(new ImageIcon("images/用户名.png"));
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 18));

		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("images/密码.png"));
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 18));

		useNameTxt = new JTextField();
		useNameTxt.setFont(new Font("幼圆", Font.PLAIN, 16));
		useNameTxt.setColumns(10);

		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("幼圆", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/登录.png"));
		this.getRootPane().setDefaultButton(btnNewButton);// 设置焦点默认在登录按键

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});

		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/重置.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reseetValueActionPerformed(e);
			}
		});

		JButton button = new JButton("\u6CE8\u518C");
		button.setFont(new Font("幼圆", Font.PLAIN, 18));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon("images/注册.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpActionPerformed(e);
			}
		});

		 cuser = new JRadioButton("\u7528\u6237");
		 cuser.setFont(new Font("幼圆", Font.PLAIN, 16));
		cuser.setSelected(true);

		 user = new JRadioButton("\u7BA1\u7406\u5458");
		 user.setFont(new Font("幼圆", Font.PLAIN, 16));
		// 单选按钮分组
		ButtonGroup group = new ButtonGroup();
		group.add(cuser);
		group.add(user);

		JLabel lblNewLabel_3 = new JLabel("\u9A8C\u8BC1\u7801");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("images/验证码.png"));
		lblNewLabel_3.setFont(new Font("幼圆", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setFont(new Font("幼圆", Font.PLAIN, 16));
		textField.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addComponent(cuser, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(user, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(207, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2))
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordTxt, 174, 174, 174)
										.addComponent(useNameTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
							.addGap(49)
							.addComponent(vcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(82))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(useNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(vcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cuser)
						.addComponent(user))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(button))
					.addGap(83))
		);
		contentPane.setLayout(gl_contentPane);
		//设置居中显示
		this.setLocationRelativeTo(null);
	}
	
	

	/**
	 * 验证码判断
	 * 
	 * @return
	 */
	public boolean isValidCodeRight() {
		if (textField == null) {
			return false;
		} else if (vcode == null) {
			return true;
		} else if (vcode.getCode().equals(textField.getText())) {
			return true;
		} else
			return false;
	}

	/**
	 * 注册事件处理
	 *
	 */
	private void signUpActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		new SignUpFrm().setVisible(true);
	}

	/**
	 * 登陆事件处理
	 *
	 */

	private void loginActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		if(user.isSelected()){
			String useName = this.useNameTxt.getText();
			String password = new String(this.passwordTxt.getPassword());

			if (StringUtil.isEmpty(useName)) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
			if (StringUtil.isEmpty(password)) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			User user = new User(useName, password);
			Connection con = null;
			try {

				con = dbUtil.getCon();
				User currentUSer = userDao.login(con, user);
				if (currentUSer != null) {
					if (vcode.getCode().toLowerCase().equals(textField.getText())) {
						dispose();
						new MainFrm().setVisible(true);
					} else {

						JOptionPane.showMessageDialog(null, "验证码错误");
						vcode.nextCode();//更换验证码
						this.textField.setText("");
					}
				} else {
					if (vcode.getCode().equals(textField.getText())) {
						JOptionPane.showMessageDialog(null, "用户名或密码错误");
						vcode.nextCode();
					} else {
						JOptionPane.showMessageDialog(null, "验证码错误");
						vcode.nextCode();
						this.textField.setText("");
					}
				}
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				
				try {
					dbUtil.closeCon(con);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

	}else if(cuser.isSelected()){
		String useName = this.useNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());

		if (StringUtil.isEmpty(useName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		Cuser cuser = new Cuser(useName, password);
		Connection con = null;
		try {

			con = dbUtil.getCon();
			Cuser currentCuser = CuserDao.login(con, cuser);
			if (currentCuser != null) {
				if (vcode.getCode().toLowerCase().equals(textField.getText())) {
					dispose();
					new CuserMainFrm().setVisible(true);
				} else {

					JOptionPane.showMessageDialog(null, "验证码错误");
					vcode.nextCode();
					this.textField.setText("");
				}
			} else {
				if (vcode.getCode().toLowerCase().equals(textField.getText())) {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
					vcode.nextCode();
					
				} else {
					JOptionPane.showMessageDialog(null, "验证码错误");
					vcode.nextCode();
					this.textField.setText("");
				}
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
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

	/**
	 * 重置事件处理
	 *
	 */
	private void reseetValueActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		this.useNameTxt.setText("");
		this.passwordTxt.setText("");
		this.textField.setText("");
	}
}
