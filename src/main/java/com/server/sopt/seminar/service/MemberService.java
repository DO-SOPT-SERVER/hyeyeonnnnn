package com.server.sopt.seminar.service;

import com.server.sopt.seminar.dto.request.MemberCreateRequest;
import com.server.sopt.seminar.dto.request.MemberProfileUpdateRequest;
import com.server.sopt.seminar.dto.response.MemberGetResponse;
import com.server.sopt.seminar.entity.Member;
import com.server.sopt.seminar.entity.SOPT;
import com.server.sopt.seminar.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberByIdV1(Long memberId){
        Member member = memberJpaRepository.findById(memberId).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long id) {
//        return MemberGetResponse.of(memberJpaRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."))
//        );}
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }



    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public String create(MemberCreateRequest request){
        Member member = Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build();
        return memberJpaRepository.save(member).getId().toString();
    }

    private MemberGetResponse findById(Long memberId){
                return MemberGetResponse.of(memberJpaRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."))
        );}


    @Transactional
    public void updateSopt(Long memberId, MemberProfileUpdateRequest updateRequest){
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        SOPT updateSopt = new SOPT(updateRequest.generation(), updateRequest.part());
        member.updateSopt(updateSopt);
    }

    @Transactional
    public void deleteMember(Long memberId){
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }

}


