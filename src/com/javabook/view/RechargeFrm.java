package com.javabook.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.javabook.dao.CuserDao;
import com.javabook.model.Cuser;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RechargeFrm extends JInternalFrame {
	private JTextField idTxt;
	private JTextField monkeyTxt;
	private DbUtil dbUtil = new DbUtil();
	private CuserDao cuserDao = new CuserDao();
	private Cuser cuser=new Cuser();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechargeFrm frame = new RechargeFrm();
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
	public RechargeFrm() {
		setTitle("\u4F1A\u5458\u5145\u503C");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("��Բ", Font.PLAIN, 20));
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("��Բ", Font.PLAIN, 20));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5145\u503C\u91D1\u989D\uFF1A");
		lblNewLabel_1.setFont(new Font("��Բ", Font.PLAIN, 20));
		
		monkeyTxt = new JTextField();
		monkeyTxt.setFont(new Font("��Բ", Font.PLAIN, 20));
		monkeyTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5145\u503C");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon("images/��ֵ.png"));
		btnNewButton.setFont(new Font("��Բ", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cusermonkeyUpateActionperformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(monkeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(monkeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(btnNewButton)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * ��ֵ����
	 * @param evt
	 */
	private void cusermonkeyUpateActionperformed(ActionEvent evt) {
		// TODO �Զ����ɵķ������
		String id=this.idTxt.getText();	
		String monkey=this.monkeyTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(monkey)){
			JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
			return;
		}
		
		
		Cuser cuser= new Cuser(id,Float.parseFloat(monkey));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=cuserDao.updatemonkey(con,cuser);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "��ֵ�ɹ���");
				this.resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "��ֵ�޸�ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��ֵ�޸�ʧ�ܣ�");
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
	 * �����ô���
	 */
	private void resetValue(){
		this.idTxt.setText("");
		
		this.monkeyTxt.setText("");
		
		}
	}

