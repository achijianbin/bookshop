package com.javabook.view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CuserMainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuserMainFrm frame = new CuserMainFrm();
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
	public CuserMainFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 793);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1526, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 787, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton b1 = new JButton("\u56FE\u4E66\u67E5\u8BE2\u4E0B\u5355");
		b1.setContentAreaFilled(false);
		b1.setBorder(null);
		b1.setIcon(new ImageIcon("images/查询.png"));
		b1.setFont(new Font("幼圆", Font.PLAIN, 20));
		b1.setBounds(527, 35, 183, 72);
		desktopPane.add(b1);
		
		JButton btnNewButton_1 = new JButton("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("images/个人信息.png"));
		btnNewButton_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		btnNewButton_1.setBounds(288, 35, 196, 72);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8D2D\u7269\u8F66");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setIcon(new ImageIcon("images/购物车.png"));
		btnNewButton_2.setFont(new Font("幼圆", Font.PLAIN, 20));
		btnNewButton_2.setBounds(770, 35, 166, 72);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u8BA2\u5355");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/报 表 管 理.png"));
		btnNewButton.setFont(new Font("幼圆", Font.PLAIN, 20));
		btnNewButton.setBounds(999, 32, 166, 78);
		desktopPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoFrm noFrm = new NoFrm();
				desktopPane.add(noFrm );
				noFrm .setVisible(true);
			
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopCarFrm shopCarFrm = new ShopCarFrm();
				desktopPane.add(shopCarFrm );
				shopCarFrm .setVisible(true);
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CuserPersonalFrm cuserPersonalFrm = new CuserPersonalFrm();
				desktopPane.add(cuserPersonalFrm );
				cuserPersonalFrm .setVisible(true);
			
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuserBookSearchFrm cuserBookSearchFrm = new CuserBookSearchFrm();
				desktopPane.add(cuserBookSearchFrm);
				cuserBookSearchFrm.setVisible(true);
				
			}
		});
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
