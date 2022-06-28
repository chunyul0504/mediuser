package com.blue.mediuser.buyer.domain.dto;

import com.blue.mediuser.buyer.domain.entity.Buyer;
import com.blue.mediuser.buyer.domain.entity.BuyerIdentification;
import com.blue.mediuser.common.constants.IdentificationTypeEnum;
import com.blue.mediuser.common.constants.UserTypeConstants;
import com.blue.mediuser.common.util.DateFormatUtils;
import com.blue.mediuser.common.util.TestSession;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
public class BuyerIdentificationDto {

    private Long seq;
    private BuyerDto buyer;
    private String buyerIdentificationCode;
    private String identificationType;
    private String id;
    private String password;
    private String staffName;
    private String staffTelNo;
    private String staffPhoneNo;
    private String staffEmail;
    private String createdId;
    private String modifiedId;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;

    public BuyerIdentificationDto(){
    }

    @Builder(builderClassName = "byCreate", builderMethodName = "byCreate")
    public BuyerIdentificationDto(Long seq, BuyerDto buyer, String buyerIdentificationCode, String identificationType, String id, String password, String staffName, String staffTelNo, String staffPhoneNo, String staffEmail, String createdId, String modifiedId, LocalDateTime createdDatetime, LocalDateTime modifiedDatetime) {
        this.seq = seq;
        this.buyer = buyer;
        this.buyerIdentificationCode = buyerIdentificationCode;
        this.identificationType = identificationType;
        this.id = id;
        this.password = password;
        this.staffName = staffName;
        this.staffTelNo = staffTelNo;
        this.staffPhoneNo = staffPhoneNo;
        this.staffEmail = staffEmail;
        this.createdId = createdId;
        this.modifiedId = modifiedId;
        this.createdDatetime = createdDatetime;
        this.modifiedDatetime = modifiedDatetime;
    }

    @Builder(builderClassName = "byEntity", builderMethodName = "byEntity")
    public BuyerIdentificationDto(BuyerIdentification buyerIdentification) {
        this.seq = buyerIdentification.getSeq();
        this.buyer = BuyerDto.byEntity().buyer(buyerIdentification.getBuyer()).build();
        this.buyerIdentificationCode = buyerIdentification.getBuyerIdentificationCode();
        this.identificationType = buyerIdentification.getIdentificationType();
        this.id = buyerIdentification.getId();
        this.password = buyerIdentification.getPassword();
        this.staffName = buyerIdentification.getStaffName();
        this.staffTelNo = buyerIdentification.getStaffTelNo();
        this.staffPhoneNo = buyerIdentification.getStaffPhoneNo();
        this.staffEmail = buyerIdentification.getStaffEmail();
        this.createdId = buyerIdentification.getCreatedId();
        this.modifiedId = buyerIdentification.getModifiedId();
        this.createdDatetime = buyerIdentification.getCreatedDatetime();
        this.modifiedDatetime = buyerIdentification.getModifiedDatetime();
    }

    @Builder(builderClassName = "selectByEntity", builderMethodName = "selectByEntity")
    public BuyerIdentificationDto(BuyerIdentification buyerIdentification, Buyer buyer) {
        this.seq = buyerIdentification.getSeq();
        this.buyer = BuyerDto.byEntity().buyer(buyer).build();
        this.buyerIdentificationCode = buyerIdentification.getBuyerIdentificationCode();
        this.identificationType = buyerIdentification.getIdentificationType();
        this.id = buyerIdentification.getId();
        this.password = buyerIdentification.getPassword();
        this.staffName = buyerIdentification.getStaffName();
        this.staffTelNo = buyerIdentification.getStaffTelNo();
        this.staffPhoneNo = buyerIdentification.getStaffPhoneNo();
        this.staffEmail = buyerIdentification.getStaffEmail();
        this.createdId = buyerIdentification.getCreatedId();
        this.modifiedId = buyerIdentification.getModifiedId();
        this.createdDatetime = buyerIdentification.getCreatedDatetime();
        this.modifiedDatetime = buyerIdentification.getModifiedDatetime();
    }


    public BuyerIdentification insertEntity(String identificationType) {
        return BuyerIdentification
                .builder()
                .buyer(Buyer.builder().seq(this.buyer.getSeq()).build())
                .buyerIdentificationCode(UserTypeConstants.BUYER + LocalDateTime.now().format(DateFormatUtils.DATETIME_CODE))
                .identificationType(identificationType) // TODO. 코드타입 상수 M: 메인 계정, P: 부계정
                .id(this.id)
                .password(this.password) // TODO.암호화
                .staffName(this.staffName)
                .staffTelNo(this.staffTelNo)
                .staffPhoneNo(this.staffPhoneNo)
                .staffEmail(this.staffEmail)
                .createdId(TestSession.id)
                .createdDatetime(LocalDateTime.now())
                .build();
    }

    public BuyerIdentification updateEntity(BuyerIdentificationDto biDtoParam) {
        return BuyerIdentification
                .builder()
                .seq(this.seq)
                .buyer(this.buyer.updateEntity(biDtoParam.getBuyer(), "M"))
                .buyerIdentificationCode(this.buyerIdentificationCode)
                .identificationType(this.identificationType) // TODO. 코드타입 상수 M: 메인 계정, P: 부계정
                .id(this.id)
                .password(this.password) // TODO.암호화
                .staffName(biDtoParam.getStaffName())
                .staffTelNo(biDtoParam.getStaffTelNo())
                .staffPhoneNo(biDtoParam.getStaffPhoneNo())
                .staffEmail(biDtoParam.getStaffEmail())
                .createdId(this.createdId)
                .createdDatetime(this.createdDatetime)
                .modifiedId(TestSession.id)
                .modifiedDatetime(LocalDateTime.now())
                .build();
    }

}
