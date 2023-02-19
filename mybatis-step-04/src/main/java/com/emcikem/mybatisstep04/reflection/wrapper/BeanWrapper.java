package com.emcikem.mybatisstep04.reflection.wrapper;

import com.emcikem.mybatisstep04.reflection.MetaClass;
import com.emcikem.mybatisstep04.reflection.MetaObject;
import com.emcikem.mybatisstep04.reflection.property.PropertyTokenizer;

/**
 * @author Emcikem
 * @create 2023/2/18
 * @desc
 */
public class BeanWrapper extends BaseWrapper{

    /**
     * 原来的对象
     */
    private Object object;

    /**
     * 元类
     */
    private MetaClass metaClass;

    public BeanWrapper(MetaObject metaObject, Object object) {
        super(metaObject);
        this.object = object;
        this.metaClass = MetaClass.forClass(object.getClass());
    }

    @Override
    public Object get(PropertyTokenizer prop) {
        // 如果有index(有中括号),说明是集合，那就要解析集合,调用的是 BaseWrapper.resolveCollection 和 getCollectionValue
        if (prop.getIndex() != null) {
            Object collection = resolveCollection(prop, object);
            return getCollectionValue(prop, collection);
        } else {
            // 否则，getBeanProperty
            return getBeanProperty(prop, object);
        }
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {
        // 如果有index,说明是集合，那就要解析集合,调用的是BaseWrapper.resolveCollection 和 setCollectionValue
        if (prop.getIndex() != null) {
            Object collection = resolveCollection(prop, value);
            setCollectionValue(prop, collection, value);
        } else {
            // 否则，setBeanProperty
            setBeanProperty(prop, object, value);
        }
    }

    @Override
    public boolean hasSetter(String name) {
        return false;
    }

    @Override
    public boolean hasGetter(String name) {
        return false;
    }


    private void setBeanProperty(PropertyTokenizer prop, Object object, Object value) {
        try {
            // 得到setter方法，然后调用
            Invoker method = metaClass.getSetInvoker(prop.getName());
            Object[] params = {value};
            method.
        } catch (Throwable t) {
            throw new RuntimeException("Could not set property '" + prop.getName() + "' of '" + object.getClass() + "' with value '" + value + "' Cause: " + t.toString(), t);
        }
    }
}
