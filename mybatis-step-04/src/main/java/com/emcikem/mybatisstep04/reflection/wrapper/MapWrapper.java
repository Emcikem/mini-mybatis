package com.emcikem.mybatisstep04.reflection.wrapper;

import com.emcikem.mybatisstep04.reflection.MetaObject;
import com.emcikem.mybatisstep04.reflection.property.PropertyTokenizer;

import java.util.Map;

/**
 * @author Emcikem
 * @create 2023/2/18
 * @desc Map包装器
 */
public class MapWrapper extends BaseWrapper{

    /**
     * 原来的对象
     */
    private Map<String, Object> map;

    public MapWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject);
        this.map = map;
    }

    // get,set是允许的
    @Override
    public Object get(PropertyTokenizer prop) {
        //如果有index,说明是集合，那就要分解集合,调用的是BaseWrapper.resolveCollection 和 getCollectionValue
        if (prop.getIndex() != null) {
            Object collection = resolveCollection(prop, map);
            return getCollectionValue(prop, collection);

        } else {
            return map.get(prop.getName());
        }
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {

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
