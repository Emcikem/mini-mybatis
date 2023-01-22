package com.emcikem.mybatisstep02.session.defaults;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.emcikem.mybatisstep02.binding.MapperRegistry;
import com.emcikem.mybatisstep02.session.SqlSession;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了" + statement + "入参: " + JSONUtil.toJsonStr(parameter));
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
