package com.emcikem.mybatisstep04.datasource.pooled;

import com.emcikem.mybatisstep04.datasource.unpooled.UnPooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @author Emcikem
 * @create 2023/1/24
 * @desc 有连接池的数据源工厂
 */
public class PooledDataSourceFactory extends UnPooledDataSourceFactory {

    @Override
    public DataSource getDataSource() {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(props.getProperty("driver"));
        pooledDataSource.setUrl(props.getProperty("url"));
        pooledDataSource.setUsername(props.getProperty("username"));
        pooledDataSource.setPassword(props.getProperty("password"));
        return pooledDataSource;
    }
}
