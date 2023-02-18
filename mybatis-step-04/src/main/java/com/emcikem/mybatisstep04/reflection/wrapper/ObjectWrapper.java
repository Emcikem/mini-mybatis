package com.emcikem.mybatisstep04.reflection.wrapper;

import com.emcikem.mybatisstep04.reflection.property.PropertyTokenizer;

/**
 * @author Emcikem
 * @create 2023/2/18
 * @desc 对象包装器
 */
public interface ObjectWrapper {


    /**
     * get
     */
    Object get(PropertyTokenizer prop);

    /**
     * set
     */
    void set(PropertyTokenizer prop, Object value);

    /**
     * 是否有指定的setter
     */
    boolean hasSetter(String name);

    /**
     * 是否有指定的getter
     */
    boolean hasGetter(String name);

}
