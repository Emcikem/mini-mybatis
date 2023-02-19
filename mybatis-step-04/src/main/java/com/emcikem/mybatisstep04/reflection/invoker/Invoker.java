package com.emcikem.mybatisstep04.reflection.invoker;

/**
 * @author Emcikem
 * @create 2023/2/19
 * @desc 调用者
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();
}
