package com.emcikem.mybatisstep03.mapping;

/**
 * @author Emcikem
 * @create 2023/1/1
 * @desc SQL 指令类型
 */
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
