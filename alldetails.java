package hospital;
import hospital.admission;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Tharun extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton back;
	private final JLabel lblNewLabel_1 = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					Tharun frame = new Tharun();
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
	public Tharun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 722);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SHOW");
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String sql="select patientdetails.pid,patientdetails.pdate,patientdetails.pname,patientdetails.pgender,roo_backup.age,patientdetails.pblood,patientdetails.psugar,patientdetails.ppressure,patientdetails.pop,patientrecords.rproblem,patientrecords.rweight,patientrecords.rheight,patientappointments.adoctor,patientappointments.atype,patientappointments.atime,patientrecords.ridentification,patientrecords.rplans,medical_bills.total_fees,patientdetails.pphone,patientdetails.paddress,roo_backup.deleted_at from patientdetails inner join patientrecords ON patientdetails.pid = patientrecords.pid and patientdetails.pname = patientrecords.pname and patientdetails.pblood = patientrecords.rblood inner join patientappointments ON  patientrecords.pid = patientappointments.pid and patientrecords.pname = patientappointments.pname inner join roo_backup ON patientappointments.pname=roo_backup.name and patientappointments.pid=roo_backup.id inner join medical_bills on medical_bills.name=patientdetails.pname";
							
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("patientdetails.pid"),rs.getString("patientdetails.pdate"),rs.getString("patientdetails.pname"),rs.getString("patientdetails.pgender"),rs.getString("roo_backup.age"),rs.getString("patientdetails.pblood"),rs.getString("patientdetails.psugar"),rs.getString("patientdetails.ppressure"),rs.getString("patientdetails.pop"),rs.getString("patientrecords.rproblem"),rs.getString("patientrecords.rweight"),rs.getString("patientrecords.rheight"),rs.getString("patientappointments.adoctor"),rs.getString("patientappointments.atype"),rs.getString("patientappointments.atime"),rs.getString("patientrecords.ridentification"),rs.getString("patientrecords.rplans"),rs.getString("medical_bills.total_fees"),rs.getString("patientdetails.pphone"),rs.getString("patientdetails.paddress"),rs.getString("roo_backup.deleted_at")};
					dt.addRow(o);
					}
					
				
			}
				catch(Exception ec) {ec.printStackTrace();
					JOptionPane.showMessageDialog(null,"it has not been registered");
					
				}

			}
		});
		btnNewButton.setBounds(115, 43, 125, 42);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 136, 1462, 325);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "DATE", "NAME", "GENDER", "AGE", "BLOOD", "SUGAR", "PRESSURE", "OP", "PROBLEM", "WEIGHT", "HEIGHT", "DOC NAME", "TYPE OF DOC", "APPPOINTMENT TIME", "IDENTIFICATION", "PLANS OF TREATMENT", "TOTAL FEE", "PHONE NO", "ADDRESS","DATE AND TIME OF DISCHARGE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(67);
		table.getColumnModel().getColumn(18).setPreferredWidth(101);
		
		lblNewLabel = new JLabel("TOTAL DETAILS");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(913, 37, 295, 40);
		contentPane.add(lblNewLabel);
		
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(1377, 43, 99, 30);
		contentPane.add(back);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\teq52-hero.jpg"));
		lblNewLabel_1.setBounds(0, 10, 1894, 675);
		contentPane.add(lblNewLabel_1);
	}
}
