package com.emcikem.mybatisstep04.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @author Emcikem
 * @create 2023/2/19
 * @desc
 */
public class SetFieldInvoker implements Invoker {

    private Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target, args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
