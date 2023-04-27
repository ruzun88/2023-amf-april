package com.sk.member.domain.service;

import com.sk.member.domain.member.model.Email;
import com.sk.member.domain.member.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    Page<Member> getAllMembers(Pageable pageable);

    Member createMember(Member member);

    Member findByMemberId(String memberId);

    Member updateMember(String memberId, Email email, String nickname, String password);

    boolean softDeleteMember(String memberId);
}
