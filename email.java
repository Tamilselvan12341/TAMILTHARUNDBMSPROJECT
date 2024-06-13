package hospital;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class email extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailid;
	private JTextField textField_1;
	  public String n3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					email frame = new email();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String fr = null;
		String to= fr; 
	

        // Generate OTP
        String otp = generateOTP();

        // Send email with OTP
        sendEmail(to, otp);
	}

	


	private static void sendEmail(String to, String otp) {
		// TODO Auto-generated method stub
		
	}




	private static String generateOTP() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create the frame.
	 */
	public email() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 592);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(73, 94, 102, 45);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(113, 127, 10, -32);
		contentPane.add(panel);
		
		emailid = new JTextField();
		emailid.setBounds(165, 103, 268, 35);
		contentPane.add(emailid);
		emailid.setColumns(10);
		
		JButton btnNewButton = new JButton("SEND OTP");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String fr = emailid.getText();
				 String to = fr; // to address. It can be any like gmail, hotmail etc.
				  final String from = "tamilselvans2209@gmail.com"; // from address. As this is using Gmail SMTP.
				  final String password = "kibx wxyn iwpt jydo"; // password for from mail address. 
				  Properties prop = new Properties();

				  prop.put("mail.smtp.host", "smtp.gmail.com");
				  prop.put("mail.smtp.port", "465");
				  prop.put("mail.smtp.auth", "true");
				
				  prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
				  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			      
			      
			      Session session = Session.getDefaultInstance(prop,  
			       new javax.mail.Authenticator() {  
			       protected PasswordAuthentication getPasswordAuthentication() {  
			       return new PasswordAuthentication(from,password);  
			       }  
			      });  
			         
			      //2) compose message     
			      try {
						 
					   Message message = new MimeMessage(session);
					   message.setFrom(new InternetAddress(from));
					   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
					   message.setSubject("Verification Mail");
					   int n;
					   Random ran = new Random();
					   n = ran.nextInt();
					   n=Math.abs(n);
					   System.out.println(n);
					   n3 = String.valueOf(n);
					   String msg = "OTP :"+n3 ;
					    
					   MimeBodyPart mimeBodyPart = new MimeBodyPart();
					   mimeBodyPart.setContent(msg, "text/html");
					     
					   Multipart multipart = new MimeMultipart();
					   multipart.addBodyPart(mimeBodyPart);
					    
					 
					   message.setContent(multipart);
					 
					   Transport.send(message);
					 
					   System.out.println("Mail successfully sent..");
					   
					  } catch (MessagingException er) {
					   er.printStackTrace();
					  }


					  
					}
	
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(464, 102, 111, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblOtp.setBounds(73, 191, 102, 45);
		contentPane.add(lblOtp);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 191, 268, 35);
		contentPane.add(textField_1);
		
		JButton btnVerify = new JButton("VERIFY");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(n3.equals(textField_1.getText())) {
					forgetpassword frame = new forgetpassword();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVerify.setBounds(219, 288, 111, 37);
		contentPane.add(btnVerify);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEmail.setBounds(383, 10, 102, 45);
		contentPane.add(lblEmail);
	}
}
