package hospital;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class discharge extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private int[]a12= {0,0};
	private JButton[][] r= new JButton[9][9];
	

		private JButton change;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					discharge frame = new discharge();
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
	public discharge() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ROOM DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(604, 45, 235, 54);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 13));
		back.setBounds(791, 10, 99, 30);
		contentPane.add(back);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\tharun\\Downloads\\hospital-ward-hospital-medical-room.jpg"));
		lblNewLabel_1.setBounds(0, 0, 900, 493);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		   
			ActionListener lis = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton) {
					String text = ((JButton) e.getSource()).getText();
							int in = text.length();
					int b=0;
					System.out.println(in);
					for(int j=0;j<in;j++) {
						char ch = text.charAt(j);
						System.out.println("j"+j);
						System.out.println(ch);
						System.out.println((int) ch);
						if((int)ch == 32) {
							b=1;
							continue;
							
						}
						else {
							if(b==0||b==1) {
								a12[b]=(a12[b]*10)+(ch-48);
							}
						}
					}
					JOptionPane.showMessageDialog(null, text);
					System.out.println((JButton)e.getSource());
					System.out.println(a12[0]);
					System.out.println(a12[1]);
					rooms frame = new rooms();
					frame.setVisible(true);
					
					
				}
					
				}
			};
		JButton[][] r= new JButton[9][9];	
		
		int a2 = 0;
	    int a1 = 55;//308, 417, 133, 46//
		int c= 50;
		int s=9,m=9;
		
		 for(int i=0;i<(s-4);i++){
			 for(int j=0;j<m;j++) {
			++a2;	
			int ey=0;
			r[i][j]=new JButton();
			r[i][j].setText(i+" "+j);
			r[i][j].setFont(new Font("Tahoma", Font.BOLD, 6));
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1","root","Tharun@2005");
			Statement st1 = con1.createStatement();
			String sql2 = "select * from roo where i="+i+" and j="+j;
			PreparedStatement ps2 = con1.prepareStatement(sql2);
			
			ResultSet res2 = ps2.executeQuery();
			while(res2.next()) {
				int t1 = res2.getInt(1);
				int t2 = res2.getInt(2);
				
				if(i==t1 && j==t2) {
					r[i][j].setBackground(Color.RED);
					ey=1;
				}
				
			}
			if(ey==0){
				r[i][j].setBackground(Color.yellow);
				
			}
			
			
			}
			
			catch(Exception ws) {
				ws.printStackTrace();
				//r[i][j].setBackground(Color.GREEN);
				}
			//r[i][j].setBackground(Color.GREEN);
			r[i][j].setBounds(a1,c ,50,50);
			
			r[i][j].addActionListener(lis);
			 
			contentPane.add(r[i][j]);
			a1=a1+50;
			 }
			 if(i%2==1) {
			     a1=55; 
			     c=c+50;}
			 else {
				 a1=55;
				 c=c+50+20;
			 }
			
			 
		}
		
		
		
	}
}

