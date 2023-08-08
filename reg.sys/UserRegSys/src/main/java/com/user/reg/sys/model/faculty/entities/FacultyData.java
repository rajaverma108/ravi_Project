package com.user.reg.sys.model.faculty.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Entity
//@Table(name="FacultyData")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("FacultyData")
public class FacultyData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String dateofbirth;
    private String Address;
}
