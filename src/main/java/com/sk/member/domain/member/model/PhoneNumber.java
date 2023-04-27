package com.sk.member.domain.member.model;

import com.sk.member.app.util.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PhoneNumber implements ValueObject {
    private String phoneNumber;
}
