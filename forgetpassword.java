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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class forgetpassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField newpass;
	private JPasswordField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgetpassword frame = new forgetpassword();
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
	public forgetpassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(109, 115, 166, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("NEW PASSWORD");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewPassword.setBounds(109, 197, 166, 33);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblConfirmPassword.setBounds(109, 280, 219, 33);
		contentPane.add(lblConfirmPassword);
		
		user = new JTextField();
		user.setBounds(336, 115, 183, 30);
		contentPane.add(user);
		user.setColumns(10);
		
		newpass = new JPasswordField();
		newpass.setBounds(336, 196, 183, 33);
		contentPane.add(newpass);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(336, 280, 183, 33);
		contentPane.add(confirmpass);
		
		final JButton confirm = new JButton("CONFIRM");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i=1;
					String us1 = user.getText();
					String np = newpass.getText();	
					String cp = confirmpass.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					Statement st1 = con1.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					System.out.println(us1);
					System.out.println(np);
					System.out.println(cp);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
						if(us1.equals(use1) && np.equals(cp)) {
							String sql2 = "update access set password = '"+np+"' where id = '"+i+"'";
							PreparedStatement pts = con1.prepareStatement(sql2);
							System.out.print(np);
						    
							System.out.println("2");
							pts.executeUpdate(sql2);
							System.out.print("success");
							JOptionPane.showMessageDialog(confirm, " data updated", "updated", -1);
							try {
								loginpage frame = new loginpage();
								frame.setVisible(true);
								SwingUtilities.windowForComponent(confirm).dispose();
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(confirm, this, "Error while establishing connection failed", 0);
							}
						}
						else {
						     user.setText("");
						     newpass.setText("");
						     confirmpass.setText("");
						}
						i++;
					}
					}
					catch(Exception os)
					{
						System.out.print(os);
						JOptionPane.showMessageDialog(confirm, this, "Error while establishing connection failed", 0);
					}
			}
		});
		confirm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		confirm.setBounds(275, 363, 115, 39);
		contentPane.add(confirm);
		
		JLabel lblForgetPassword = new JLabel("FORGET PASSWORD");
		lblForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblForgetPassword.setBounds(275, 39, 244, 33);
		contentPane.add(lblForgetPassword);
	}
}
