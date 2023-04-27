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
public class Address implements ValueObject {
    @Column(name = "address")
    private String address;
    @Column(name = "address_zipcode")
    private String zipCode;
}
