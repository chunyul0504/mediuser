package com.blue.mediuser.buyer.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "BUYER")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String buyerCode;
    private String buyerType;
    private String buyerState;
    private String corpTelNo;
    private String corpPhoneNo;
    private String corpEmail;
    private String corpName;
    private String corpAddress;
    private String corpShippingAddress;
    private String businessRegistrationPath;
    private String buyerTypeFilePath;
    private String ci;
    private String createdId;
    private String modifiedId;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;

    @Builder
    public Buyer(Long seq, String buyerCode, String buyerType, String buyerState, String corpTelNo, String corpPhoneNo, String corpEmail, String corpName, String corpAddress, String corpShippingAddress, String businessRegistrationPath, String buyerTypeFilePath, String ci, String createdId, String modifiedId, LocalDateTime createdDatetime, LocalDateTime modifiedDatetime) {
        this.seq = seq;
        this.buyerCode = buyerCode;
        this.buyerType = buyerType;
        this.buyerState = buyerState;
        this.corpTelNo = corpTelNo;
        this.corpPhoneNo = corpPhoneNo;
        this.corpEmail = corpEmail;
        this.corpName = corpName;
        this.corpAddress = corpAddress;
        this.corpShippingAddress = corpShippingAddress;
        this.businessRegistrationPath = businessRegistrationPath;
        this.buyerTypeFilePath = buyerTypeFilePath;
        this.ci = ci;
        this.createdId = createdId;
        this.modifiedId = modifiedId;
        this.createdDatetime = createdDatetime;
        this.modifiedDatetime = modifiedDatetime;
    }

}
