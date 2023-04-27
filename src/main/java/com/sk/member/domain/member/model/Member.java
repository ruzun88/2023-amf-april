package com.sk.member.domain.member.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sk.member.app.util.Aggregate;
import com.sk.member.domain.AbstractAuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends AbstractAuditEntity implements Aggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String memberId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    private String name;

    private String nickname;

    private Address address;

    private PhoneNumber phoneNumber;

    private Email email;

    private MemberType memberType;

    private MemberStatus memberStatus;

    private LocalDateTime deleteTime;

    private SocialAccount socialAccount;
}
