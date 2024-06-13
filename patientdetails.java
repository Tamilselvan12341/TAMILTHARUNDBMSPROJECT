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
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
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

public class PatientsDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pname;
	private JTextField psugar;
	private JTextField pop;
	private JTextField ppressure;
	private JTextField pphone;
	private JTextField pblood;
	private JTextField paddress;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField pid;
	private JTable JTable1;
	private JButton back;
	private JButton btnNewButton_3;
	private JButton bsearch;
	private JLabel lblSearchName;
	private JTextField search;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JTextField tot;
	public static String fees1;
	private JTextField docname;
	public static String name2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientsDetails frame = new PatientsDetails();
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
	public PatientsDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
			docname = new JTextField();
			docname.setColumns(10);
			docname.setBounds(463, 91, 174, 28);
			contentPane.add(docname);
			docname.setText(""+doc.us);
			
			JLabel lblDocName = new JLabel("DOC NAME");
			lblDocName.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblDocName.setBounds(463, 53, 187, 28);
			contentPane.add(lblDocName);
			
			paddress = new JTextField();
			paddress.setColumns(10);
			paddress.setBounds(237, 325, 233, 28);
			contentPane.add(paddress);
			paddress.setText(""+admission.address1);
			
			
			pname = new JTextField();
			pname.setColumns(10);
			pname.setBounds(42, 167, 174, 28);
			contentPane.add(pname);
			pname.setText(""+admission.name1);
			
			pphone = new JTextField();
			pphone.setColumns(10);
			pphone.setBounds(238, 167, 174, 28);
			contentPane.add(pphone);
			pphone.setText(""+admission.phone1);
		
			
			pid = new JTextField();
			pid.setColumns(10);
			pid.setBounds(42, 91, 147, 28);
			contentPane.add(pid);
			pid.setText(""+admission.id1);
		
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(43, 249, 173, 28);
		contentPane.add(comboBox);
		
		JLabel lblPatientsName = new JLabel("PATIENT'S NAME");
		lblPatientsName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatientsName.setBounds(43, 129, 187, 28);
		contentPane.add(lblPatientsName);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(43, 211, 187, 28);
		contentPane.add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBloodGroup.setBounds(43, 287, 187, 28);
		contentPane.add(lblBloodGroup);
		
		JLabel lblAddress = new JLabel("ADDRESS\r\n");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(240, 287, 187, 28);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhoneNo.setBounds(240, 129, 187, 28);
		contentPane.add(lblPhoneNo);
		
		JLabel lblSugar = new JLabel("SUGAR");
		lblSugar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSugar.setBounds(43, 363, 187, 28);
		contentPane.add(lblSugar);
	
		
		
		psugar = new JTextField();
		psugar.setColumns(10);
		psugar.setBounds(43, 401, 110, 28);
		contentPane.add(psugar);
		
		JLabel lblOutPatientOr = new JLabel("OUT PATIENT OR NOT");
		lblOutPatientOr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOutPatientOr.setBounds(237, 53, 233, 28);
		contentPane.add(lblOutPatientOr);
		
		pop = new JTextField();
		pop.setColumns(10);
		pop.setBounds(237, 91, 130, 28);
		contentPane.add(pop);
		
		JLabel lblPressure = new JLabel("PRESSURE");
		lblPressure.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPressure.setBounds(240, 211, 187, 28);
		contentPane.add(lblPressure);
		
		ppressure = new JTextField();
		ppressure.setColumns(10);
		ppressure.setBounds(240, 249, 174, 28);
		contentPane.add(ppressure);
		
	
		
		pblood = new JTextField();
		pblood.setColumns(10);
		pblood.setBounds(43, 325, 147, 28);
		contentPane.add(pblood);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("PATIENTS DETAILS");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(665, 45, 494, 41);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pgender = (String)comboBox.getSelectedItem();
				fees1=tot.getText();
				name2=pname.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					
					
					
					
					String sql="insert into patientdetails (pid,pname,pgender,pblood,psugar,pop,ppressure,pphone,paddress,tot,doc_name) values(?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pts=con.prepareStatement(sql);
					
		
					
					
					pts.setString(1, pid.getText());
					
					pts.setString(2, pname.getText());
					pts.setString(3, pgender);
					pts.setString(4, pblood.getText());
					pts.setString(5, psugar.getText());
					pts.setString(6, pop.getText());
					pts.setString(7, ppressure.getText());
					pts.setString(8, pphone.getText());
					pts.setString(9, paddress.getText());
					pts.setString(10, fees1);
					pts.setString(11, docname.getText());
					pname.requestFocus();
				
					
					 pname.setText("");
					 pblood.setText("");
					 psugar.setText("");
					 pop.setText("");
					 ppressure.setText("");
					 pphone.setText("");
					 paddress.setText("");
					 tot.setText("");
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
							pphone.setText(c);
							String d=rs.getString("address");
							paddress.setText(d);
							
						}
					 String sqq="select dname from doctdetails where dname='"+doc.us+"'";
						PreparedStatement ptss1=con.prepareStatement(sqq);
						ResultSet rss= ptss1.executeQuery();
						while(rss.next()) {
							String b=rss.getString("dname");
							docname.setText(b);
							
						}
						pts.executeLargeUpdate();
						
					
					
					
					
					 JOptionPane.showMessageDialog(null,"THE PATIENT'S DETAILS HAS BEEN REGISTERED");
				}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
                        ex.printStackTrace()
