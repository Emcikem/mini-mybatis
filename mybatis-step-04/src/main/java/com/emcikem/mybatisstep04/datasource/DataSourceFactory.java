package com.emcikem.mybatisstep04.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Emcikem
 * @create 2023/1/2
 * @desc 数据源工厂
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();
}
