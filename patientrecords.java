package hospital;
import hospital.admission;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PatientsRecords extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField pname;
	private JTextField rblood;
	private JTextField ridentification;
	private JTextField rheight;
	private JTextField raddress;
	private JTextField rproblem;
	private JTextField rplans;
	private JTextField rweight;
	private JTextField rphone;
	private JTable table;
	private JTextField search;
	private JTextField docname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientsRecords frame = new PatientsRecords();
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
	public PatientsRecords() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1285, 679);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		docname = new JTextField();
		docname.setColumns(10);
		docname.setBounds(403, 313, 169, 26);
		contentPane.add(docname);
		docname.setText(""+doc.us);
		
		JLabel lblDocName = new JLabel("DOC NAME");
		lblDocName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDocName.setBounds(404, 292, 197, 13);
		contentPane.add(lblDocName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		comboBox.setBounds(28, 254, 169, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 100, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblPatientName = new JLabel("PATIENT NAME");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPatientName.setBounds(28, 167, 135, 13);
		contentPane.add(lblPatientName);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(28, 231, 116, 13);
		contentPane.add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBloodGroup.setBounds(28, 290, 154, 13);
		contentPane.add(lblBloodGroup);
		
		JLabel lblWeight = new JLabel("WEIGHT");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWeight.setBounds(211, 167, 91, 13);
		contentPane.add(lblWeight);
		
		JLabel lblHeight = new JLabel("HEIGHT");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeight.setBounds(211, 231, 101, 13);
		contentPane.add(lblHeight);
		
		JLabel lblProblem = new JLabel("PROBLEM");
		lblProblem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProblem.setBounds(211, 100, 91, 13);
		contentPane.add(lblProblem);
		
		JLabel lblTreatmentPlans = new JLabel("TREATMENT PLANS");
		lblTreatmentPlans.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTreatmentPlans.setBounds(394, 100, 178, 13);
		contentPane.add(lblTreatmentPlans);
		
		JLabel lblIdentificationInfo = new JLabel("IDENTIFICATION INFO");
		lblIdentificationInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIdentificationInfo.setBounds(211, 290, 197, 13);
		contentPane.add(lblIdentificationInfo);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(394, 231, 116, 13);
		contentPane.add(lblAddress);
		
		JLabel lblPhno = new JLabel("PH.NO");
		lblPhno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhno.setBounds(394, 163, 91, 21);
		contentPane.add(lblPhno);
		
		pid = new JTextField();
		pid.setBounds(28, 123, 77, 26);
		contentPane.add(pid);
		pid.setColumns(10);
		pid.setText(""+admission.id1);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(28, 190, 169, 26);
		contentPane.add(pname);
		pname.setText(""+admission.name1);
		
		rblood = new JTextField();
		rblood.setColumns(10);
		rblood.setBounds(28, 315, 169, 26);
		contentPane.add(rblood);
		
		ridentification = new JTextField();
		ridentification.setColumns(10);
		ridentification.setBounds(211, 313, 169, 26);
		contentPane.add(ridentification);
		
		rheight = new JTextField();
		rheight.setColumns(10);
		rheight.setBounds(211, 254, 169, 26);
		contentPane.add(rheight);
		
		raddress = new JTextField();
		raddress.setColumns(10);
		raddress.setBounds(394, 254, 169, 26);
		contentPane.add(raddress);
		raddress.setText(""+admission.address1);
		
		rproblem = new JTextField();
		rproblem.setColumns(10);
		rproblem.setBounds(211, 123, 169, 26);
		contentPane.add(rproblem);
		
		rplans = new JTextField();
		rplans.setColumns(10);
		rplans.setBounds(394, 123, 169, 26);
		contentPane.add(rplans);
		
		rweight = new JTextField();
		rweight.setColumns(10);
		rweight.setBounds(211, 190, 169, 26);
		contentPane.add(rweight);
		
		rphone = new JTextField();
		rphone.setColumns(10);
		rphone.setBounds(394, 190, 169, 26);
		contentPane.add(rphone);
		rphone.setText(""+admission.phone1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 354, 1222, 288);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				
				pname.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				
				rblood.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				rproblem.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				rweight.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
				rheight.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
				ridentification.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
				rplans.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
				rphone.setText(table.getValueAt(table.getSelectedRow(), 10).toString());
				raddress.setText(table.getValueAt(table.getSelectedRow(), 11).toString());
				docname.setText(table.getValueAt(table.getSelectedRow(), 12).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "DATE", "NAME", "GENDER", "BLOOD", "PROBLEM", "WEIGHT", "HEIGHT", "IDENTIFICATION", "PLANS", "PHONE", "ADDRESS","DOCNAME"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(95);
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		table.getColumnModel().getColumn(10).setPreferredWidth(80);
		table.getColumnModel().getColumn(11).setPreferredWidth(115);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rgender = (String)comboBox.getSelectedItem();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
				   String sql="insert into patientrecords (pid,pname,rgender,rblood,rproblem,rweight,rheight,ridentification,rplans,rphone,raddress,doc_name) values (?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, pid.getText());
					
					pts.setString(2, pname.getText());
					pts.setString(3, rgender);
					pts.setString(4, rblood.getText());
					pts.setString(5, rproblem.getText());
					pts.setString(6, rweight.getText());
					pts.setString(7, rheight.getText());
					pts.setString(8, ridentification.getText());
					pts.setString(9, rplans.getText());
					pts.setString(10, rphone.getText());
					pts.setString(11, raddress.getText());
					pts.setString(12, docname.getText());
					pname.requestFocus();
				
					
					 pname.setText("");
					
					 rblood.setText("");
					 rproblem.setText("");
					 rweight.setText("");
					 rheight.setText("");
					 ridentification.setText("");
					 rplans.setText("");
					 rphone.setText("");
					 raddress.setText("");
					 docname.setText("");
					
					 String sq="select id,name,phone,address from admission where name='"+admission.name1+"'";
						PreparedStatement ptss=con.prepareStatement(sq);
						ResultSet rs= ptss.executeQuery();
						while(rs.next()) {
							String b=rs.getString("id");
							pid.setText(b);
							
							String k=rs.getString("name");
							pname.setText(k);
							String c=rs.getString("phone");
							rphone.setText(c);
							String d=rs.getString("address");
							raddress.setText(d);
							
						}
						
						 String sqq="select dname from doctdetails where dname='"+doc.us+"'";
							PreparedStatement ptss1=con.prepareStatement(sqq);
							ResultSet rss= ptss1.executeQuery();
							while(rss.next()) {
								String V=rss.getString("dname");
								docname.setText(V);
								
							}
					pts.executeUpdate();
					
				
					 
						
					
				
					
					 JOptionPane.showMessageDialog(null,"THE PATIENT'S RECORDS HAS BEEN REGISTERED");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace()
;					}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(683, 108, 109, 49);
		contentPane.add(btnNewButton);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setBackground(new Color(0, 0, 255));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					Statement st=con.createStatement();
					String sql="select * from patientrecords";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					    DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("pid"),rs.getString("rdate"),rs.getString("pname"),rs.getString("rgender"),rs.getString("rblood"),rs.getString("rproblem"),rs.getString("rweight"),rs.getString("rheight"),rs.getString("ridentification"),rs.getString("rplans"),rs.getString("rphone"),rs.getString("raddress"),rs.getString("doc_name")};
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
		btnShow.setBounds(683, 190, 109, 49);
		contentPane.add(btnShow);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=pid.getText();
				try {
			
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="delete from patientrecords WHERE pid='"+code+"'";
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.execute();
					JOptionPane.showMessageDialog(null,"THE PATIENT'S RECORDS HAS BEEN DELETED");
				}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(841, 190, 109, 49);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENTS RECORDS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(824, 47, 379, 49);
		contentPane.add(lblNewLabel_1);
		
		final JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(1162, 7, 99, 30);
		contentPane.add(back);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rgender = (String)comboBox.getSelectedItem();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql=("update patientrecords set pname=?,rgender=?,rblood=?,rproblem=?,rweight=?,rheight=?,ridentification=?,rplans=?,rphone=?,raddress=?,doc_name=? where pid=?");
					PreparedStatement pts=con.prepareStatement(sql);
					
					
					pts.setString(1, pname.getText());
					pts.setString(2, rgender);
					pts.setString(3, rblood.getText());
					pts.setString(4, rproblem.getText());
					pts.setString(5, rweight.getText());
					pts.setString(6, rheight.getText());
					pts.setString(7, ridentification.getText());
					pts.setString(8, rplans.getText());
					pts.setString(9, rphone.getText());
					pts.setString(10, raddress.getText());
					pts.setString(12, pid.getText());
					pts.setString(11, docname.getText());
				
					pname.requestFocus();
				
				
					 pname.setText("");
					
					 rblood.setText("");
					 rproblem.setText("");
					 rweight.setText("");
					 rheight.setText("");
					 ridentification.setText("");
					 rplans.setText("");
					 rphone.setText("");
					 raddress.setText("");
					 docname.setText("");
					
					
					
					

					
					int i=pts.executeUpdate();
					if(i>0) {
					 JOptionPane.showMessageDialog(null,"it has been registered");
					 Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
						Statement st=conn.createStatement();
						String sqll="select * from patientrecords";
						
						PreparedStatement ptss=conn.prepareStatement(sqll);
						ResultSet rs= ptss.executeQuery();
						    DefaultTableModel dt=(DefaultTableModel)table.getModel();
						dt.setRowCount(0);
						while(rs.next()) {
						
						Object o[]= {rs.getString("pid"),rs.getString("rdate"),rs.getString("pname"),rs.getString("rgender"),rs.getString("rblood"),rs.getString("rproblem"),rs.getString("rweight"),rs.getString("rheight"),rs.getString("ridentification"),rs.getString("rplans"),rs.getString("rphone"),rs.getString("raddress"),rs.getString("doc_name")};
						dt.addRow(o);
						}
					 
					}
				}
					catch(Exception ex) {
						
                        ex.printStackTrace();
;					}
			}
		});
		btnNewButton_1.setBounds(834, 107, 116, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnShow_1 = new JButton("SEARCH");
		btnShow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String query="select * from patientrecords where pid=? ";
					PreparedStatement pts=conn.prepareStatement(query);
					pts.setString(1,search.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
						Object o[]= {rs.getString("pid"),rs.getString("rdate"),rs.getString("pname"),rs.getString("rgender"),rs.getString("rblood"),rs.getString("rproblem"),rs.getString("rweight"),rs.getString("rheight"),rs.getString("ridentification"),rs.getString("rplans"),rs.getString("rphone"),rs.getString("raddress"),rs.getString("doc_name")};
						dt.addRow(o);
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			}
		});
		btnShow_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShow_1.setBackground(Color.CYAN);
		btnShow_1.setBounds(622, 288, 129, 49);
		contentPane.add(btnShow_1);
		
		JLabel lblSearchName = new JLabel("SEARCH  ID");
		lblSearchName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchName.setBounds(777, 315, 135, 13);
		contentPane.add(lblSearchName);
		
		search = new JTextField();
		search.setColumns(10);
		search.setBounds(922, 303, 169, 26);
		contentPane.add(search);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1271, 642);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\tharun\\OneDrive\\Documents\\sor.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1271, 642);
		contentPane.add(lblNewLabel_3);
	}
}
