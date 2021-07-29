package com.hotstrip.code.design.chapter18.group;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 雇员实体类
 * @author Hotstrip
 */
@NoArgsConstructor
@Data
public class Employee {
    // ID
    private String id;
    // 姓名
    private String name;
    // 备注
    private String desc;
}
