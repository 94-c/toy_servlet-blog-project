import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailEntityTestController {

        static final String FROM = "hyeongwoo26@gmail.co.kr";
        static final String FROM_NAME = "최형우";
        static final String TO = "hyeongwoo26@naver.com";

        static final String SMTP_USERNAME = "d8ffd2a2082783";
        static final String SMTP_PASSWORD = "35d7b6d03152c0";

        static final String HOST = "smtp.mailtrap.io";
        static final int PORT = 2525;

        static final String SUBJECT = "메일 제목";

        static final String BODY = String.join(
                System.getProperty("line.separator"),
                "<h1>메일 내용</h1>",
                "<p>이 메일은 아름다운 사람이 보낸 아름다운 메일입니다!</p>."
        );

    public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();

        props.put("mail.transport.protocol", "TLSv1.2");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM, FROM_NAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY, "text/html;charset=utf-8");

        Transport transport = session.getTransport();
        try {
            System.out.println("Sending...");

            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
