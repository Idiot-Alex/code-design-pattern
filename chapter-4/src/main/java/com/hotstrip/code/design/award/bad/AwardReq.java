package com.hotstrip.code.design.award.bad;

import lombok.Data;

/**
 * @author hotstrip
 * Award request object
 */
@Data
public class AwardReq {
    private String userId;
    private String phone;
    // {1: coupon, 2: goods, 3: IQiYiCard}
    private Integer awardType;
}
