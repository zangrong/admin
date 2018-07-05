/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: NoUtil.java
 * @date 2018/7/3 22:11
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: NoUtil
 * @Description: 编号工具类
 * @date 2018/7/3 22:11
 * @author zangrong
 */
public class NoUtil {

    private static final Logger log = LoggerFactory.getLogger(NoUtil.class);

    /**
     * 根据传入的数字，转换成一个字符串编号
     * 1 -> 10000001
     * 22 -> 10000022
     * @param value
     * @return
     */
    public static String generate(int value){
        return generate(value, 8);
    }

    public static String generate(int value, int size){
        String no = null;
        try{
            int base = Integer.parseInt(1 + StringUtils.repeat("0", size - 1));
            no = (base + value) + "";
        }catch(Exception e){
            log.warn("", e);
        }
        return no;
    }


}
