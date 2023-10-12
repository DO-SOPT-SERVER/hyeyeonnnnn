package com.server.sopt.seminar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private String code;
    private String status;
    private boolean suceess;
    private T value;

}
