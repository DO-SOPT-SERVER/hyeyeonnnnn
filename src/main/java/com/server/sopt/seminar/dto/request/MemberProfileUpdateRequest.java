package com.server.sopt.seminar.dto.request;

import com.server.sopt.seminar.entity.Part;



public record MemberProfileUpdateRequest (
    int generation,
    Part part
){

}