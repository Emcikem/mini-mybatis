package com.emcikem.mybatisstep02.session.defaults;

import com.emcikem.mybatisstep02.binding.MapperRegistry;
import com.emcikem.mybatisstep02.session.SqlSession;
import com.emcikem.mybatisstep02.session.SqlSessionFactory;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {


    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
