package hospital;
import hospital.admission;
import hospital.doc;


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
import javax.swing.ImageIcon;
import java.awt.Color;

public class prescription extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField iid;
	private JTextField name;
	private JTextField docc;
	public static String id1;
	public static String name1;
	public static String doc1;
	public static String description1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prescription frame = new prescription();
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
	public prescription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDocName = new JLabel("DOC NAME               :");
		lblDocName.setForeground(Color.BLACK);
		lblDocName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDocName.setBounds(95, 245, 204, 28);
		contentPane.add(lblDocName);
		
		JLabel id = new JLabel("ID                              :");
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Tahoma", Font.BOLD, 18));
		id.setBounds(93, 109, 204, 28);
		contentPane.add(id);
		
		iid = new JTextField();
		iid.setColumns(10);
		iid.setBounds(324, 113, 174, 28);
		contentPane.add(iid);
		iid.setText(""+admission.id1);
		
		JLabel lblPatientsName = new JLabel("PATIENT'S NAME    :");
		lblPatientsName.setForeground(Color.BLACK);
		lblPatientsName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatientsName.setBounds(95, 176, 202, 28);
		contentPane.add(lblPatientsName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(324, 180, 174, 28);
		contentPane.add(name);
		name.setText(""+admission.name1);
		
		docc = new JTextField();
		docc.setColumns(10);
		docc.setBounds(324, 249, 174, 28);
		contentPane.add(docc);
		docc.setText(""+doc.us);
		
		JLabel lblDescription = new JLabel("DESCRIPTION         :");
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDescription.setBounds(93, 323, 204, 28);
		contentPane.add(lblDescription);
		
		JTextPane description = new JTextPane();
		description.setBackground(new Color(227, 227, 227));
		description.setForeground(new Color(0, 0, 0));
		description.setBounds(322, 331, 313, 148);
		contentPane.add(description);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id1=iid.getText();
				name1=name.getText();
				doc1=docc.getText();
				description1=description.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="insert into prescription values(?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, id1);
					pts.setString(2, name1);
					pts.setString(3, doc1);
					pts.setString(4, description1);
					
					
				
					name.requestFocus();
					iid.setText("");
					name.setText("");
				    docc.setText("");
					description.setText("");
				  
					
					
					String sq="select id,name from admission";
					PreparedStatement ptss=con.prepareStatement(sq);
					ResultSet rs= ptss.executeQuery();
					while(rs.next()) {
						String b=rs.getString("id");
						iid.setText(b);

						String a=rs.getString("name");
					    name.setText(a);
						
					}
					
					 String sqq="select dname from doctdetails where dname='"+doc.us+"'";
						PreparedStatement ptss1=con.prepareStatement(sqq);
						ResultSet rss= ptss1.executeQuery();
						while(rss.next()) {
							String b=rss.getString("dname");
							docc.setText(b);
							
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
		btnNewButton.setBounds(513, 507, 122, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblPrescriptionDetails = new JLabel("PRESCRIPTION DETAILS");
		lblPrescriptionDetails.setForeground(Color.BLACK);
		lblPrescriptionDetails.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblPrescriptionDetails.setBounds(176, 28, 399, 49);
		contentPane.add(lblPrescriptionDetails);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(594, 576, 99, 30);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tharun\\OneDrive\\Documents\\6e84a60d8e914a96760f2f92e01be3c5.png"));
		lblNewLabel.setBounds(0, 0, 749, 637);
		contentPane.add(lblNewLabel);
	}
}
