package com.server.sopt.seminar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter //getter를 써줘야 함!!!!!
@AllArgsConstructor
public class HealthCheckResponseDto {
    private String code;
    private String status;
    private boolean suceess;

    public static HealthCheckResponseDto ok(String code, String status, boolean suceess) {
        return new HealthCheckResponseDto(code, status, suceess);
    }

}
