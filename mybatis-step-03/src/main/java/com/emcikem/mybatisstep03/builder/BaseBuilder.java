package com.emcikem.mybatisstep03.builder;

import com.emcikem.mybatisstep03.session.Configuration;

/**
 * @author Emcikem
 * @create 2023/1/1
 * @desc 构造器的基类，建造者模式
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
