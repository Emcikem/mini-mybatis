package com.emcikem.mybatisstep02.session;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
