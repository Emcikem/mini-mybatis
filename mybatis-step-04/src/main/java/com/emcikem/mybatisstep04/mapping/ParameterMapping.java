package com.emcikem.mybatisstep04.mapping;

import com.emcikem.mybatisstep04.session.Configuration;
import com.emcikem.mybatisstep04.type.JdbcType;

/**
 * @author Emcikem
 * @create 2023/1/2
 * @desc 参数映射 #{property,javaType=int,jdbcType=NUMERIC}
 */
public class ParameterMapping {

    private Configuration configuration;

    /**
     * property
     */
    private String property;

    /**
     * javaType = int
     */
    private Class<?> javaType = Object.class;

    /**
     * jdbcType=NUMERIC
     */
    private JdbcType jdbcType;

    public ParameterMapping() {
    }


    public static class Builder {

        private ParameterMapping parameterMapping = new ParameterMapping();

        public Builder(Configuration configuration, String property) {
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
        }

        public Builder javaType(Class<?> javaType) {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder javaType(JdbcType jdbcType) {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getProperty() {
        return property;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }
}
