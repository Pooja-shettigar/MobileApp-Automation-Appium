package utils;

import listeners.ExtentReportListener;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SendMail extends ExtentReportListener {

//    Method to send the test execution report over recipient email address.

    public static void sendMailReport() throws AddressException, MessagingException, IOException {
        String subject = "", message = "", maillist = "", EMAIL_REPORT_FOLDER, DEVICE_LOG_FOLDER = "";
        //TODO: Add your email adderss
        subject = "Automation Report for Mobile App : " + ExtentReportListener.repName.split(":")[0];
        message = " Find the attached mail copy for the current test run.";
        maillist = "poojashettigarsoftwaretesting@gmail.com";
        EMAIL_REPORT_FOLDER = System.getProperty("user.dir") + "/test-output/" + ExtentReportListener.repName;
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        final String userName;
        final String password;
        userName = "shettypoo1995@gmail.com";
        password = "4vp13is916";
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
        DateFormat dff = new SimpleDateFormat("EEE MMM dd, yyyy HH:mm:ss z");
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userName));
        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(maillist));
        msg.setSubject(subject + " – " + dff.format(new Date()).toString());
        msg.setSentDate(new Date());

//      creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");

//      creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

//      adds only the latest Report file in attachments
        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile(EMAIL_REPORT_FOLDER);
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);

//      sends the e-mail
        Transport.send(msg);
    }
}
