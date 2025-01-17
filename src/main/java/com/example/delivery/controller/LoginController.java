package com.example.delivery.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {
    private final KakaoApi kakaoApi;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("kakaoApiKey", kakaoApi.getKakaoApiKey());
        model.addAttribute("redirectUri", kakaoApi.getKakaoRedirectUri());
        return "login";
        //https://kauth.kakao.com/oauth/authorize?client_id=ad18dedb3ef56376dbcba0899dc9c7b1&redirect_uri=http://localhost:8080/login/oauth2/code/kakao&response_type=code
    }

    @RequestMapping("/login/oauth2/code/kakao")
    public String kakaoLogin(@RequestParam String code) {
        // http://localhost:8080/login/oauth2/code/kakao?code=n76SWAP-pDwRxA0-Hx1o-uqzTWPHQIg-RB_43q6d1m148pz7k9ixsAAAAAQKPCQfAAABlGgE0hjMISgqRbFCUQ
        // 1. 인가 토큰 받기
        log.info("인가 토큰 = {}", code);

        // 2. 토큰 받기
        String accessToken = kakaoApi.getAccessToken(code);

        // 3. 사용자 정보 받기
        Map<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);

        String email = (String)userInfo.get("email");
        String nickname = (String)userInfo.get("nickname");

        System.out.println("email = " + email);
        System.out.println("nickname = " + nickname);
        System.out.println("accessToken = " + accessToken);

        // DB에 email 있다면, 바로 로그인
        // 없다면, 회원가입
        return "redirect:/login";
    }
}
