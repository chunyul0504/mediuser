package com.blue.mediuser.common.constants;

import lombok.Getter;

@Getter
public enum BuyerTypeEnum {

    WHOLESALE("W", "WHOLESALE", "도매업"),
    MEDICAL("M", "MEDICAL", "병의원");
    private String code;
    private String type;
    private String description;

    BuyerTypeEnum(String code, String type, String description) {
        this.code = code;
        this.type = type;
        this.description = description;
    }

    public static boolean existsCode(String buyerType) {
        for (BuyerTypeEnum buyerTypeEnum : BuyerTypeEnum.values()) {
            if (buyerTypeEnum.code.equals(buyerType)) {
                return true;
            }
        }
        return false;
    }

}
