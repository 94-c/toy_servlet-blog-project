package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.entity.EmailTokens;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class EmailService {

    private static final EmailTokensDAO emailTokenDAO = new EmailTokensDAO();

    String host = "smtp.mailtrap.io";
    String guest = "d8ffd2a2082783";    //발신자 메일
    String password = "35d7b6d03152c0"; //발신자 비밀번호

    int size = 0;

    private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }

    private String getAuthCode() {
        int num = 0;
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        while (buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }
        return buffer.toString();
    }

    public String sendEmail(Integer userId, String email) {

        //6자리 난수 인증번호 발생
        String token = getKey(6);

        //이메일 토근의 id값으로 인하여
        EmailTokens emailToken = new EmailTokens();
        emailToken.setToken(token);
        emailToken.setUserId(userId);
        EmailTokens emailTokens = emailTokenDAO.create(emailToken);

        Properties props = new Properties();
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(guest, password);
                    }
                }
        );


        String content = "<h1>[이메일 인증]</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
                + "<a href='http:/localhost:9007/emailConfirm.do?token=" + token + "' target='_blenk'>이메일 인증 확인</a>";

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(guest));
            //메일 대상
            mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            //메일 제목
            mimeMessage.setSubject("블로그 회원가입을 진심으로 축하드립니다.", "utf-8");

            //메일 본문
            mimeMessage.setText(content, "utf-8", "html");

            // send the message
            Transport.send(mimeMessage);
            System.out.println("메일 전송 완료");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return token;
    }
}
