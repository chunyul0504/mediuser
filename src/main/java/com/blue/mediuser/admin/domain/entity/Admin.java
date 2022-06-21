package com.blue.mediuser.admin.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "ADMIN")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @ManyToOne
    @JoinColumn(name = "ADMIN_GROUP_SEQ", nullable = false)
    private AdminGroup adminGroup;
    private String adminCode;
    private String id;
    private String password;
    private String name;
    private String telNo;
    private String phoneNo;
    private String email;
    private String createdId;
    private LocalDateTime createdDatetime;
    private String modifiedId;
    private LocalDateTime modifiedDatetime;

    @Builder
    public Admin(Long seq, AdminGroup adminGroup, String adminCode, String id, String password, String name, String telNo, String phoneNo, String email, String createdId, LocalDateTime createdDatetime, String modifiedId, LocalDateTime modifiedDatetime) {
        this.seq = seq;
        this.adminGroup = adminGroup;
        this.adminCode = adminCode;
        this.id = id;
        this.password = password;
        this.name = name;
        this.telNo = telNo;
        this.phoneNo = phoneNo;
        this.email = email;
        this.createdId = createdId;
        this.createdDatetime = createdDatetime;
        this.modifiedId = modifiedId;
        this.modifiedDatetime = modifiedDatetime;
    }
}
