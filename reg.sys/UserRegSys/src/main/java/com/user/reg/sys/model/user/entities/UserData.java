package com.user.reg.sys.model.user.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@IdClass(UserDataCompositPK.class)
@Table(name = "UserData")
public class UserData {
    @Id
//    @GenericGenerator(name = "user_id", strategy = Constants.$userIdGeneratorKey)
//    @GeneratedValue(generator = "user_id")
    @Column(name = "user_id", unique = true,nullable = false)
    //act as primary key
    private String cid;
    @Column(name = "Firstname",nullable = true)
    private String firstname;
    @Column(name = "Lastname",nullable = false)
    private String lastname;
    @Column(name = "Dateofbirth",nullable = false)
    private String dateofbirth;
    @Column(name = "UID")
    //act as candidate key
    private int uid;
    @OneToOne(cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    private Address address;
    @CreationTimestamp
    @Column(name = "recordCreationDate", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp recordCreationDate;
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "lastModified")
    private Timestamp lastModified;


}

