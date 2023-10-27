package com.server.sopt.seminar.dto.response;

import com.server.sopt.seminar.entity.Member;
import com.server.sopt.seminar.entity.SOPT;
import lombok.Data;

public record MemberGetResponse (
    String name,
    String nickname,
    int age,
    SOPT soptInfo
) {
    public static MemberGetResponse of (Member member){
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
