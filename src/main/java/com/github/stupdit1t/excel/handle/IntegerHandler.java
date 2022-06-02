package com.github.stupdit1t.excel.handle;

import com.github.stupdit1t.excel.common.PoiConstant;
import com.github.stupdit1t.excel.common.PoiException;
import com.github.stupdit1t.excel.handle.rule.BaseVerifyRule;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;


/**
 * int数据校验
 *
 * @author 625
 */
public class IntegerHandler extends BaseVerifyRule<Integer> {
    /**
     * 常规验证
     *
     * @param allowNull 可为空
     */
    public IntegerHandler(boolean allowNull) {
        super(allowNull);
    }

    @Override
    public Integer doHandle(String fieldName, String index, Object cellValue) throws Exception {
        String value = String.valueOf(cellValue);
        if (cellValue instanceof Integer) {
            return (Integer) cellValue;
        } else if (NumberUtils.isCreatable(value)) {
            return new BigDecimal(value).intValue();
        }
        throw PoiException.error(String.format(PoiConstant.INCORRECT_FORMAT_STR, fieldName, index));
    }
}
