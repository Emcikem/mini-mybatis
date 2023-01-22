package com.emcikem.mybatisstep02.binding;

import com.emcikem.mybatisstep02.session.SqlSession;

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


    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Object通用的方法不要被代理
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
