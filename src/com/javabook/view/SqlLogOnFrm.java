package com.javabook.view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.javabook.util.DbUtil;
import java.awt.Font;
import javax.swing.JPasswordField;



public class SqlLogOnFrm extends JFrame {

	private JPanel contentPane;
	private static JTextField SqlName;
	private static JTextField UserName;
	 private Image image;
	 private static JPasswordField passwordField;
	 

	public static String getSqlName() {
		return SqlName.getText();
	}
	
	public static String getUserName() {
		return UserName.getText();
	}
	public static String getPass() {
		return passwordField.getText();
	}
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SqlLogOnFrm frame = new SqlLogOnFrm();
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
	public SqlLogOnFrm() {
		setTitle("\u767B\u9646\u6570\u636E\u5E93");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 404);
		contentPane = new JPanel(){
			 public void paintComponent(Graphics g) {
				   int x = 0, y = 0;
				   ImageIcon icon = new ImageIcon("images/3744f9edab64034f93d7772ea2c379310a551d3b.jpg");
				   g.drawImage(icon.getImage(), x, y, getSize().width,
				     getSize().height, this);// 图片会自动缩放
  
    }
};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel tex = new JLabel("\u6570\u636E\u5E93\u540D:");
		tex.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		SqlName = new JTextField("bookshop");
		SqlName.setFont(new Font("幼圆", Font.PLAIN, 18));
		SqlName.setColumns(10);
		
		JLabel userName = new JLabel("\u6570\u636E\u5E93\u7528\u6237\u540D:");
		userName.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		UserName = new JTextField("sa");
		UserName.setFont(new Font("幼圆", Font.PLAIN, 18));
		UserName.setColumns(10);
		
		JLabel pa = new JLabel("\u5BC6  \u7801:");
		pa.setFont(new Font("幼圆", Font.PLAIN, 18));
		pa.setToolTipText("");
		
		passwordField = new JPasswordField("201835020129");
		
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/登录.png"));
		
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/重置.png"));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				congzhiAtion(e);
			}
		});
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(102, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userName)
								.addComponent(tex, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGap(55))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(pa, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
							.addGap(67)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
								.addComponent(SqlName)
								.addComponent(UserName)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(SqlName, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(tex, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(UserName, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(pa))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		

		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	
		 }
	


	
	private void congzhiAtion(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.UserName.setText("");
		this.SqlName.setText("");
		this.passwordField.setText("");
	}

	private void action(ActionEvent evt) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			JOptionPane.showMessageDialog(null, "数据库连接成功");
			dispose();
			new LogOnFrm().setVisible(true);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"数据库连接失败");
		}
	}
}
