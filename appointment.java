package hospital;
import hospital.doc;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
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
import javax.swing.JToggleButton;

public class Appointments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField adate;
	private JTextField pname;
	private JTextField adoctor;
	private JTextField atime;
	private JTextField atype;
	private JTextField aproblem;
	private JTextField aphone;
	private JTable JTable1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JButton back;
	private JButton btnShow;
	private JLabel lblSearchName;
	private JTextField search;
	private JComboBox comboBox;
	public static String doctor1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointments frame = new Appointments();
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
	public Appointments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 721);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(223, 184, 171, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 36, 76, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblAppointmentDate = new JLabel("APPOINTMENT DATE");
		lblAppointmentDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAppointmentDate.setBounds(25, 80, 204, 30);
		contentPane.add(lblAppointmentDate);
		
		JLabel lblPatientName = new JLabel("PATIENT NAME");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPatientName.setBounds(25, 131, 171, 30);
		contentPane.add(lblPatientName);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(25, 182, 76, 30);
		contentPane.add(lblGender);
		
		JLabel lblDoctorsName = new JLabel("DOCTOR'S NAME\r\n");
		lblDoctorsName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDoctorsName.setBounds(25, 225, 171, 30);
		contentPane.add(lblDoctorsName);
		
		JLabel lblTimings = new JLabel("TIMINGS");
		lblTimings.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimings.setBounds(437, 80, 76, 30);
		contentPane.add(lblTimings);
		
		JLabel lblPatientsProblem = new JLabel("PATIENT'S PROBLEM");
		lblPatientsProblem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPatientsProblem.setBounds(437, 182, 194, 30);
		contentPane.add(lblPatientsProblem);
		
		JLabel lblTypeOfDoctor = new JLabel("TYPE OF DOCTOR");
		lblTypeOfDoctor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTypeOfDoctor.setBounds(437, 131, 162, 30);
		contentPane.add(lblTypeOfDoctor);
		
		pid = new JTextField();
		pid.setBackground(new Color(192, 192, 192));
		pid.setBounds(223, 39, 86, 30);
		contentPane.add(pid);
		pid.setColumns(10);
		
		adate = new JTextField();
		adate.setBackground(new Color(192, 192, 192));
		adate.setColumns(10);
		adate.setBounds(223, 83, 171, 30);
		contentPane.add(adate);
		
		pname = new JTextField();
		pname.setBackground(new Color(192, 192, 192));
		pname.setColumns(10);
		pname.setBounds(223, 131, 171, 30);
		contentPane.add(pname);
		
		adoctor = new JTextField();
		adoctor.setBackground(new Color(192, 192, 192));
		adoctor.setColumns(10);
		adoctor.setBounds(223, 225, 171, 30);
		contentPane.add(adoctor);
		adoctor.setText(""+doc.us);
		
		JLabel lblPhNo = new JLabel("PH NO");
		lblPhNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhNo.setBounds(437, 225, 194, 30);
		contentPane.add(lblPhNo);
		
		atime = new JTextField();
		atime.setBackground(new Color(192, 192, 192));
		atime.setColumns(10);
		atime.setBounds(623, 83, 171, 30);
		contentPane.add(atime);
		
		atype = new JTextField();
		atype.setBackground(new Color(192, 192, 192));
		atype.setColumns(10);
		atype.setBounds(623, 134, 171, 30);
		contentPane.add(atype);
		
		aproblem = new JTextField();
		aproblem.setBackground(new Color(192, 192, 192));
		aproblem.setColumns(10);
		aproblem.setBounds(623, 185, 171, 30);
		contentPane.add(aproblem);
		
		aphone = new JTextField();
		aphone.setBackground(new Color(192, 192, 192));
		aphone.setColumns(10);
		aphone.setBounds(623, 233, 171, 30);
		contentPane.add(aphone);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 297, 1208, 286);
		contentPane.add(scrollPane);
		
		JTable1 = new JTable();
		JTable1.setBackground(new Color(255, 255, 255));
		JTable1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pid.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 0).toString());
				adate.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 1).toString());
				pname.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 2).toString());
				
				adoctor.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 4).toString());
				atime.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 5).toString());
				atype.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 6).toString());
				aproblem.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 7).toString());
				aphone.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 8).toString());
				
			}
		});
		scrollPane.setViewportView(JTable1);
		JTable1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "DATE", "NAME", "GENDER", "DOC NAME", "TIMING", "TYPE OF DOC", "PROBLEM", "PHONE"
			}
		));
		
		lblNewLabel_1 = new JLabel("APPOINTMENTS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(920, 36, 309, 58);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {String agender = (String)comboBox.getSelectedItem();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					String sql="insert into patientappointments values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, pid.getText());
					pts.setString(2, adate.getText());
					pts.setString(3, pname.getText());
					pts.setString(4, agender);
					pts.setString(5, adoctor.getText());
					pts.setString(6, atime.getText());
					pts.setString(7, atype.getText());
					pts.setString(8, aproblem.getText());
					pts.setString(9, aphone.getText());
				
					pname.requestFocus();
				
					 adate.setText("");
					 pname.setText("");
				
					 adoctor.setText("");
					 atime.setText("");
					 atype.setText("");
					 aproblem.setText("");
					 aphone.setText("");
					
					 String sqq="select dname from doctdetails where dname='"+doc.us+"'";
						PreparedStatement ptss1=con.prepareStatement(sqq);
						ResultSet rss= ptss1.executeQuery();
						while(rss.next()) {
							String V=rss.getString("dname");
							adoctor.setText(V);
							
						}
					
					

					
					pts.executeUpdate();
					 JOptionPane.showMessageDialog(null,"THE PATIENT'S APPOINTMENT HAS BEEN REGISTERED");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace()
