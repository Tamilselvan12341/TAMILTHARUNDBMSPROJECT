package hospital;
import hospital.log1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class dashboard1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard1 frame = new dashboard1();
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
	public dashboard1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 661);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 73, 459, 515);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JButton admission = new JButton("ADMISSION");
		admission.setBackground(Color.LIGHT_GRAY);
		admission.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		admission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admission frame = new admission();
				frame.setVisible(true);
			}
		});
		admission.setBounds(43, 152, 209, 52);
		panel.add(admission);
		
		JButton appointment = new JButton("DOC DETAILS AND APPOINTMENTS");
		appointment.setBackground(Color.LIGHT_GRAY);
		appointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doc frame = new doc();
				frame.setVisible(true);
			}
		});
		appointment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		appointment.setBounds(43, 69, 389, 61);
		panel.add(appointment);
		
		JButton details = new JButton("PATIENTS DETAILS");
		details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientsDetails frame = new PatientsDetails();
				frame.setVisible(true);
			}
		});
		details.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		details.setBackground(Color.LIGHT_GRAY);
		details.setBounds(46, 230, 318, 54);
		panel.add(details);
		
		JButton records = new JButton("PATIENTS RECORDS");
		records.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientsRecords frame = new PatientsRecords();
				frame.setVisible(true);
			}
		});
		records.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		records.setBackground(Color.LIGHT_GRAY);
		records.setBounds(46, 312, 318, 54);
		panel.add(records);
		
		JButton DIS = new JButton("ROOM DETAILS");
		DIS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			discharge frame = new discharge();
				frame.setVisible(true);
			}
		});
		DIS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		DIS.setBackground(Color.LIGHT_GRAY);
		DIS.setBounds(43, 394, 389, 54);
		panel.add(DIS);
		
		JLabel lblNewLabel = new JLabel("RECEPTIONIST");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(139, 24, 163, 25);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 0, 459, 515);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JButton appo = new JButton(" APPOINTMENTS DETAILS");
		appo.setBackground(Color.LIGHT_GRAY);
		appo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APPOINTMENTDETAILS frame = new APPOINTMENTDETAILS();
				frame.setVisible(true);
			}
		});
		appo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		appo.setBounds(55, 56, 331, 61);
		panel_1.add(appo);
		
		JButton patdet = new JButton("PATIENTS DETAILS");
		patdet.setBackground(Color.LIGHT_GRAY);
		patdet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PATIENTDETAILS frame = new PATIENTDETAILS();
				frame.setVisible(true);
			}
		});
		patdet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		patdet.setBounds(55, 143, 331, 61);
		panel_1.add(patdet);
		
		JButton rec = new JButton("PATIENTS RECORDS");
		rec.setBackground(Color.LIGHT_GRAY);
		rec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PATIENTRECORDS frame = new PATIENTRECORDS();
				frame.setVisible(true);
			}
		});
		rec.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rec.setBounds(55, 230, 331, 61);
		panel_1.add(rec);
		
		JButton pres = new JButton("PRESCRIPTION");
		pres.setBackground(Color.LIGHT_GRAY);
		pres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prescription frame = new prescription();
				frame.setVisible(true);
			}
		});
	
		pres.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		pres.setBounds(55, 323, 331, 61);
		panel_1.add(pres);
		
		JLabel lblNewLabel_1 = new JLabel("DOCTOR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(167, 10, 135, 24);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 10, 430, 510);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);
		
		JLabel OO = new JLabel("CASHIER");
		OO.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		OO.setBounds(165, 23, 135, 24);
		panel_3.add(OO);
		
		JButton btnBillAmount = new JButton("BILL AMOUNT");
		btnBillAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AMOUNT frame = new AMOUNT();
				frame.setVisible(true);
				
			}
		});
		btnBillAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnBillAmount.setBackground(Color.LIGHT_GRAY);
		btnBillAmount.setBounds(59, 99, 318, 54);
		panel_3.add(btnBillAmount);
		
		JLabel lblNewLabel_1_2 = new JLabel("USERNAME");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(517, 147, 160, 40);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("USER TYPE");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(517, 222, 160, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel username = new JLabel("");
		username.setForeground(new Color(255, 255, 255));
		username.setFont(new Font("Tahoma", Font.BOLD, 20));
		username.setBounds(661, 147, 160, 40);
		contentPane.add(username);
		
		JLabel usertype = new JLabel("");
		usertype.setForeground(new Color(255, 255, 255));
		usertype.setFont(new Font("Tahoma", Font.BOLD, 20));
		usertype.setBounds(661, 222, 160, 40);
		contentPane.add(usertype);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.PINK);
		panel_1_1.setBounds(10, 73, 459, 515);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		panel_1_1.setVisible(false);
		
		
		JButton appodet = new JButton(" APPOINTMENTS DETAILS");
		appodet.setBackground(Color.LIGHT_GRAY);
		appodet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APPOINTMENTDETAILS frame = new APPOINTMENTDETAILS();
				frame.setVisible(true);
			
			}
		});
		appodet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		appodet.setBounds(51, 69, 331, 61);
		panel_1_1.add(appodet);
		
		JButton btnPatientsDetails_1 = new JButton("PATIENTS DETAILS");
		btnPatientsDetails_1.setBackground(Color.LIGHT_GRAY);
		btnPatientsDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PATIENTDETAILS frame = new PATIENTDETAILS();
				frame.setVisible(true);
				
				
			}
		});
		btnPatientsDetails_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnPatientsDetails_1.setBounds(51, 154, 341, 61);
		panel_1_1.add(btnPatientsDetails_1);
		
		JButton btnPatientsRecords_1 = new JButton("PATIENTS RECORDS");
		btnPatientsRecords_1.setBackground(Color.LIGHT_GRAY);
		btnPatientsRecords_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PATIENTRECORDS frame = new PATIENTRECORDS();
				frame.setVisible(true);
			
				
			}
		});
		btnPatientsRecords_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnPatientsRecords_1.setBounds(51, 240, 331, 61);
		panel_1_1.add(btnPatientsRecords_1);
		
		JButton btnPrescriptionDetails = new JButton("PRESCRIPTION DETAILS");
		btnPrescriptionDetails.setBackground(Color.LIGHT_GRAY);
		btnPrescriptionDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PRESCRIPTIONDETAILS frame = new PRESCRIPTIONDETAILS();
				frame.setVisible(true);
				
			}
		});
		btnPrescriptionDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnPrescriptionDetails.setBounds(51, 330, 331, 61);
		panel_1_1.add(btnPrescriptionDetails);
		
		JLabel lblNewLabel_1_1 = new JLabel("PATIENT");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(152, 21, 135, 24);
		panel_1_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(0, 10, 459, 505);
		panel_1_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		JButton btnPrescriptionDetails_1 = new JButton("PRESCRIPTION DETAILS");
		btnPrescriptionDetails_1.setBackground(Color.LIGHT_GRAY);
		btnPrescriptionDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PRESCRIPTIONDETAILS   frame = new PRESCRIPTIONDETAILS();
				frame.setVisible(true);
				
			}
		});
		btnPrescriptionDetails_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnPrescriptionDetails_1.setBounds(67, 292, 331, 61);
		panel_2.add(btnPrescriptionDetails_1);
		
		JButton btnPrescriptionDetails_1_1 = new JButton("ORDER");
		btnPrescriptionDetails_1_1.setBackground(Color.LIGHT_GRAY);
		btnPrescriptionDetails_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	ORDER    frame = new ORDER();
				frame.setVisible(true);
				SwingUtilities.windowForComponent(btnPrescriptionDetails_1_1).dispose();
			}
		});
		btnPrescriptionDetails_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnPrescriptionDetails_1_1.setBounds(67, 129, 331, 61);
		panel_2.add(btnPrescriptionDetails_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("PHARMIST");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(167, 28, 135, 24);
		panel_2.add(lblNewLabel_1_3);

		
		JButton btnNewButton = new JButton("CHECK");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					
					
					
				
					

					
				
					String sq="select username,usertype from access where username='"+log1.us+"'";
					PreparedStatement ptss=con.prepareStatement(sq);
					ResultSet rs= ptss.executeQuery();
					while(rs.next()) {
						String b=rs.getString("username");
						username.setText(b);
						String a=rs.getString("usertype");
						usertype.setText(a);
						
						
						
					}
					if(usertype.getText().equals("RECEPTIONIST")) {
						
						contentPane.add(panel);
						panel.setVisible(true);
					}
					else if(usertype.getText().equals("PATIENT")) {
						contentPane.add(panel_1_1);
						panel_1_1.setVisible(true);
					}
					else if(usertype.getText().equals("DOCTOR")) {
						contentPane.add(panel_1);
						panel_1.setVisible(true);
					}
					else if(usertype.getText().equals("PHARMIST")){
						contentPane.add(panel_2);
						panel_2.setVisible(true);
					}
					else if(usertype.getText().equals("CASHIER")){
						contentPane.add(panel_3);
						panel_3.setVisible(true);
					}
					else {
						System.out.print("invalid");
					}
					
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace()
;					}
			}
		});
		btnNewButton.setBounds(595, 290, 160, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NEW USER");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginpage frame = new loginpage();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(581, 504, 160, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("LOGINPAGE");
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log1 frame = new log1();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(581, 566, 160, 40);
		contentPane.add(btnNewButton_1_1);
		
		JButton DIS_1 = new JButton("DISCHARGE ");
		DIS_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rooms frame = new rooms();
				frame.setVisible(true);
				
			
				
				
			}
		});
		DIS_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		DIS_1.setBackground(Color.LIGHT_GRAY);
		DIS_1.setBounds(750, 105, 247, 54);
		contentPane.add(DIS_1);
		
		JButton DIS_1_1 = new JButton("DISCHARGE DETAILS");
		DIS_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TAMILTHARUN frame = new TAMILTHARUN();
				frame.setVisible(true);
				
			}
		});
		DIS_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		DIS_1_1.setBackground(Color.LIGHT_GRAY);
		DIS_1_1.setBounds(708, 26, 289, 54);
		contentPane.add(DIS_1_1);
		
		JButton btnNewButton_1_2 = new JButton("REPORT");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				umm frame = new umm();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setBounds(837, 504, 160, 40);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("ALL DETAILS");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tharun frame = new Tharun();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2_1.setBounds(837, 392, 160, 40);
		contentPane.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\pngtree-colorful-particle-glow-an-extravagant-3d-space-tunnel-vfx-background-picture-image_5823100.jpg"));
		lblNewLabel_2.setBounds(0, -5, 1052, 634);
		contentPane.add(lblNewLabel_2);
		
		
		
				
		
	}
}
