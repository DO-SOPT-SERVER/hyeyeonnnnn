package com.server.sopt.seminar.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    private String lastName;
    private String firstName;

    @Builder
    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
