package com.hotstrip.code.design.award.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author hotstrip
 * Award response object
 */
@Data
@Builder
public class AwardRes {
    private Integer code;
    private String message;

    /**
     * return AwardRes ok
     * @return
     */
    public static AwardRes ok() {
        return AwardRes.builder()
                .code(0)
                .message("ok")
                .build();
    }

    /**
     * return AwardRes error
     * @return
     */
    public static AwardRes error(int code, String message) {
        return AwardRes.builder()
                .code(code)
                .message(message)
                .build();
    }
}
