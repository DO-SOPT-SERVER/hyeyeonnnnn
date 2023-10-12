package com.server.sopt.seminar.dto;

public class HealthCheckResponse {
    //private String status;
    private static final String STATUS = "OK";
    public String status;

    public HealthCheckResponse() {
        //this.status = status;
        this.status = STATUS;
    }

}
