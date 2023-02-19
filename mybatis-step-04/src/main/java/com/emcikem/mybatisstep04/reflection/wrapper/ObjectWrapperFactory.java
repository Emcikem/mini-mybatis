package com.emcikem.mybatisstep04.reflection.wrapper;

import com.emcikem.mybatisstep04.reflection.MetaObject;

/**
 * @author Emcikem
 * @create 2023/2/19
 * @desc 对象包装工厂
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装类
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
