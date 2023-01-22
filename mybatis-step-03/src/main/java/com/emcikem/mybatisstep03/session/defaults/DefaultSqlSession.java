package com.emcikem.mybatisstep03.session.defaults;

import cn.hutool.json.JSONUtil;
import com.emcikem.mybatisstep03.mapping.MappedStatement;
import com.emcikem.mybatisstep03.session.Configuration;
import com.emcikem.mybatisstep03.session.SqlSession;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + JSONUtil.toJsonStr(parameter) + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
