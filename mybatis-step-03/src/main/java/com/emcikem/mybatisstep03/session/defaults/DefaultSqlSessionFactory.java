package com.emcikem.mybatisstep03.session.defaults;

import com.emcikem.mybatisstep03.session.Configuration;
import com.emcikem.mybatisstep03.session.SqlSession;
import com.emcikem.mybatisstep03.session.SqlSessionFactory;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {


    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
