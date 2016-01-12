/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Jatin
 */
public class EmailSender {
    public static boolean sendMail(String from, String password, String message, String to[]){
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host" ,host);
        prop.put("mail.smtp.user",from);
        prop.put("mail.smtp.password",password);
        prop.put("mail.smtp.port",25);
        prop.put("mail.smtp.auth","true");
        Session session = Session.getDefaultInstance(prop,null);
        MimeMessage mimemessage = new MimeMessage(session);
        try{
        mimemessage.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[to.length];
        for(int i=0;i<to.length;i++){
            toAddress[i] = new InternetAddress(to[i]);;
        }
            for(int i=0;i<toAddress.length;i++) {
                mimemessage.addRecipient(RecipientType.TO, toAddress[i]);
            }
        mimemessage.setSubject("Password Recovery");
        mimemessage.setText(message);
        Transport transport = session.getTransport("smtp");
        transport.connect(host,from,password);
        transport.sendMessage(mimemessage, mimemessage.getAllRecipients());
        transport.close();
        return true;
        }catch(MessagingException me){
            me.printStackTrace();
            
        }
            
   return false;
    }
}
