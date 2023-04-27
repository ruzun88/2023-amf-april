package com.sk.member.domain.member.model;

import com.sk.member.app.util.ValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Email implements ValueObject {
    @Column(name = "email_local_parts")
    private String localParts;

    @Column(name = "email_domain")
    private String domain;

    public Email(String localParts, String domain) {
        setDomain(domain);
        setLocalParts(localParts);
    }

    public void setDomain(String domain) {
        // 도메인에 "."이 없으면 정상적이지 않은 메일주소이다.
        // 정규식으로 확인하는게 더 좋겠지요
        if(!domain.contains(".")) {
            throw new RuntimeException("비정상적인 이메일 주소");
        }
        this.domain = domain;
    }
}
