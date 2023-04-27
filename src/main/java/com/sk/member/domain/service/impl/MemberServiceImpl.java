package com.sk.member.domain.service.impl;

import com.sk.member.domain.member.model.Email;
import com.sk.member.domain.member.model.Member;
import com.sk.member.domain.member.model.MemberStatus;
import com.sk.member.domain.member.repository.impl.MemberRepository;
import com.sk.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Page<Member> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public Member createMember(Member member) {
        member.setId(null);
        return memberRepository.save(member);
    }

    @Override
    public Member findByMemberId(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }

    @Override
    public Member updateMember(String memberId, Email email, String nickname, String password) {
        Member originalData = memberRepository.findByMemberId(memberId);
        originalData.setEmail(email);
        originalData.setNickname(nickname);
        originalData.setPassword(password);
        return memberRepository.save(originalData);
    }

    @Override
    public boolean softDeleteMember(String memberId) {
        Member originalData = memberRepository.findByMemberId(memberId);
        originalData.setMemberStatus(MemberStatus.DEACTIVE);
        originalData.setDeleteTime(LocalDateTime.now());
        memberRepository.save(originalData);
        return true; // 필요에 따라 삭제 데이터를 줘야 할수도..?
    }
}
