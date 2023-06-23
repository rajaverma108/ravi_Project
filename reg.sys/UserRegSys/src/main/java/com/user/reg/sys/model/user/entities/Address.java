package com.user.reg.sys.model.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "pincode",length = 6)
    private int pincode;
    @Column(name = "addressline1",length = 25)
    private String addressline1;
    @Column(name = "addressline2",length = 25)
    private String addressline2;
    private String city;
    private String state;
    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private UserData userData;
}
