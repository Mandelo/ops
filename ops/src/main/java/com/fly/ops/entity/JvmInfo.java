package com.fly.ops.entity;

import lombok.Data;

/**
 * @Classname JvmInfo
 * @Description
 * @Date 2020/4/21
 * @Created by luox
 */

@Data
public class JvmInfo {

    private String maxMemorySize;//最大内存
    private String usedMemorySize;//已使用内存
}
