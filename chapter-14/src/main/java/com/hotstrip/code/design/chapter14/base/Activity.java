package com.hotstrip.code.design.chapter14.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 活动实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private Long id;
    private String name;
    private String desc;
    private Date startTime;
    private Date stopTime;
    private Stock stock;
}
