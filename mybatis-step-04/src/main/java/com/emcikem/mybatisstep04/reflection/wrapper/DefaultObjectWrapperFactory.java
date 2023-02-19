package com.emcikem.mybatisstep04.reflection.wrapper;

import com.emcikem.mybatisstep04.reflection.MetaObject;

/**
 * @author Emcikem
 * @create 2023/2/19
 * @desc 默认对象包装工厂
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
