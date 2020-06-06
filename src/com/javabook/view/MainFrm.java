package com.javabook.view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1554, 1009);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 desktopPane = new JDesktopPane(){
			 public void paintComponent(Graphics g) {
				   int x = 0, y = 0;
				   ImageIcon icon = new ImageIcon("images/timg22.jpg");
				   g.drawImage(icon.getImage(), x, y, getSize().width,
				     getSize().height, this);// 图片会自动缩放
        
          }
      };   
		 desktopPane.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1544, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/添加 (1).png"));
		btnNewButton.setBounds(10, 22, 137, 73);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/修改（列表）.png"));
		btnNewButton_1.setBounds(155, 22, 115, 73);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("\u56FE\u4E66\u6DFB\u52A0");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setIcon(new ImageIcon("images/添加 (1).png"));
		btnNewButton_3.setBounds(281, 22, 109, 72);
		desktopPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u56FE\u4E66\u7EF4\u62A4");
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setIcon(new ImageIcon("images/修改（列表）.png"));
		btnNewButton_4.setBounds(400, 20, 122, 76);
		desktopPane.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("\u4F1A\u5458\u6DFB\u52A0");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorder(null);
		btnNewButton_6.setIcon(new ImageIcon("images/添加 (1).png"));
		btnNewButton_6.setBounds(556, 20, 132, 76);
		desktopPane.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("\u4F1A\u5458\u7EF4\u62A4");
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setIcon(new ImageIcon("images/修改（列表）.png"));
		btnNewButton_5.setBounds(711, 20, 138, 76);
		desktopPane.add(btnNewButton_5);
		
		JButton button = new JButton("\u4F1A\u5458\u5145\u503C");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon("images/充值.png"));
		button.setBounds(889, 24, 123, 68);
		desktopPane.add(button);
		
		JButton btnNewButton_7 = new JButton("\u8BA2\u5355\u7BA1\u7406");
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setBorder(null);
		btnNewButton_7.setIcon(new ImageIcon("images/报 表 管 理.png"));
		btnNewButton_7.setBounds(1049, 25, 130, 67);
		desktopPane.add(btnNewButton_7);
		btnNewButton_7.setToolTipText("");
		
		JButton btnNewButton_2 = new JButton("\u5B89\u5168\u9000\u51FA");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setIcon(new ImageIcon("images/退出.png"));
		btnNewButton_2.setBounds(1220, 36, 133, 44);
		desktopPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0) {
					dispose();
				}
			}
		});
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOnFrm userOnFrm = new UserOnFrm ();
				desktopPane.add(userOnFrm);
				userOnFrm.setVisible(true);
			
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechargeFrm rechargeFrm = new RechargeFrm();
				desktopPane.add(rechargeFrm);
				rechargeFrm.setVisible(true);
			
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuserManageInterFrm cuserManageInterFrm = new CuserManageInterFrm();
				desktopPane.add(cuserManageInterFrm);
				cuserManageInterFrm.setVisible(true);
				
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuserAddInterFrm cuserAddInterFrm = new CuserAddInterFrm();
				desktopPane.add(cuserAddInterFrm);
				cuserAddInterFrm.setVisible(true);
			
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm = new BookManageInterFrm();
				desktopPane.add(bookManageInterFrm);
				bookManageInterFrm.setVisible(true);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				desktopPane.add(bookAddInterFrm);
				bookAddInterFrm.setVisible(true);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm = new BookTypeManageInterFrm();
				desktopPane.add(bookTypeManageInterFrm);
				bookTypeManageInterFrm.setVisible(true);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm booktypeaddinterfrm = new BookTypeAddInterFrm();
				desktopPane.add(booktypeaddinterfrm);
				booktypeaddinterfrm.setVisible(true);
				
			}
		});
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//设置最大化
	}
}
