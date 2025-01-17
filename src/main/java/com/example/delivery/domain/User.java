package com.example.delivery.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    //사용자, 배민사용자

    //닉네임
    //이름
    //비밀번호 - oauth2 때는 null 가능
    //이메일
    //전화번호

    private String nickname;
    private String name;
    private Date birthday;
    private String phoneNumber;
    private String password;
    private String email; // oauth로 주어지는 것.

    //카카오톡, 네이버 로그인 연동?
}
