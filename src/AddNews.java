
import Project.ConnectionProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author thiru
 */
public class AddNews extends javax.swing.JFrame {
 private static final String DB_URL = "jdbc:mysql://localhost:3306/chatbot";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "thiru@1234";
    
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String EMAIL_USER = "thirumugilan578_bit26@mepcoeng.ac.in";
    private static final String EMAIL_PASSWORD = "thirudinu1707";
    /**
     * Creates new form AddNews
     */
    public AddNews() {
        initComponents();
        getNames();
        loadUserEmails();
        
     
    }
List<String> l;
     private void loadUserEmails() {
         l = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT mail FROM users  WHERE type = 'Subscriber'";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                  l.add(  rs.getString("mail"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
  

    
    
//          private void sendMail() {
//        String[] recipients = l.toArray(new String[0]);
//        String subject = "Invitation to Contribute to a Better Bhavnagar through Property Tax Payments";
//        String messageText = "Dear Resident,\n\n" +
//            "We are reaching out to you on behalf of Bhavnagar Municipal Corporation (BMC) to emphasize the importance of property tax contributions. Property tax serves as the primary source of revenue for municipal corporations like ours, enabling us to provide and enhance essential facilities for the citizens of Bhavnagar.\n\n" +
//            "Unfortunately, a large number of small residential property owners have not yet contributed their property tax, which limits our ability to expand and improve services. With your support, we aim to overcome this challenge and continue making Bhavnagar a safer, cleaner, and more vibrant city.\n\n" +
//            "Why Your Contribution Matters:\n" +
//            "- Roads and Infrastructure: Better roads, pavements, and public transport facilities.\n" +
//            "- Public Safety and Cleanliness: Enhanced waste management, sanitation, and emergency services.\n" +
//            "- Parks and Community Spaces: Maintenance of parks, playgrounds, and public areas for all residents to enjoy.\n\n" +
//            "Upcoming Payment Deadline:\n" +
//            "The deadline for this year’s property tax payment is 12-12-2024. To ensure the continued development of Bhavnagar, we encourage you to complete your payment by this date.\n\n" +
//            "Convenient Payment Options:\n" +
//            "- Online Payment: Visit our official portal at [Enter URL Here] for a secure, quick payment option.\n" +
//            "- In-Person: Drop by the Bhavnagar Municipal Corporation office at [Enter Office Address Here].\n" +
//            "- Mobile App: Use our mobile app, available for download, to pay directly from your device.\n\n" +
//            "Your property tax payment is an investment in the future of our city, enabling us to add more amenities and improve urban facilities. Together, we can continue to make Bhavnagar a city we’re all proud to call home.\n\n" +
//            "For any questions or assistance with the payment process, please feel free to reach out to us at bmcptscentral@gmail.com.\n\n" +
//            "Thank you for your attention and support.\n\n" +
//            "Best regards,\n\n" +
//            "Awareness and Collection Team\n" +
//            "Bhavnagar Municipal Corporation\n" +
//            "Contact: [Your Contact Information]";
//        
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", SMTP_HOST);
//        props.put("mail.smtp.port", SMTP_PORT);
//
//        try {
//            Session session = Session.getInstance(props, new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(EMAIL_USER, EMAIL_PASSWORD);
//                }
//            });
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(EMAIL_USER));
//
//            InternetAddress[] addresses = new InternetAddress[recipients.length];
//            for (int i = 0; i < recipients.length; i++) {
//                addresses[i] = new InternetAddress(recipients[i]);
//            }
//            message.setRecipients(Message.RecipientType.TO, addresses);
//
//            message.setSubject(subject);
//            message.setText(messageText);
//            message.setSentDate(new Date());
//            Transport.send(message);
//            JOptionPane.showMessageDialog(null, "Emails sent successfully!");
//        } catch (MessagingException e) {
//            System.out.println("Error in sending mail: " + e.getMessage());
//        }
//    }

    
    
    private void getNames() {
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement st = con.prepareStatement("SELECT * FROM GAMES");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String mycat = rs.getString("gamename");
                names.addItem(mycat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        names = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel1.setText("ADD NEWS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(519, 519, 519)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(57, 57, 57))
        );

        jLabel2.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel2.setText("GAME NAME");

        jLabel3.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel3.setText("DATE");

        jLabel4.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel4.setText("CONTENT");

        content.setColumns(20);
        content.setRows(5);
        jScrollPane1.setViewportView(content);

        submit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(names, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)))
                        .addGap(0, 484, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(496, 496, 496)
                .addComponent(submit)
                .addGap(198, 198, 198)
                .addComponent(back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(names, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(back))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static List<String> getSubscriberEmails() {
        List<String> emails = new ArrayList<>();
        String query = "SELECT mail FROM users WHERE type = 'subscriber'";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                emails.add(rs.getString("mail"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emails;
    }
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String gam = names.getSelectedItem().toString();
    String con = content.getText();
    Date da = date.getDate();
    if (insertUserIntoDatabase(da,con, gam)) {
        javax.swing.JOptionPane.showMessageDialog(this, "News added successfully.", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        for (String email : getSubscriberEmails()) {
                sendMail(email, "News Update: " + gam, con);
            }
        // Optionally, clear the fields or redirect to another page
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Error during adding News. Please try again.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
       // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed
  
    private boolean insertUserIntoDatabase(Date da,String con, String gam) {
    Connection conn = ConnectionProvider.getCon(); // Assuming ConnectionProvider has a static method to get the connection
    PreparedStatement ps = null;
    try {
        // Prepare the SQL statement
        String sql = "INSERT INTO news (date, details, game) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(sql);
        java.sql.Date sqlDate = new java.sql.Date(da.getTime());
        ps.setDate(1, sqlDate); 
        ps.setString(2, con);    // Set content
        ps.setString(3, gam);    // Set game name

        // Convert java.util.Date to java.sql.Date for database compatibility
         // Set date

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0; // Return true if the insertion was successful
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Return false in case of any SQL exceptions
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    
public static void sendMail(String recipientEmail, String subject, String messageContent) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USER, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USER));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            message.setText(messageContent);

            Transport.send(message);
            System.out.println("Email sent to " + recipientEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error: Could not send email to " + recipientEmail);
        }
    }



    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Add ad = new Add();
        ad.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextArea content;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> names;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables

    
}
