package com.emcikem.mybatisstep04.session;

import com.emcikem.mybatisstep04.builder.xml.XMLConfigBuilder;
import com.emcikem.mybatisstep04.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author Emcikem
 * @create 2023/1/1
 * @desc 作为整个mybatis的入口
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
