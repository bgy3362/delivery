package com.example.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> findMemberInfoById() {
        return ResponseEntity.ok(memberService.findMemberInfoById(SecurityUtil.getCurrentId()));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> findMemberInfoByMemberId(@PathVariable String memberId) {
        return ResponseEntity.ok(memberService.findMemberInfoByMemberId(memberId));
    }
}