package com.github.stupdit1t.excel.handle;

import com.github.stupdit1t.excel.core.parse.OpsColumn;
import com.github.stupdit1t.excel.handle.rule.BaseVerifyRule;

import java.util.function.BiFunction;


/**
 * 自定义转换
 *
 * @author 625
 */
public class ObjectHandler<R> extends BaseVerifyRule<Object, R> {

    private BiFunction<String, Object, Object> doHandleSub;

    /**
     * 自定义验证
     *
     * @param allowNull 可为空
     */
    public ObjectHandler(boolean allowNull, OpsColumn<R> opsColumn, BiFunction<String, Object, Object> handle) {
        super(allowNull, opsColumn);
        this.doHandleSub = handle;
    }

    @Override
    public Object doHandle(String fieldName, String index, Object cellValue) throws Exception {
        return doHandleSub.apply(fieldName, cellValue);
    }
}
