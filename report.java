package hospital;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class umm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnPrint;
    private JScrollPane scrollPane;
    private JButton btnSendEmail;
    private static String filePath;

    // Patient details
    public static String a, b, c, d, e11, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, f;
    private static JTextField emailid;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                umm frame = new umm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public umm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1020, 1200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(41, 10, 692, 580);
        contentPane.add(scrollPane);

        JTextPane textPane = new JTextPane();
        scrollPane.setViewportView(textPane);

        // Get the StyledDocument
        StyledDocument docc = textPane.getStyledDocument();

        // Define styles
        Style style1 = textPane.addStyle("Style1", null);
        Style style2 = textPane.addStyle("Style2", null);
        Style style3 = textPane.addStyle("Style3", null);
        StyleConstants.setFontFamily(style1, "Arial");
        StyleConstants.setFontSize(style1, 12);
        StyleConstants.setBold(style1, true);
        StyleConstants.setFontFamily(style2, "Courier New");
        StyleConstants.setFontSize(style2, 25);
        StyleConstants.setBold(style2, true);
        StyleConstants.setFontFamily(style3, "Times New Roman");
        StyleConstants.setFontSize(style3, 14);
        StyleConstants.setBold(style3, true);

        textField = new JTextField();
        textField.setBounds(814, 85, 107, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnFetchDetails = new JButton("Fetch Details");
        btnFetchDetails.addActionListener(e -> {
            try {
                String code = textField.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital1", "root", "Tharun@2005");

                String sql = "SELECT patientdetails.pid, admission.date, admission.father, patientdetails.pname, " +
                        "patientappointments.adate, patientdetails.pgender, roo_backup.age, patientdetails.pblood, " +
                        "patientdetails.psugar, patientdetails.ppressure, patientdetails.pop, patientrecords.rproblem, " +
                        "patientrecords.rweight, patientrecords.rheight, patientappointments.adoctor, patientappointments.atime, " +
                        "patientrecords.ridentification, patientrecords.rplans, medical_bills.total_fees, patientdetails.pphone, " +
                        "patientdetails.paddress, roo_backup.deleted_at, prescriptionview.description, roo_backup.room_no " +
                        "FROM patientdetails " +
                        "INNER JOIN patientrecords ON patientdetails.pid = patientrecords.pid " +
                        "INNER JOIN admission ON admission.id = patientrecords.pid " +
                        "INNER JOIN patientappointments ON patientappointments.pid = admission.id " +
                        "INNER JOIN roo_backup ON patientappointments.pid = roo_backup.id " +
                        "INNER JOIN prescriptionview ON prescriptionview.id = roo_backup.id " +
                        "INNER JOIN medical_bills ON medical_bills.id = prescriptionview.id " +
                        "WHERE patientdetails.pid = ?";

                PreparedStatement pts = con.prepareStatement(sql);
                pts.setString(1, code); // Set the code for patientdetails.pid
                ResultSet rs = pts.executeQuery();

                while (rs.next()) {
                    a = rs.getString("patientdetails.pid");
                    b = rs.getString("patientdetails.pname");
                    e11 = rs.getString("patientappointments.adate");
                    d = rs.getString("admission.date");
                    f = rs.getString("patientappointments.atime");
                    g = rs.getString("admission.father");
                    v = rs.getString("roo_backup.age");
                    w = rs.getString("patientdetails.pop");
                    h = rs.getString("patientappointments.adoctor");
                    i = rs.getString("patientdetails.pgender");
                    l = rs.getString("patientrecords.rheight");
                    j = rs.getString("patientdetails.pblood");
                    k = rs.getString("patientrecords.rweight");
                    m = rs.getString("patientrecords.rproblem");
                    n = rs.getString("patientdetails.psugar");
                    o = rs.getString("patientdetails.ppressure");
                    p = rs.getString("patientrecords.ridentification");
                    q = rs.getString("patientrecords.rplans");
                    r = rs.getString("roo_backup.room_no");
                    s = rs.getString("patientdetails.pphone");
                    t = rs.getString("patientdetails.paddress");
                    y = rs.getString("prescriptionview.description");
                    u = rs.getString("medical_bills.total_fees");
                    x = rs.getString("roo_backup.deleted_at");
                }
            } catch (Exception ec) {
                ec.printStackTrace();
            }

            try {
                // Add text with different styles
                docc.insertString(docc.getLength(), "\n\n\n\n"
                        + "Phone NO:7806854324\t\t\t         www.tthospital22.com\n"
                        + "         \t\t\t\t\t\t\t                                                                      email:tthospital@gmail.com\n\n\n", style1);
                docc.insertString(docc.getLength(), "\t         TT HOSPITAL\n\n", style2);
                docc.insertString(docc.getLength(), "\t\t     BILL SUMMARY\n\n"
                        + "Reference NO:1234567890\n"
                        + "=======================================================================================\n\n"
                        + "	\n"
                        + "	\n"
                        + "	-------------------------------------------------------\n"
                        + "	\n"
                        + "	PATIENT ID:\t\t\t" + a + "\n"
                        + "	-------------------------------------------------------\n"
                        + "	PATIENT NAME:\t\t\t" + b + "\n"
                        + "	-------------------------------------------------------\n"
                        + " \tDATE:\t\t\t\t" + d + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tAPPOINTMENT DATE:\t\t" + e11 + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tAPPOINTMENT TIME:\t\t" + f + "\n"
                        + " \t-------------------------------------------------------\n"
                        + "	PATIENT FATHER NAME:\t\t" + g + "\n"
                        + "	-------------------------------------------------------\n"
                        + "	PATIENT AGE:\t\t\t" + v + "\n"
                        + "	-------------------------------------------------------\n"
                        + "	PATIENT OP:\t\t\t" + w + "\n"
                        + "	-------------------------------------------------------\n"
                        + "	DOC NAME:\t\t\t" + h + "\n"
                        + "	-------------------------------------------------------\n"
                        + " \tGENDER:\t\t\t\t" + i + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT BLOOD:\t\t\t" + j + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT WEIGHT:\t\t\t" + k + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT HEIGHT:\t\t\t" + l + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT PROBLEM:\t\t\t" + m + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT SUGAR:\t\t\t" + n + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT PRESSURE:\t\t\t" + o + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT IDENTIFICATION:\t\t" + p + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT FUTURE PLANS:\t\t" + q + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT ROOM NO:\t\t\t" + r + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT PHONE NO:\t\t" + s + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT ADDRESS:\t\t\t" + t + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT PRESCRIPTION:\t\t" + y + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPRICE:\t\t\t\t" + u + "\n"
                        + " \t-------------------------------------------------------\n"
                        + " \tPATIENT DISCHARGED:\t\t" + x + "\n"
                        + " \t-------------------------------------------------------\n"
                        + "\t\tTake care of your health\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n", style3);

            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        });
        btnFetchDetails.setBounds(803, 421, 168, 43);
        contentPane.add(btnFetchDetails);

        btnPrint = new JButton("Print");
        btnPrint.addActionListener(e -> {
            try {
                textPane.print();
            } catch (PrinterException e1) {
                e1.printStackTrace();
            }
        });
        btnPrint.setBounds(803, 495, 168, 43);
        contentPane.add(btnPrint);

        btnSendEmail = new JButton("Send Email");
        btnSendEmail.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a file to send");

            int userSelection = fileChooser.showOpenDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSend = fileChooser.getSelectedFile();
                if (fileToSend.exists()) {
                    try {
                        processFile(fileToSend);
                        sendEmail(filePath);
                    } catch (IOException | MessagingException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("The selected file does not exist.");
                }
            }
        });
        btnSendEmail.setBounds(803, 567, 168, 43);
        contentPane.add(btnSendEmail);
        
        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(768, 85, 78, 19);
        contentPane.add(lblNewLabel);
        
        JLabel lblEmailId = new JLabel("EMAIL ID");
        lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEmailId.setBounds(743, 151, 107, 19);
        contentPane.add(lblEmailId);
        
        emailid = new JTextField();
        emailid.setColumns(10);
        emailid.setBounds(782, 188, 224, 36);
        contentPane.add(emailid);
    }

    private static void processFile(File file) throws IOException {
        filePath = file.getAbsolutePath();
        System.out.println("File selected: " + filePath);
    }

    private static void sendEmail(String attachmentPath) throws MessagingException {
    	String i=emailid.getText();
        String username = "tamilselvans2209@gmail.com";
        String password = "kibx wxyn iwpt jydo";
        String recipient = i;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject("File Attachment");

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Please find the file attached.");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        try {
            attachmentBodyPart.attachFile(attachmentPath);
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("Email sent successfully.");
    }
}
