package com.emcikem.mybatisstep04.datasource.unpooled;

import com.emcikem.mybatisstep04.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Emcikem
 * @create 2023/1/24
 * @desc 无池化数据源工厂
 */
public class UnPooledDataSourceFactory implements DataSourceFactory {

    protected Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        UnPooledDataSource unPooledDataSource = new UnPooledDataSource();
        unPooledDataSource.setDriver(props.getProperty("driver"));
        unPooledDataSource.setUrl(props.getProperty("url"));
        unPooledDataSource.setUsername(props.getProperty("username"));
        unPooledDataSource.setPassword(props.getProperty("password"));
        return unPooledDataSource;
    }
}
