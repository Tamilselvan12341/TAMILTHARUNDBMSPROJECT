package hospital;
import hospital.PatientsDetails;
import hospital.admission;
import hospital.ORDER;
import hospital.rooms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.ImageIcon;

public class AMOUNT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField docfees;
	private JTextField roomfees;
	private JTextField extrafees;
	private JTextField id;
	public static String name1;
	public static String date1;
	public static String doc1;
	public static String room1;
	public static String extra1;
	public static String e1;
	public static String t;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AMOUNT frame = new AMOUNT();
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
	public AMOUNT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T T  HOSPITAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(189, 33, 276, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblPatientsName = new JLabel("PATIENT'S NAME");
		lblPatientsName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatientsName.setBounds(62, 177, 187, 28);
		contentPane.add(lblPatientsName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(237, 177, 174, 28);
		contentPane.add(name);
		name.setText(""+PatientsDetails.name2);
		
		JLabel lblDoctorFees = new JLabel("DOCTOR FEES");
		lblDoctorFees.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoctorFees.setBounds(62, 240, 187, 28);
		contentPane.add(lblDoctorFees);
		
		JLabel lblRoomFees = new JLabel("ROOM FEES");
		lblRoomFees.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRoomFees.setBounds(62, 297, 187, 28);
		contentPane.add(lblRoomFees);
		
		JLabel lblExtraFees = new JLabel("EXTRA FEES");
		lblExtraFees.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblExtraFees.setBounds(62, 355, 187, 28);
		contentPane.add(lblExtraFees);
		
		docfees = new JTextField();
		docfees.setColumns(10);
		docfees.setBounds(237, 240, 174, 28);
		contentPane.add(docfees);
		docfees.setText(""+PatientsDetails.fees1);

		
		roomfees = new JTextField();
		roomfees.setColumns(10);
		roomfees.setBounds(237, 297, 174, 28);
		contentPane.add(roomfees);
		roomfees.setText(""+rooms.fees2);
		
		extrafees = new JTextField();
		extrafees.setColumns(10);
		extrafees.setBounds(237, 355, 174, 28);
		contentPane.add(extrafees);
		extrafees.setText(""+t);
		
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				name1=name.getText();
				doc1=docfees.getText();
				room1=roomfees.getText();
				extra1=extrafees.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="INSERT INTO medical_bills (name,doc_fees,room_fees,extra_fees) VALUES (?,?,?,?)";
						
					PreparedStatement pts=con.prepareStatement(sql);
					
				
					pts.setString(1, name1);
					pts.setString(2, doc1);
					pts.setString(3, room1);
					pts.setString(4, extra1);
					
				
					name.requestFocus();
				   
					docfees.setText("");
				    roomfees.setText("");
				    extrafees.setText("");
					
					
					
					
					
					String sq="select pname,tot from patientdetails WHERE pname='"+admission.name1+"'";
					PreparedStatement ptss=con.prepareStatement(sq);
					ResultSet rs= ptss.executeQuery();
					while(rs.next()) {
						String b=rs.getString("tot");
						docfees.setText(b);
						String y=rs.getString("pname");
						name.setText(y);
						
					}
					
					String sqq="select fees from roo_backup WHERE name='"+admission.name1+"'";
					PreparedStatement ptsss=con.prepareStatement(sqq);
					ResultSet rss= ptsss.executeQuery();
					while(rss.next()) {
						String a=rss.getString("fees");
						roomfees.setText(a);
						
					}
					
				
					
					pts.executeUpdate();
				
					 JOptionPane.showMessageDialog(null,"THE PATIENT'S RECORDS HAS BEEN REGISTERED");
						
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace();					}
			}
		});
		btnNewButton.setBounds(432, 414, 138, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(451, 126, 64, 13);
		contentPane.add(lblId);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(484, 119, 86, 28);
		contentPane.add(id);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
			String sqq22="select tot_amount from prescriptionview where name= '"+admission.name1+"' ";
			PreparedStatement pts22=con.prepareStatement(sqq22);
			
			ResultSet rs22=pts22.executeQuery();
			
			while(rs22.next()) {
			
				t= rs22.getString("tot_amount");
			    extrafees.setText(""+t);
			}
	}
			
		catch(Exception ex) {
			ex.printStackTrace();}
	
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(559, 10, 99, 30);
		contentPane.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\tharun\\OneDrive\\Documents\\desktop-wallpaper-website-background-website-login-page-background.jpg"));
		lblNewLabel_1.setBounds(0, -44, 668, 589);
		contentPane.add(lblNewLabel_1);
	}

}
