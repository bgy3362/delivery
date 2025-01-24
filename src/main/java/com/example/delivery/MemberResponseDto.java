package com.example.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private String name;
    private String email;
    private String memberId;
    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getName(),
                                    member.getEmail(),
                                    member.getMemberId());
    }
}