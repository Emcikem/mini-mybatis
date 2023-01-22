package com.emcikem.mybatisstep04.dao;

import com.emcikem.mybatisstep04.po.User;

/**
 * @author Emcikem
 * @create 2023/1/2
 * @desc
 */
public interface IUserDao {

    User queryUserInfoById(Long id);

}
