package io.github.pudo58.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date createTime;
    private Date updateTime;


    @PrePersist
    protected void prePersist() {
        createTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        updateTime = new Date();
    }

}
