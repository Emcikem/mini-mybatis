package com.emcikem.mybatisstep04.reflection.factory;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @author Emcikem
 * @create 2023/2/15
 * @desc 默认对象工厂，所有的对象都有工厂来生成
 */
public class DefaultObjectFactory implements ObjectFactory, Serializable {

    private static final long serialVersionUID = -8855120656740914948L;

    @Override
    public void setProperties(Properties properties) {
        // no props for default 默认无属性可设置
    }

    @Override
    public <T> T create(Class<T> type) {
        return create(type, null, null);
    }


    @SuppressWarnings("uncheckd")
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        // 1. 解析接口
        Class<?> classToCreate = resolveInterface(type);
        // 2. 类实例化
        return (T) instantiateClass(classToCreate, constructorArgTypes, constructorArgs);
    }

    private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        try {

        } catch (Exception e) {

            throw new RuntimeException("Error instantiating " + type + " with invalid types (" + argTypes + ") or values (" + argValues + "). Cause: " + e, e);
        }
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }

    protected Class<?> resolveInterface(Class<?> type) {
        Class<?> classToCreate;
        if (type == List.class || type == Collection.class || type == Iterable.class) {

        }
    }
}
