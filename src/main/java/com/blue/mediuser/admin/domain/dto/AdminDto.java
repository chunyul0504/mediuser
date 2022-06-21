package com.blue.mediuser.admin.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AdminDto {

    private Long seq;
    private AdminGroupDto adminGroup;
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

}
