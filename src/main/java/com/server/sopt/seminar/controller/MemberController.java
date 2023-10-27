package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.request.MemberCreateRequest;
import com.server.sopt.seminar.dto.request.MemberProfileUpdateRequest;
import com.server.sopt.seminar.dto.response.MemberGetResponse;
import com.server.sopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV1(memberId));
    }

    @GetMapping(value = "/{memberId}/v2")
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request){
        URI location = URI.create(memberService.create(request));
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
        memberService.updateSopt(memberId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
