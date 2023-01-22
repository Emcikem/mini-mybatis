package com.emcikem.mybatisstep01;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc 映射器代理类
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {


    private static final long serialVersionUID = 7457086164027012466L;


    private Map<String, String> sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Object通用的方法不要被代理
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(args);
        } else {
            return "你被代理了 " + sqlSession.get(mapperInterface.getName()) + " " + method.getName();
        }
    }
}
