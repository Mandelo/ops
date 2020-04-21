package com.fly.ops.utils;

import com.fly.ops.entity.JvmInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * @Classname JvmUtil
 * @Description 系统信息收集工具
 * @Date 2020/4/21
 * @Created by luox
 */

public class SystemInfoUtil {

    private static final long MB = 1048576L;

    public static JvmInfo getJvmInfo(){

        MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
        MemoryUsage headMemory = memory.getHeapMemoryUsage();


        JvmInfo jvmInfo = new JvmInfo();
        //设置最大内存
        jvmInfo.setMaxMemorySize(headMemory.getMax() / MB + " MB");
        //设置已使用内存
        jvmInfo.setUsedMemorySize(headMemory.getUsed() / MB + " MB");
        return jvmInfo;
    }



}
