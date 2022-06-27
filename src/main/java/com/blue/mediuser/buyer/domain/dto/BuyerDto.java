package com.blue.mediuser.buyer.domain.dto;

import com.blue.mediuser.buyer.domain.entity.Buyer;
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
public class BuyerDto {

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

    @Builder(builderClassName = "createDto", builderMethodName = "createDto")
    public BuyerDto(Long seq, String buyerCode, String buyerType, String buyerState, String corpTelNo, String corpPhoneNo, String corpEmail, String corpName, String corpAddress, String corpShippingAddress, String businessRegistrationPath, String buyerTypeFilePath, String ci, String createdId, String modifiedId, LocalDateTime createdDatetime, LocalDateTime modifiedDatetime) {
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

    @Builder(builderClassName = "entityByDto", builderMethodName = "entityByDto")
    public BuyerDto(Buyer buyer){
        this.seq = buyer.getSeq();
        this.buyerCode = buyer.getBuyerCode();
        this.buyerType = buyer.getBuyerType();
        this.buyerState = buyer.getBuyerState();
        this.corpTelNo = buyer.getCorpTelNo();
        this.corpPhoneNo = buyer.getCorpPhoneNo();
        this.corpEmail = buyer.getCorpEmail();
        this.corpName = buyer.getCorpName();
        this.corpAddress = buyer.getCorpAddress();
        this.corpShippingAddress = buyer.getCorpShippingAddress();
        this.businessRegistrationPath = buyer.getBusinessRegistrationPath();
        this.buyerTypeFilePath = buyer.getBuyerTypeFilePath();
        this.ci = buyer.getCi();
        this.createdId = buyer.getCreatedId();
        this.modifiedId = buyer.getModifiedId();
        this.createdDatetime = buyer.getCreatedDatetime();
        this.modifiedDatetime = buyer.getModifiedDatetime();
    }

    public Buyer updateEntity(BuyerDto buyerParam){
        return Buyer
                .builder()
                .seq(this.seq)
                .buyerCode(this.buyerCode)
                .buyerType(this.buyerType)
                .buyerState("M") // TODO. 코드타입 상수 R: 가입승인대기, M: 정보변경승인대기, D: 승인완료
                .corpTelNo(buyerParam.getCorpTelNo())
                .corpPhoneNo(buyerParam.getCorpPhoneNo())
                .corpEmail(buyerParam.getCorpEmail())
                .corpName(buyerParam.getCorpName())
                .corpAddress(buyerParam.getCorpAddress())
                .corpShippingAddress(buyerParam.getCorpShippingAddress())
                .businessRegistrationPath(buyerParam.getBusinessRegistrationPath()) // TODO. 파일 저장 경로
                .buyerTypeFilePath(buyerParam.getBuyerTypeFilePath()) // TODO. 파일 저장 경로
                .ci(null) // TODO. 추후 인증 수단 붙을 수 있음. 일단은 null 처리
                .createdId(this.createdId)
                .createdDatetime(this.createdDatetime)
                .modifiedId(TestSession.id)
                .modifiedDatetime(LocalDateTime.now())
                .build();
    }

    public Buyer insertEntity() {
        return Buyer
                .builder()
                .buyerCode(UserTypeConstants.BUYER_IDENTIFICATION + LocalDateTime.now().format(DateFormatUtils.DATETIME_CODE))
                .buyerType(this.buyerType) // TODO. 코드타입 상수 W: 도매업, M: 병의원
                .buyerState("R") // TODO. 코드타입 상수 R: 가입승인대기, M: 정보변경승인대기, D: 승인완료
                .corpTelNo(this.corpTelNo)
                .corpPhoneNo(this.corpPhoneNo)
                .corpEmail(this.corpEmail)
                .corpName(this.corpName)
                .corpAddress(this.corpAddress)
                .corpShippingAddress(this.corpShippingAddress)
                .businessRegistrationPath(this.businessRegistrationPath) // TODO. 파일 저장 경로
                .buyerTypeFilePath(this.buyerTypeFilePath) // TODO. 파일 저장 경로
                .ci(null) // TODO. 추후 인증 수단 붙을 수 있음.
                .createdId(TestSession.id)
                .createdDatetime(LocalDateTime.now())
                .build();
    }
}
