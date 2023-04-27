package com.sk.member.domain.member.model;

import com.sk.member.app.util.ValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SocialAccount implements ValueObject {
    @Column(name = "social_account_id")
    private String id;
    @Column(name = "social_account_type")
    private SocialAccountType socialAccountType;
}
