package hospital;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class loginpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField user;
	private JPasswordField pass;
	private JLabel error;
	private JTextField name;
	private JTextField id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
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
	public loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBackground(Color.LIGHT_GRAY);
		id.setBounds(52, 31, 81, 39);
		contentPane.add(id);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblId.setBounds(10, 34, 123, 39);
		contentPane.add(lblId);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBackground(Color.LIGHT_GRAY);
		name.setBounds(340, 102, 167, 39);
		contentPane.add(name);
		
		JComboBox combobox = new JComboBox();
		combobox.setFont(new Font("Tahoma", Font.BOLD, 12));
		combobox.setModel(new DefaultComboBoxModel(new String[] {"DOCTOR", "RECEPTIONIST", "PATIENT", "PHARMIST", "CASHIER"}));
		combobox.setBounds(340, 250, 167, 36);
		contentPane.add(combobox);
		
		JLabel user1_1 = new JLabel("USERTYPE ");
		user1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		user1_1.setBounds(166, 247, 123, 39);
		contentPane.add(user1_1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(166, 102, 123, 39);
		contentPane.add(lblName);
		
		JLabel user1 = new JLabel("USERNAME");
		user1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		user1.setBounds(166, 151, 123, 39);
		contentPane.add(user1);
		
		JLabel pass1 = new JLabel("PASSWORD");
		pass1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		pass1.setBounds(166, 200, 123, 37);
		contentPane.add(pass1);
		
		user = new JTextField();
		user.setBackground(new Color(192, 192, 192));
		user.setBounds(340, 150, 167, 39);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBackground(new Color(192, 192, 192));
		pass.setBounds(340, 201, 167, 39);
		contentPane.add(pass);
		
		final JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(52, 405, 104, -12);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String)combobox.getSelectedItem();
				
				try {
					int c=0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");

					Statement st1 = con.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					System.out.println("1");
					
					System.out.println("2");
					String sql2 = "SELECT COUNT(*) AS count FROM access";
					
				
					PreparedStatement ps2 = con.prepareStatement(sql2);
					System.out.println("4");
					ResultSet res2 = ps2.executeQuery();
					System.out.println("5");
					String input = pass.getText();
					int inputLen = input.length();
					int uppercount=0;
					int lowercount=0;
		        	int digitcount=0;
					for(int j =0; j < inputLen ; j++)
					{
						char ch = input.charAt(j);
						if (Character.isUpperCase(ch))
							uppercount++;
						else if (Character.isLowerCase(ch))
							lowercount++;
						else if (Character.isDigit(ch))
							digitcount++;
					}
					System.out.print(uppercount);
					System.out.print(lowercount);
					System.out.print(digitcount);
					while(res2.next())
					{ c = res2.getInt(1);
					 System.out.print(c);}
					c+=1;
					while(res1.next()) {
						String use1 = res1.getString("username");
						if(  uppercount >= 1 && lowercount >= 3 && digitcount >=1) {
							
					String sql="insert into access (name,username,password,usertype) values(?,?,?,?)";
					
					PreparedStatement pts=con.prepareStatement(sql);

					pts.setString(1, name.getText());
					pts.setString(2, user.getText());
					pts.setString(3, pass.getText());
					pts.setString(4, type);
					
					 id.setText("");
					 name.setText("");
					
					 user.setText("");
					 pass.setText("");
					
					
					pts.executeUpdate();


					JOptionPane.showMessageDialog(null,"Acount has been registered");
						}
						
						break;
						
					}
					 
					
				
				}
				catch(Exception eX) {
				eX.printStackTrace();	
				}
			}
		});
		btnNewButton_1.setBounds(649, 130, 144, 39);
		contentPane.add(btnNewButton_1);
		
		final JButton newuser = new JButton("BACK");
		newuser.setBackground(new Color(255, 128, 64));
		newuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log1 frame = new log1();
				frame.setVisible(true);
				dispose();
			}
		});
		newuser.setBounds(20, 356, 104, 39);
		contentPane.add(newuser);
		
		final JButton forget = new JButton("E MAIL");
		forget.setBackground(new Color(255, 128, 64));
		forget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email frame = new email();
				frame.setVisible(true);
				dispose();
				
			}
		});
		forget.setBounds(622, 354, 174, 39);
		contentPane.add(forget);
		
		final JRadioButton PASS = new JRadioButton("SHOW PASSWORD");
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
		PASS.setBounds(659, 210, 123, 21);
		contentPane.add(PASS);
		
		 error = new JLabel("");
		 error.setForeground(new Color(255, 0, 0));
		error.setBounds(176, 176, 92, 13);
		contentPane.add(error);
		
		JLabel lblTt = new JLabel("T T ");
		lblTt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblTt.setBounds(290, 1, 92, 79);
		contentPane.add(lblTt);
		
		JLabel lblHospital = new JLabel("HOSPITAL");
		lblHospital.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblHospital.setBounds(392, 3, 223, 79);
		contentPane.add(lblHospital);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tharun\\Music\\New folder (9)\\bba-in-hospital-management (3).jpg"));
		lblNewLabel.setBounds(0, -9, 829, 434);
		contentPane.add(lblNewLabel);
	}
}

