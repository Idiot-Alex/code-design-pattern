package com.hotstrip.code.design.adapter.good;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hotstrip
 * 业务实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebateInfo {
    // 用户 ID
    private String userId;
    // 业务 ID
    private String bizId;
    // 业务时间
    private String bizTime;
    // 业务描述
    private String desc;
}
