package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.HealthCheckResponse;
import com.server.sopt.seminar.sample.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping("/v1")
    public Map<String, String> healthCheck(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheck2(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthcheck3(){
        //Person person = new Person();
        //Person person = Person.builder().build();
        return "ok";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthcheck4(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthcheck5(){
        //return ResponseEntity.ok(new HealthCheckResponse("OK"));
        return ResponseEntity.ok((new HealthCheckResponse()));
    }

}
