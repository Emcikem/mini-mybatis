package com.emcikem.mybatisstep04.session;

import com.emcikem.mybatisstep04.binding.MapperRegistry;
import com.emcikem.mybatisstep04.datasource.druid.DruidDataSourceFactory;
import com.emcikem.mybatisstep04.datasource.pooled.PooledDataSource;
import com.emcikem.mybatisstep04.datasource.unpooled.UnPooledDataSourceFactory;
import com.emcikem.mybatisstep04.mapping.Environment;
import com.emcikem.mybatisstep04.mapping.MappedStatement;
import com.emcikem.mybatisstep04.transaction.jdbc.JdbcTransactionFactory;
import com.emcikem.mybatisstep04.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Emcikem
 * @create 2023/1/1
 * @desc
 */
public class Configuration {

    /**
     * 环境
     */
    protected Environment environment;

    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     * key:接口方法的全路径名称（含包名）
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    /**
     * 类型别名注册机
     */
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();


    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);

        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnPooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSource.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
