package hospital;
import hospital.dashboard;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class log1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	public static String username;
	public static String usertype;
	
	public static String us;
	public static String ts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log1 frame = new log1();
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
	public log1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel error = new JLabel("");
		error.setBounds(152, 244, 114, 21);
		contentPane.add(error);
		
		JLabel user1 = new JLabel("USERNAME");
		user1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		user1.setBounds(152, 120, 123, 39);
		contentPane.add(user1);
		
		JLabel pass1 = new JLabel("PASSWORD");
		pass1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		pass1.setBounds(152, 201, 123, 37);
		contentPane.add(pass1);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBackground(SystemColor.menu);
		user.setBounds(312, 122, 167, 34);
		contentPane.add(user);
		
		pass = new JPasswordField();
		pass.setBackground(SystemColor.menu);
		pass.setBounds(312, 202, 167, 34);
		contentPane.add(pass);
		
		JLabel user1_1 = new JLabel("USERTYPE ");
		user1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		user1_1.setBounds(152, 275, 123, 39);
		contentPane.add(user1_1);
		
		JComboBox combobox = new JComboBox();
		combobox.setModel(new DefaultComboBoxModel(new String[] {"DOCTOR", "RECEPTIONIST", "PATIENT", "PHARMIST", "CASHIER"}));
		combobox.setFont(new Font("Tahoma", Font.BOLD, 12));
		combobox.setBounds(312, 277, 167, 36);
		contentPane.add(combobox);
		
		JButton btnNewButton_1 = new JButton("LOG-IN");
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usertype = (String)combobox.getSelectedItem();
				
				try {
					int er = 0;
					
					 us = user.getText();
					//@SuppressWarnings("deprecation")
					String ps = pass.getText();
					
					 ts = usertype;
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println(ps);
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					Statement st = con.createStatement();
					System.out.println("1");
					String sql = "Select username,password,usertype from access";
					System.out.println("1");
					ResultSet rs = st.executeQuery(sql);
					PreparedStatement pts=con.prepareStatement(sql);
					System.out.println("1");
					while(rs.next()){
					String username = rs.getString("username");
					System.out.println("1-");
					String password = rs.getString("password");
					String usertype1 = rs.getString("usertype");
					
					System.out.println("1-");

					if(us.equals(username) && ps.equals(password) && ts.equals(usertype1)){
				    JOptionPane.showMessageDialog(btnNewButton_1, "NO ERROR", "LOGIN SUCCESSFUL",-1);
				   
				    dashboard1 frame = new dashboard1();
					frame.setVisible(true);
					dispose();
					
					
				
					
					System.out.println("true");
				
					
					
					
					er=0;
					}
					else{
						
					user.setText("");
					pass.setText("");
					System.out.println("false");
					er=1;
					
					}}
					if(er==1) {
						error.setText("invalid");
					}
					
					}
					
				
					
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed",-1);
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(271, 359, 105, 30);
		contentPane.add(btnNewButton_1);
		
		JRadioButton PASS = new JRadioButton("SHOW PASSWORD");
		PASS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PASS.isSelected()) {
					pass.setEchoChar((char)0);
				}
				else {
					pass.setEchoChar('*');
				}
			}
		});
		PASS.setFont(new Font("Tahoma", Font.BOLD, 10));
		PASS.setBounds(494, 211, 123, 21);
		contentPane.add(PASS);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\hospital.png"));
		lblNewLabel.setBounds(278, 31, 71, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\user (1).png"));
		lblNewLabel_1.setBounds(112, 120, 30, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\padlock.png"));
		lblNewLabel_2.setBounds(112, 201, 30, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\medical-team.png"));
		lblNewLabel_3.setBounds(492, 277, 30, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\tharun\\OneDrive\\Documents\\hjj.jpg"));
		lblNewLabel_4.setForeground(SystemColor.activeCaption);
		lblNewLabel_4.setBounds(0, 10, 655, 493);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblHospital = new JLabel("HOSPITAL");
		lblHospital.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblHospital.setBounds(432, 5, 223, 79);
		contentPane.add(lblHospital);
		
		JLabel lblTt = new JLabel("T T ");
		lblTt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblTt.setBounds(121, 3, 92, 79);
		contentPane.add(lblTt);
	}
}
