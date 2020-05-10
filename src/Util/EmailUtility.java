package Util;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {
    public static void sendEmailContacto(String host, String port,
                                 final String origen, final String password, String destinatario,
                                  final String asunto, String message, String telefono, String nombre,String cliente) throws AddressException,
            MessagingException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(origen, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(origen));
        InternetAddress[] destinatarios = { new InternetAddress(origen) };
        msg.setRecipients(Message.RecipientType.TO, destinatarios);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setText(nombre+" ha escrito: "+message+"\nEl teléfono del cliente es: "+telefono+"\nEl correo del cliente es: "+cliente);


        Transport.send(msg);

    }
    public static void sendEmailAutogenerado(String host, String port,
                                 final String origen, final String password, String destinatario,
                                 final String asunto, String message) throws AddressException,
            MessagingException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(origen, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(origen));
        InternetAddress[] destinatarios = { new InternetAddress(destinatario) };
        msg.setRecipients(Message.RecipientType.TO, destinatarios);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setText(message);


        Transport.send(msg);

    }
    public static void sendEmailClases(String host, String port,
                                             final String origen, final String password,
                                             final String asunto, String message) throws AddressException,
            MessagingException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(origen, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(origen));
        InternetAddress[] destinatarios = { new InternetAddress(origen) };
        msg.setRecipients(Message.RecipientType.TO, destinatarios);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setText(message);
        Transport.send(msg);
    }
}