;					}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(850, 131, 113, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("SHOW");
		btnNewButton_2_1.setBackground(new Color(0, 0, 255));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					Statement st=con.createStatement();
					String sql="select * from patientappointments";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					    DefaultTableModel dt=(DefaultTableModel)JTable1.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("pid"),rs.getString("adate"),rs.getString("pname"),rs.getString("agender"),rs.getString("adoctor"),rs.getString("atime"),rs.getString("atype"),rs.getString("aproblem"),rs.getString("aphone")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1.setBounds(850, 210, 113, 50);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("DELETE");
		btnNewButton_2_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=pid.getText();
				try {
			
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="delete from patientappointments WHERE pid='"+code+"'";
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.execute();
					JOptionPane.showMessageDialog(null,"THE PATIENT'S APPOINTMENT HAS BEEN DELETED");
				}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					
				}
			}
		});
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_2.setBounds(1020, 131, 113, 50);
		contentPane.add(btnNewButton_2_2);
		
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(1161, 10, 99, 30);
		contentPane.add(back);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String agender = (String)comboBox.getSelectedItem();
				doctor1=adoctor.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					String sql=("update patientappointments set adate=?,pname=?,agender=?,adoctor=?,atime=?,atype=?,aproblem=?,aphone=? where pid=?");
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.setString(1, adate.getText());
					pts.setString(2, pname.getText());
					pts.setString(3, agender);
					pts.setString(4, doctor1);
					pts.setString(5, atime.getText());
					pts.setString(6, atype.getText());
					pts.setString(7, aproblem.getText());
					pts.setString(8, aphone.getText());
					pts.setString(9, pid.getText());
				
					pname.requestFocus();
				
					 adate.setText("");
					 pname.setText("");
					
					 adoctor.setText("");
					 atime.setText("");
					 atype.setText("");
					 aproblem.setText("");
					 aphone.setText("");
					
					
					

					
					int i = pts.executeUpdate();
					if(i>0) {
					
					 JOptionPane.showMessageDialog(null,"it has been registered");
					 Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
						Statement st=conn.createStatement();
						String sqll="select * from patientappointments";
						
						PreparedStatement ptss=con.prepareStatement(sqll);
						ResultSet rs= ptss.executeQuery();
						    DefaultTableModel dt=(DefaultTableModel)JTable1.getModel();
						dt.setRowCount(0);
						while(rs.next()) {
						
						Object o[]= {rs.getString("pid"),rs.getString("adate"),rs.getString("pname"),rs.getString("agender"),rs.getString("adoctor"),rs.getString("atime"),rs.getString("atype"),rs.getString("aproblem"),rs.getString("aphone")};
						dt.addRow(o);
						}
					}}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace()
;					}
				
			}
		});
		btnNewButton.setBounds(1005, 208, 128, 50);
		contentPane.add(btnNewButton);
		
		btnShow = new JButton("SEARCH");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String query="select * from patientappointmets where pid=? ";
					PreparedStatement pts=conn.prepareStatement(query);
					pts.setString(1,search.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)JTable1.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("pid"),rs.getString("adate"),rs.getString("pname"),rs.getString("agender"),rs.getString("adoctor"),rs.getString("atime"),rs.getString("atype"),rs.getString("aproblem"),rs.getString("aphone")};
					dt.addRow(o);
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShow.setBackground(Color.CYAN);
		btnShow.setBounds(576, 629, 129, 49);
		contentPane.add(btnShow);
		
		lblSearchName = new JLabel("SEARCH  ID");
		lblSearchName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchName.setBounds(781, 648, 135, 13);
		contentPane.add(lblSearchName);
		
		search = new JTextField();
		search.setColumns(10);
		search.setBounds(903, 644, 169, 26);
		contentPane.add(search);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\1_4rpON7pS0x3zcWgBY1ZO-g.jpg"));
		lblNewLabel_2.setBounds(0, -25, 1294, 684);
		contentPane.add(lblNewLabel_2);
		JTable1.getColumnModel().getColumn(0).setPreferredWidth(37);
		JTable1.getColumnModel().getColumn(1).setPreferredWidth(56);
		JTable1.getColumnModel().getColumn(2).setPreferredWidth(105);
		JTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
		JTable1.getColumnModel().getColumn(4).setPreferredWidth(87);
		JTable1.getColumnModel().getColumn(5).setPreferredWidth(61);
		JTable1.getColumnModel().getColumn(6).setPreferredWidth(93);
		JTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
		JTable1.getColumnModel().getColumn(8).setPreferredWidth(81);
	}
}
