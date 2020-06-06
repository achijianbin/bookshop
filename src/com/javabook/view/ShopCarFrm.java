package com.javabook.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javabook.dao.CuserDao;
import com.javabook.dao.NoDao;
import com.javabook.dao.ShopCarDao;
import com.javabook.model.Cuser;
import com.javabook.model.No;
import com.javabook.model.ShopCar;
import com.javabook.util.DbUtil;
import com.javabook.util.StringUtil;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ShopCarFrm extends JInternalFrame {
	private JTable shopcartable;
	private DbUtil dbUtil = new DbUtil();
	private ShopCarDao shopcarDao = new ShopCarDao();
	private NoDao noDao = new NoDao();
	private No no = new No();
	private ShopCar shopcar = new ShopCar();
	private JTextField idTxt;
	private JTextField pirceTxt;
	private CuserDao cuserDao = new CuserDao();
	private Cuser cuser=new Cuser();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopCarFrm frame = new ShopCarFrm();
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
	public ShopCarFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8D2D\u7269\u8F66");
		setBounds(100, 100, 1084, 633);
		
		JScrollPane scrollPane = new JScrollPane();

		
		JButton button = new JButton("\u5220\u9664");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon("images/删除筛选项.png"));
		button.setFont(new Font("幼圆", Font.PLAIN, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopcarDeleteActionEvent(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u8BA2\u5355\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("幼圆", Font.PLAIN, 20));
		idTxt.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("\u603B  \u4EF7:");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		
		pirceTxt = new JTextField();
		pirceTxt.setEditable(false);
		pirceTxt.setFont(new Font("幼圆", Font.PLAIN, 20));
		pirceTxt.setColumns(10);
		
		JButton button_1 = new JButton("\u7ED3\u7B97");
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setIcon(new ImageIcon("images/付款.png"));
		button_1.setFont(new Font("幼圆", Font.PLAIN, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 949, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(24)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(pirceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(lblNewLabel_1)
								.addComponent(pirceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1)
								.addComponent(lblNewLabel)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button))))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		shopcartable = new JTable();
		shopcartable.setRowHeight(20);
		shopcartable.setFont(new Font("幼圆", Font.PLAIN, 16));
		shopcartable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				shopcarmousePressed(e);
			}
		});
		shopcartable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4EF7\u683C", "\u4E0B\u5355\u6570\u91CF", "\u4E0B\u5355\u65F6\u95F4", "\u4E0B\u5355\u7528\u6237", "\u4E0B\u5355\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		shopcartable.getColumnModel().getColumn(3).setPreferredWidth(121);
		scrollPane.setViewportView(shopcartable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new ShopCar());
		this.monkey(new ShopCar());
		

	}
	/**
	 * 余额减少事件
	 */
	private void cuserjianshaomonkey() {
		// TODO 自动生成的方法存根
		String id= LogOnFrm.useNameTxt.getText();
		String monkey=this.pirceTxt.getText();
		

		Cuser cuser= new Cuser(id,Float.parseFloat(monkey));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=cuserDao.jianshaomonkey(con, cuser);
			if(addNum==1){
				
			
			}else{
				JOptionPane.showMessageDialog(null, "消费失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "消费失败！");
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
 * 购物事件
 * @param evt
 */
	private void noActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		Connection con =null;
		try{
			String id=idTxt.getText();
			
			con=dbUtil.getCon();
			

			
				JOptionPane.showMessageDialog(null, "购物成功");
				
				String cuserid=LogOnFrm.useNameTxt.getText();
				this.shopcarDao.addtable(con, shopcar, no);
				this.shopcarDao.deletecar(con, cuserid);
				this.cuserjianshaomonkey();
				this.fillTable(new ShopCar());
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "购物失败");
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
	 * 删除购物车物品事件
	 * @param evt
	 */
	private void shopcarDeleteActionEvent(ActionEvent evt) {
		// TODO 自动生成的方法存根
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
				int deleteNum=shopcarDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					
					this.fillTable(new ShopCar());
					this.monkey(new ShopCar());
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
 * 行点击事件
 * @param evt
 */
	private void shopcarmousePressed(MouseEvent evt) {
		// TODO 自动生成的方法存根
		int row=this.shopcartable.getSelectedRow();
		this.idTxt.setText((String)shopcartable.getValueAt(row, 5));
	}
	/**
	 * 初始化表格
	 * @param shopcar
	 */
	private void fillTable(ShopCar shopcar) {
		DefaultTableModel dtm=(DefaultTableModel)shopcartable.getModel();
		dtm.setRowCount(0);//表格清空
		Connection con = null;
		try {	
			con=dbUtil.getCon();
			ResultSet rs=shopcarDao.list(con, shopcar);
		
			while(rs.next()) {
				Vector v=new Vector();
				
				v.add(rs.getString("bookname"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("booknumber"));			
				v.add(rs.getString("date"));
				v.add(rs.getString("cuserid"));
				v.add(rs.getString("shopid"));
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
	/**
	 * 计算总价
	 * @param shopcar
	 */
private void monkey(ShopCar shopcar) {
	
		
		Connection con =null;
		try {	
			con=dbUtil.getCon();
			ResultSet rs=ShopCarDao.zongjia(con, shopcar);
			
			while(rs.next()) {
				pirceTxt.setText(String.valueOf(rs.getFloat("OrderTotal")));
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
