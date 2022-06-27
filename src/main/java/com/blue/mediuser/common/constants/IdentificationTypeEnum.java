package com.blue.mediuser.common.constants;

import lombok.Getter;

@Getter
public enum IdentificationTypeEnum {

    MAIN("M", "MAIN", "메인계정"),
    SUB("P", "SUB", "서브계정");
    private String code;
    private String type;
    private String description;

    IdentificationTypeEnum(String code, String type, String description) {
        this.code = code;
        this.type = type;
        this.description = description;
    }


}
