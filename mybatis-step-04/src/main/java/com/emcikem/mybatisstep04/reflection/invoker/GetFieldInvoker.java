package com.emcikem.mybatisstep04.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author Emcikem
 * @create 2023/2/19
 * @desc
 */
public class GetFieldInvoker implements Invoker {

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
