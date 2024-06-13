package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class doc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField did;
	private JTextField dname;
	private JTextField dqualification;
	private JTextField dspecialist;
	private JTable table;
	private JTextField bphone;
	private JTextField user;
	public static String dname1;
	public static String us;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc frame = new doc();
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
	public doc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1237, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 35, 66, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblDocName = new JLabel("DOC NAME");
		lblDocName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDocName.setBounds(10, 83, 116, 26);
		contentPane.add(lblDocName);
		
		JLabel lblQualification = new JLabel("QUALIFICATION");
		lblQualification.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQualification.setBounds(10, 133, 148, 26);
		contentPane.add(lblQualification);
		
		JLabel lblSpecialist = new JLabel("SPECIALIST");
		lblSpecialist.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSpecialist.setBounds(10, 183, 148, 26);
		contentPane.add(lblSpecialist);
		
		JLabel lblPhNo = new JLabel("PH NO");
		lblPhNo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhNo.setBounds(10, 228, 66, 26);
		contentPane.add(lblPhNo);
		
		JLabel lblAvailability = new JLabel("AVAILABILITY");
		lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAvailability.setBounds(10, 271, 148, 26);
		contentPane.add(lblAvailability);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"YES", "NO"}));
		comboBox.setBounds(200, 276, 54, 21);
		contentPane.add(comboBox);
		
		did = new JTextField();
		did.setBackground(new Color(255, 255, 255));
		did.setColumns(10);
		did.setBounds(190, 39, 96, 26);
		contentPane.add(did);
		
		dname = new JTextField();
		dname.setColumns(10);
		dname.setBounds(190, 87, 148, 26);
		contentPane.add(dname);
		
		dqualification = new JTextField();
		dqualification.setColumns(10);
		dqualification.setBounds(190, 140, 148, 26);
		contentPane.add(dqualification);
		
		dspecialist = new JTextField();
		dspecialist.setColumns(10);
		dspecialist.setBounds(190, 190, 148, 26);
		contentPane.add(dspecialist);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 108, 848, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				did.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				dname.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				dqualification.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				dspecialist.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				bphone.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "DOC NAME", "QUALIFICATION", "SPECIALIST", "PH NO", "AVAILABILITY"
			}
		));
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(0, 255, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String davailability = (String)comboBox.getSelectedItem();
				dname1=dname.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					String sql="insert into doctdetails values(?,?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, did.getText());
					pts.setString(2, dname1);
					pts.setString(3, dqualification.getText());
					pts.setString(4, dspecialist.getText());
					pts.setString(5, bphone.getText());
					pts.setString(6, davailability);
					
				
					dname.requestFocus();
				
					 dname.setText("");
					 dqualification.setText("");
					 dspecialist.setText("");
					 bphone.setText("");
					
					 
					
					

					
					pts.executeUpdate();
					 JOptionPane.showMessageDialog(null,"it has been registered");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace()
;					}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBounds(17, 391, 109, 48);
		contentPane.add(btnAdd);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBackground(new Color(0, 255, 255));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					Statement st=con.createStatement();
					String sql="select * from doctdetails";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					    DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("did"),rs.getString("dname"),rs.getString("dqualification"),rs.getString("dspecialist"),rs.getString("bphone"),rs.getString("davailability")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShow.setBounds(169, 391, 109, 49);
		contentPane.add(btnShow);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=did.getText();
				try {
			
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="delete from doctdetails WHERE did='"+code+"'";
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.execute();
					JOptionPane.showMessageDialog(null,"the details has been deleted");
					
				}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(17, 449, 109, 49);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(255, 128, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String davailability = (String)comboBox.getSelectedItem();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					String sql=("update doctdetails set dname=?,dqualification=?,dspecialist=?,bphone=?,davailability=? where did=?");
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.setString(1, dname.getText());
					pts.setString(2, dqualification.getText());
					pts.setString(3, dspecialist.getText());
					pts.setString(4, bphone.getText());
					pts.setString(5, davailability);
					pts.setString(6, did.getText());
					
				
					dname.requestFocus();
				
					 dname.setText("");
					 dqualification.setText("");
					 dspecialist.setText("");
					 bphone.setText("");
				
					 
					
					

					
					int i=pts.executeUpdate();
					if(i>0) {
					 JOptionPane.showMessageDialog(null,"it has been registered");
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
						Statement st=conn.createStatement();
						String sqll="select * from doctdetails";
						
						PreparedStatement ptss=con.prepareStatement(sqll);
						ResultSet rs= ptss.executeQuery();
						    DefaultTableModel dt=(DefaultTableModel)table.getModel();
						dt.setRowCount(0);
						while(rs.next()) {
						
						Object o[]= {rs.getString("did"),rs.getString("dname"),rs.getString("dqualification"),rs.getString("dspecialist"),rs.getString("bphone"),rs.getString("davailability")};
						dt.addRow(o);
						}}
				}
					catch(Exception ex) {
						
			}
			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(169, 449, 109, 49);
		contentPane.add(btnUpdate);
		
		bphone = new JTextField();
		bphone.setColumns(10);
		bphone.setBounds(190, 235, 148, 26);
		contentPane.add(bphone);
		
		JButton app = new JButton("VERIFY");
		app.setBackground(new Color(0, 255, 0));
		app.setFont(new Font("Tahoma", Font.BOLD, 13));
		app.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
				
					
					us = user.getText();
					//@SuppressWarnings("deprecation")
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					System.out.println("1");
					Statement st = con.createStatement();
					System.out.println("1");
					String sql = "Select * from doctdetails";
					System.out.println("1");
					ResultSet rs = st.executeQuery(sql);
					System.out.println("1");
					while(rs.next()){
						String name = rs.getString("dname");
						System.out.println("1-");
						String availability = rs.getString("davailability");
						System.out.println("1-");
						if(name.equals(us) && (availability.equals("YES") || availability.equals("Yes") || availability.equals("yes"))){
							JOptionPane.showMessageDialog(app, "OK", "YES!!,THERE IS AN APPOINTMENT FOR THIS DOCTOR",-1);
						Appointments frame = new Appointments();
						frame.setVisible(true);
						SwingUtilities.windowForComponent(app).dispose();
					}
						else {
							
						}
					
					}
					
				}
					
					
				catch(Exception o) {
					JOptionPane.showMessageDialog(app, this, "Error while establishing connection failed",-1);
					o.printStackTrace();
				}
					
				}
				
			
		});
		app.setBounds(817, 411, 155, 36);
		contentPane.add(app);
		
		JLabel lblNewLabel_1 = new JLabel("FOR APPOINTMENTS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(417, 398, 229, 27);
		contentPane.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(506, 435, 206, 37);
		contentPane.add(user);
		user.setColumns(10);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("DOC NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(380, 445, 116, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(1102, 10, 99, 30);
		contentPane.add(back);
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
	}
}
