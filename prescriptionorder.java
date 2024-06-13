package hospital;
import hospital.prescription;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ORDER extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idd;
	private JTextField name;
	private JTextField dname;
	private JTextField amount;
	private JTextField quantity;
	public static String amount1;
	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ORDER frame = new ORDER();
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
	public ORDER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(0, 51, 255));
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 919, 647);
		contentPane.add(contentPane_1);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Tahoma", Font.BOLD, 18));
		id.setBounds(54, 66, 83, 28);
		contentPane_1.add(id);
		
		idd = new JTextField();
		idd.setColumns(10);
		idd.setBounds(104, 66, 147, 28);
		contentPane_1.add(idd);
		idd.setText(""+prescription.id1);
		
		JLabel lblPatientsName = new JLabel("PATIENT'S NAME");
		lblPatientsName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatientsName.setBounds(54, 120, 187, 28);
		contentPane_1.add(lblPatientsName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(239, 124, 174, 28);
		contentPane_1.add(name);
		name.setText(""+prescription.name1);
		
		JLabel lblDocName = new JLabel("DOC NAME");
		lblDocName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDocName.setBounds(54, 178, 187, 28);
		contentPane_1.add(lblDocName);
		
		dname = new JTextField();
		dname.setColumns(10);
		dname.setBounds(239, 178, 174, 28);
		contentPane_1.add(dname);
		dname.setText(""+prescription.doc1);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDescription.setBounds(54, 246, 187, 28);
		contentPane_1.add(lblDescription);
		
		JTextPane description = new JTextPane();
		description.setBounds(239, 235, 313, 148);
		contentPane_1.add(description);
		description.setText(""+prescription.description1);
		
		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAmount.setBounds(64, 469, 187, 28);
		contentPane_1.add(lblAmount);
		
		amount = new JTextField();
		amount.setText("\r\n");
		amount.setColumns(10);
		amount.setBounds(239, 473, 174, 28);
		contentPane_1.add(amount);
		
		JButton btnPlace = new JButton("PLACE");
		btnPlace.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				amount1=amount.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="insert into prescriptionview (id,name,docname,description,quantity,amount) values(?,?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, idd.getText());
					pts.setString(2, name.getText());
					pts.setString(3, dname.getText());
					pts.setString(4, description.getText());
					pts.setString(5, quantity.getText());
					pts.setString(6, amount1);
									
					idd.requestFocus();
					name.setText("");
					dname.setText("");
					description.setText("");
					quantity.setText("");
					amount.setText("");
				  
					
					
					
					String sq="select id,name,docname,description from prescription where name='"+prescription.name1+"'";
					PreparedStatement ptss=con.prepareStatement(sq);
					ResultSet rs= ptss.executeQuery();
					while(rs.next()) {
						String b=rs.getString("id");
						idd.setText(b);

						String a=rs.getString("name");
					    name.setText(a);
					    String t=rs.getString("docname");
					    dname.setText(t);
					    String u=rs.getString("description");
					    description.setText(t);
					   
						
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
		btnPlace.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPlace.setBounds(522, 438, 207, 47);
		contentPane_1.add(btnPlace);
		
		JLabel lblPrescriptionDetails = new JLabel("PRESCRIPTION DETAILS");
		lblPrescriptionDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblPrescriptionDetails.setBounds(317, 10, 399, 49);
		contentPane_1.add(lblPrescriptionDetails);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setBounds(64, 402, 187, 28);
		contentPane_1.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setText("\r\n");
		quantity.setColumns(10);
		quantity.setBounds(239, 406, 174, 28);
		contentPane_1.add(quantity);
		
		JButton back_1 = new JButton("BACK");
		back_1.setBounds(759, 63, 99, 30);
		contentPane_1.add(back_1);
		back_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\oGi5iSDLr4XauJnqXg6rKb-1200-80.png"));
		lblNewLabel.setBounds(0, 10, 919, 647);
		contentPane_1.add(lblNewLabel);
	}
}
