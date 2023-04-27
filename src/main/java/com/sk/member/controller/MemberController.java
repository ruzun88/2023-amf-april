package com.sk.member.controller;

import com.sk.member.domain.member.model.Member;
import com.sk.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 생성
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member createdMember = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<Page<Member>> getAllUsers(@PageableDefault(value = 10) Pageable pageable) { // 입력이 없으면 10개씩 조회
        Page<Member> allUsers = memberService.getAllMembers(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    // 사용자 ID로 조회
    @GetMapping("/{userId}")
    public ResponseEntity<Member> getMemberByUserId(@PathVariable String userId) {
        Member member = memberService.findByMemberId(userId);
        if (member == null) {
            // 예외 방법 1
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("API_STATUS", "NO SUCH MEMBER")
                    .body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    // 특정 사용자 수정
    @PutMapping("/{userId}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member, @PathVariable String userId) {

        // 수정 사용자 check
        if (userId == null || !userId.equals(member.getMemberId())) {
            // 예외 방법 2
            throw new RuntimeException("요청된 URL과 수정 대상자의 정보가 일치하지 않습니다.");
        }


        // 어디까지 업데이트를 가능하게 해줄 것인지 내부적으로 결정해 보세요.
        Member updatedMember = memberService.updateMember(member.getMemberId(), member.getEmail(), member.getNickname(), member.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(updatedMember);
    }

    // 특정 사용자 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> updateMember(@PathVariable String userId) {
        boolean success = memberService.softDeleteMember(userId);
        return ResponseEntity.status(HttpStatus.OK).body(success);
    }

}
