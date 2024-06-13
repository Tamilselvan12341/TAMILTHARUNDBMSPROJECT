package hospital;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class rooms extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField i;
	private JTextField j;
	private JLabel text;
	private JLabel lblName_1;
	private JLabel lblPhoneNo;
	private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JLabel lblRoomNo_1;
	private JTextField roomno;
	private JButton btnNewButton_1;
	private JTextField age;
	private JTextField address;
	private JLabel Gender;
	private JTextField gender;
	private JLabel Fees;
	private JTextField fees;
	private JLabel lblNewLabel;
	public static String fees2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rooms frame = new rooms();
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
	public rooms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fees2=fees.getText();				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					String sql="insert into roo values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.setString(1, i.getText());
					pts.setString(2, j.getText());
					pts.setString(3, id.getText());
					
					pts.setString(4, name.getText());
					
					
					pts.setString(5, age.getText());
					pts.setString(6, gender.getText());
					pts.setString(7, phone.getText());
					pts.setString(8, roomno.getText());
					pts.setString(9, fees2);
					

					
					i.requestFocus();
				
					 i.setText("");
					 j.setText("");
					 id.setText("");
					
					 name.setText("");
					 
					
					 
					 phone.setText("");
					 roomno.setText("");
					
					
					
					

					
					pts.executeUpdate();
					 JOptionPane.showMessageDialog(null,"THE ROOM HAS BEEN BOOKED FOR PARTICULAR PATIENT");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace();					}
				
				
				
				
			}
		});
		btnNewButton.setBounds(537, 208, 133, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblName = new JLabel("i");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(40, 63, 20, 29);
		contentPane.add(lblName);
		
		JLabel lblRoomNo = new JLabel("j");
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRoomNo.setBounds(180, 64, 30, 29);
		contentPane.add(lblRoomNo);
		
		i = new JTextField();
		i.setColumns(10);
		i.setBounds(70, 66, 70, 26);
		contentPane.add(i);
		
		j = new JTextField();
		j.setColumns(10);
		j.setBounds(200, 67, 70, 26);
		contentPane.add(j);
		
		text = new JLabel("ID");
		text.setFont(new Font("Tahoma", Font.BOLD, 15));
		text.setBounds(121, 140, 53, 29);
		contentPane.add(text);
		
		lblName_1 = new JLabel("NAME");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName_1.setBounds(121, 181, 53, 29);
		contentPane.add(lblName_1);
		
		lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNo.setBounds(121, 338, 104, 29);
		contentPane.add(lblPhoneNo);
		
		id = new JTextField();
		id.setBounds(245, 142, 187, 29);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(245, 183, 187, 29);
		contentPane.add(name);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(245, 340, 187, 29);
		contentPane.add(phone);
		
		lblRoomNo_1 = new JLabel("ROOM NO");
		lblRoomNo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRoomNo_1.setBounds(121, 377, 104, 29);
		contentPane.add(lblRoomNo_1);
		
		roomno = new JTextField();
		roomno.setColumns(10);
		roomno.setBounds(245, 379, 187, 29);
		contentPane.add(roomno);
		
		btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=i.getText();
				String code1=j.getText();
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="delete from roo WHERE i='"+code+"' and j='"+code1+"'";
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.execute();
					JOptionPane.showMessageDialog(null,"THE ROOM HAS BEEN VACATED");
					
						
				}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
					
				}
			}
			
		});
		btnNewButton_1.setBounds(537, 312, 133, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel Age = new JLabel("AGE");
		Age.setFont(new Font("Tahoma", Font.BOLD, 15));
		Age.setBounds(121, 218, 53, 29);
		contentPane.add(Age);
		
		JLabel Address = new JLabel("ADDRESS");
		Address.setFont(new Font("Tahoma", Font.BOLD, 15));
		Address.setBounds(121, 299, 73, 29);
		contentPane.add(Address);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(245, 220, 187, 29);
		contentPane.add(age);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(245, 301, 187, 29);
		contentPane.add(address);
		
		Gender = new JLabel("GENDER");
		Gender.setFont(new Font("Tahoma", Font.BOLD, 15));
		Gender.setBounds(121, 260, 73, 29);
		contentPane.add(Gender);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(245, 262, 187, 29);
		contentPane.add(gender);
		
		Fees = new JLabel("EXTRA FEES");
		Fees.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fees.setBounds(121, 416, 104, 29);
		contentPane.add(Fees);
		
		fees = new JTextField();
		fees.setColumns(10);
		fees.setBounds(245, 418, 187, 29);
		contentPane.add(fees);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(784, 10, 104, 34);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\hospital-wallpapers.jpg"));
		lblNewLabel.setBounds(0, 0, 915, 551);
		contentPane.add(lblNewLabel);
	}
}
