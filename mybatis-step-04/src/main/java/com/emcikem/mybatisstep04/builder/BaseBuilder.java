package com.emcikem.mybatisstep04.builder;

import com.emcikem.mybatisstep04.session.Configuration;
import com.emcikem.mybatisstep04.type.TypeAliasRegistry;

/**
 * @author Emcikem
 * @create 2023/1/1
 * @desc 构造器的基类，建造者模式
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
