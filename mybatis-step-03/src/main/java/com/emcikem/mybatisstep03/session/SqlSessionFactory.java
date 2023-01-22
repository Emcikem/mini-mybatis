package com.emcikem.mybatisstep03.session;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
