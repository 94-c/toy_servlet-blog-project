package com.blog.util;

import com.blog.data.dao.EmailTokensDAO;
import com.blog.data.entity.EmailTokens;
import com.blog.lib.email.SendEmailMapper;
import com.blog.lib.email.SendEmailSettingDto;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class EmailUtil {
    private static final EmailTokensDAO emailTokenDAO = new EmailTokensDAO();
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

        SendEmailMapper sendEmailMapper = new SendEmailMapper();

        Properties props = new Properties();
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", sendEmailMapper.mailTrap().getHost());
        props.put("mail.smtp.port", "2525");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sendEmailMapper.mailTrap().getGuest(), sendEmailMapper.mailTrap().getPassword());
                    }
                }
        );

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(sendEmailMapper.mailTrap().getGuest()));
            mimeMessage.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            mimeMessage.setSubject(sendEmailMapper.mapToMessageDto(token).getSubject(), "utf-8");
            mimeMessage.setText(sendEmailMapper.mapToMessageDto(token).getContent(), "utf-8", "html");
            Transport.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return token;
    }
}
