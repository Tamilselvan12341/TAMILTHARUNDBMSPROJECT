package hospital;
import hospital.admission;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class PRESCRIPTIONDETAILS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblPrescriptionDetails;
	private JButton back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRESCRIPTIONDETAILS frame = new PRESCRIPTIONDETAILS();
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
	public PRESCRIPTIONDETAILS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 133, 794, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "DOC NAME", "DESCRIPTION","QUANTITY", "AMOUNT","TOT_AMOUNT"
			}
		));
		
		JButton btnNewButton = new JButton("SHOW DETAILS");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
					String query="select * from prescriptionview where name='"+admission.name1+"'";
					PreparedStatement pts=conn.prepareStatement(query);
					
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
						Object o[]= {rs.getString("id"),rs.getString("name"),rs.getString("docname"),rs.getString("description"),rs.getString("quantity"),rs.getString("amount"),rs.getString("tot_amount")};
						dt.addRow(o);
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			}
		});
		btnNewButton.setBounds(60, 33, 215, 42);
		contentPane.add(btnNewButton);
		
		lblPrescriptionDetails = new JLabel("PRESCRIPTION DETAILS");
		lblPrescriptionDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblPrescriptionDetails.setBounds(535, 10, 345, 49);
		contentPane.add(lblPrescriptionDetails);
		
		back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(753, 83, 99, 30);
		contentPane.add(back);
	}

}
