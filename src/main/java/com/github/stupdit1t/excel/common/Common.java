package com.github.stupdit1t.excel.common;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一些公用的方法
 */
public class Common {

    /**
     * 合并单元格转换
     *
     * @param obj
     * @return Object[]
     */
    public static Object[] coverRange(Object obj) {
        String[] range = ((String) obj).split(",");
        Object[] rangeInt = new Object[4];
        for (int i = 0; i < range.length; i++) {
            if (i < 2) {
                rangeInt[i] = Integer.parseInt(range[i]);
            } else {
                rangeInt[i] = range[i];
            }

        }
        return rangeInt;
    }

    /**
     * 获取实体的所有字段
     *
     * @param t
     * @return Map<String, Field>
     */
    public static Map<String, Field> getAllFields(Class<?> t) {
        Map<String, Field> field = new HashMap<>();
        List<Field> allFieldsList = FieldUtils.getAllFieldsList(t);
        allFieldsList.stream().forEach(n -> {
            n.setAccessible(true);
            field.put(n.getName(), n);
        });
        return field;
    }

    /**
     * 字母相加
     *
     * @param charStr
     */
    public static String charAdd(String charStr) {
        char[] chars = charStr.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i != 0 && chars[i] == 90) {
                chars[i] = 'A';
                continue;
            }
            // 位数满了, 需要增加位数
            if (i == 0 && chars[i] == 90) {
                chars = new char[chars.length + 1];
                for (int j = 0; j < chars.length; j++) {
                    chars[j] = 'A';
                }
                break;
            }
            chars[i] = (char) (chars[i] + 1);
            break;
        }

        return new String(chars);
    }
}
