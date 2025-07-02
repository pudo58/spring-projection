package io.github.pudo58.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Champion extends BaseEntity {
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String gender;
    private String race;
}
