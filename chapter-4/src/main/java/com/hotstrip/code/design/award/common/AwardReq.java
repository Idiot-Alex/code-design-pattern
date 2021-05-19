package com.hotstrip.code.design.award.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author hotstrip
 * Award request object
 */
@Data
@Builder
public class AwardReq {
    private String userId;
    private String phone;
    // {1: coupon, 2: goods, 3: IQiYiCard}
    private Integer awardType;
    // 业务 ID，可能是优惠券 ID 或者订单 ID 等
    private String bizId;
}