;					}
				
			}

			private String getText(String name) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(588, 181, 137, 55);
		contentPane.add(btnNewButton_2);
		
		btnNewButton = new JButton("SHOW");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					Statement st=con.createStatement();
					String sql="select * from patientdetails";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					    DefaultTableModel dt=(DefaultTableModel)JTable1.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("pid"),rs.getString("pdate"),rs.getString("pname"),rs.getString("pgender"),rs.getString("pblood"),rs.getString("psugar"),rs.getString("pop"),rs.getString("ppressure"),rs.getString("pphone"),rs.getString("paddress"),rs.getString("tot"),rs.getString("doc_name")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(588, 260, 137, 55);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=pid.getText();
				try {
			
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="delete from patientdetails WHERE pid='"+code+"'";
					PreparedStatement pts=con.prepareStatement(sql);
					
					pts.execute();
					JOptionPane.showMessageDialog(null,"THE PATIENT'S DETAILS HAS BEEN DELETED");
				}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(797, 260, 137, 55);
		contentPane.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(42, 48, 83, 28);
		contentPane.add(lblId);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 437, 1023, 190);
		contentPane.add(scrollPane);
		
		JTable1 = new JTable();
		JTable1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pid.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 0).toString());
				
				pname.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 2).toString());
				
				pblood.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 4).toString());
				psugar.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 5).toString());
				pop.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 6).toString());
				ppressure.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 7).toString());
				pphone.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 8).toString());
				paddress.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 9).toString());
				tot.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 10).toString());
				docname.setText(JTable1.getValueAt(JTable1.getSelectedRow(), 11).toString());
			}
		});
		scrollPane.setViewportView(JTable1);
		JTable1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "DATE", "NAME", "GENDER", "BLOOD", "SUGAR", "OP", "PHONE", "PRESSURE", "ADDRESS","DOC AMOUNT","DOC NAME"
			}
		));
		JTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
		
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(974, 10, 99, 30);
		contentPane.add(back);
		
		btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.setBackground(new Color(255, 255, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pgender = (String)comboBox.getSelectedItem();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql=("update patientdetails set pname=?,pgender=?,pblood=?,psugar=?,pop=?,ppressure=?,pphone=?,paddress=?,tot=?,doc_name=? where pid=?");
					
					PreparedStatement pts=con.prepareStatement(sql);
				
				
					pts.setString(1, pname.getText());
					pts.setString(2, pgender);
					pts.setString(3, pblood.getText());
					pts.setString(4, psugar.getText());
					pts.setString(5, pop.getText());
					pts.setString(6, ppressure.getText());
					pts.setString(7, pphone.getText());
					pts.setString(8, paddress.getText());
					pts.setString(11, pid.getText());
					pts.setString(9, tot.getText());
					pts.setString(10, docname.getText());
					
					pname.requestFocus();
				
					
					 pname.setText("");
					
					 pblood.setText("");
					 psugar.setText("");
					 pop.setText("");
					 ppressure.setText("");
					 pphone.setText("");
					 paddress.setText("");
				     tot.setText("");
				     docname.setText("");



			
					int i=pts.executeUpdate();
					
	         if(i>=0) {
					 JOptionPane.showMessageDialog(null,"it has been registered");
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
						Statement st=con1.createStatement();
						String sqll="select * from patientdetails";
						

						
						PreparedStatement ptss=con.prepareStatement(sqll);
						ResultSet rs= ptss.executeQuery();
						    DefaultTableModel dt=(DefaultTableModel)JTable1.getModel();
						dt.setRowCount(0);
						while(rs.next()) {
						
						Object o[]= {rs.getString("pid"),rs.getString("pdate"),rs.getString("pname"),rs.getString("pgender"),rs.getString("pblood"),rs.getString("psugar"),rs.getString("pop"),rs.getString("ppressure"),rs.getString("pphone"),rs.getString("paddress"),rs.getString("tot"),rs.getString("doc_name")};
						dt.addRow(o);}
					 
			        		 
	         
					
				}}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"it has been registered");
                        ex.printStackTrace()
;					}


			}
		});
		btnNewButton_3.setBounds(797, 182, 137, 55);
		contentPane.add(btnNewButton_3);
		
		bsearch = new JButton("SEARCH");
		bsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String query="select * from patientdetails where pid=? ";
					PreparedStatement pts=conn.prepareStatement(query);
					pts.setString(1,search.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)JTable1.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
						Object o[]= {rs.getString("pid"),rs.getString("pdate"),rs.getString("pname"),rs.getString("pgender"),rs.getString("pblood"),rs.getString("psugar"),rs.getString("pop"),rs.getString("ppressure"),rs.getString("pphone"),rs.getString("paddress"),rs.getString("doc_name")};
						dt.addRow(o);
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			}
			
		});
		bsearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		bsearch.setBackground(Color.CYAN);
		bsearch.setBounds(533, 363, 129, 49);
		contentPane.add(bsearch);
		
		lblSearchName = new JLabel("SEARCH  ID");
		lblSearchName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchName.setBounds(689, 374, 135, 13);
		contentPane.add(lblSearchName);
		
		search = new JTextField();
		search.setColumns(10);
		search.setBounds(807, 371, 169, 26);
		contentPane.add(search);
		
		JLabel lblTotFee = new JLabel("DOC FEE");
		lblTotFee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotFee.setBounds(240, 363, 187, 28);
		contentPane.add(lblTotFee);
		
		tot = new JTextField();
		tot.setColumns(10);
		tot.setBounds(240, 405, 174, 28);
		contentPane.add(tot);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\tharun\\OneDrive\\Documents\\sss.jpg"));
		lblNewLabel.setBounds(0, 0, 1073, 637);
		contentPane.add(lblNewLabel);
		
	
		
		
		
		
	}
}
