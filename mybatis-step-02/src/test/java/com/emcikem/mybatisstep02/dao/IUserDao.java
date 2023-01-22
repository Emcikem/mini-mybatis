package com.emcikem.mybatisstep02.dao;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public interface IUserDao {

    String queryUserName(String uid);

    Integer queryUserAge(String uid);
}
