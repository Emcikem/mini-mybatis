package com.emcikem.mybatisstep04.reflection.wrapper;

import com.emcikem.mybatisstep04.reflection.MetaObject;
import com.emcikem.mybatisstep04.reflection.property.PropertyTokenizer;

import java.util.Collection;

/**
 * @author Emcikem
 * @create 2023/2/18
 * @desc Collection包装器
 */
public class CollectionWrapper implements ObjectWrapper{

    /**
     * 原来对象
     */
    private Collection<Object> objects;

    public CollectionWrapper(MetaObject metaObject, Collection<Object> object) {
        this.objects = objects;
    }

    // get,set都是不允许的,只能添加元素
    @Override
    public Object get(PropertyTokenizer prop) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasSetter(String name) {
        return false;
    }

    @Override
    public boolean hasGetter(String name) {
        return false;
    }
}
