package com.server.sopt.seminar.dto.request.member;

import com.server.sopt.seminar.domain.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}