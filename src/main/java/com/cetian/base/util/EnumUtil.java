/**
 * @Copyright: 2018 720yun.com Inc. All rights reserved.
 * @Title: EnumUtil.java
 * @date 2018/7/3 14:53
 * @version V1.0
 * @author zangrong
 */
package com.cetian.base.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.EnumUtils;
import org.apache.el.util.ReflectionUtil;
import org.springframework.util.ReflectionUtils;

import com.cetian.base.entity.EnumMessage;
import com.cetian.base.entity.KeyValue;
import com.cetian.module.company.entity.CompanyTypeEnum;

/**
 * @author zangrong
 * @ClassName: EnumUtil
 * @Description: TODO
 * @date 2018/7/3 14:53
 */
public class EnumUtil {


    public static <E extends Enum<E>> List<KeyValue<String, Integer>> getOptionList(Class<E> enumClass){
        List<E> enumList = EnumUtils.getEnumList(enumClass);
        List<KeyValue<String, Integer>> list = enumList.stream().map(e -> (EnumMessage) e)
                .map(e -> new KeyValue<String, Integer>(e.getMessage(), e.getValue())).collect(Collectors.toList());
        return list;
    }

}
