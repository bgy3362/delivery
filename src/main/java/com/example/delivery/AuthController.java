package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    /**
     *  Member
     */
    @PostMapping("/member/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/member/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    /**
     *  Owner
     */
    @PostMapping("/owner/signup")
    public ResponseEntity<OwnerResponseDto> signup(@RequestBody OwnerRequestDto ownerRequestDto) {
        return ResponseEntity.ok(authService.signup(ownerRequestDto));
    }

    @PostMapping("/owner/login")
    public ResponseEntity<TokenDto> login(@RequestBody OwnerRequestDto ownerRequestDto) {
        return ResponseEntity.ok(authService.login(ownerRequestDto));
    }

    /**
     * Member / Owner 공통
     */
    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}