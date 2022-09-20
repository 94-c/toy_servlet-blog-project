package com.blog.lib.email;

public class SendEmailMapper implements SendEmailImpl {

    @Override
    public SendEmailSettingDto mailTrap() {
        return SendEmailSettingDto.builder()
                .guest("d8ffd2a2082783")
                .host("smtp.mailtrap.io")
                .password("35d7b6d03152c0")
                .build();

    }

    public SendEmailMessageDto mapToMessageDto(String token) {
        return SendEmailMessageDto.builder()
                .content("<h1>[이메일 인증]</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
                        + "<a href='http:/localhost:9007/emailConfirm.do?token=" + token + "' target='_blenk'>이메일 인증 확인</a>")
                .subject("블로그 회원가입을 진심으로 축하드립니다.")
                .build();
    }
}
