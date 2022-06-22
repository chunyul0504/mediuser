package com.blue.mediuser.buyer.domain.dto;

import com.blue.mediuser.buyer.domain.entity.Buyer;
import com.blue.mediuser.buyer.domain.entity.BuyerIdentification;
import com.blue.mediuser.common.constants.UserTypeConstants;
import com.blue.mediuser.common.util.DateFormatUtils;
import com.blue.mediuser.common.util.TestSession;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

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

    @Builder
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

    public BuyerIdentificationDto(BuyerIdentification buyerIdentification) {
        this.seq = buyerIdentification.getSeq();
        this.buyer = new BuyerDto(buyerIdentification.getBuyer());
        this.buyerIdentificationCode = buyerIdentification.getBuyerIdentificationCode();
        this.identificationType = buyerIdentification.getIdentificationType();
        this.id = buyerIdentification.getId();
        this.password = buyerIdentification.getPassword(); // TODO. 이거 나중에 빼야함.
        this.staffName = buyerIdentification.getStaffName();
        this.staffTelNo = buyerIdentification.getStaffTelNo();
        this.staffPhoneNo = buyerIdentification.getStaffPhoneNo();
        this.createdId = buyerIdentification.getCreatedId();
        this.createdDatetime = buyerIdentification.getCreatedDatetime();
    }

    public BuyerIdentification insertEntity() {
        return BuyerIdentification
                .builder()
                .buyer(Buyer.builder().seq(this.buyer.getSeq()).build())
                .buyerIdentificationCode(UserTypeConstants.BUYER + LocalDateTime.now().format(DateFormatUtils.DATETIME_CODE))
                .identificationType(this.identificationType) // TODO. 코드타입 상수 M: 메인 계정, P: 부계정
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

}
