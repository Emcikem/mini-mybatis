package com.emcikem.mybatisstep01;

import com.emcikem.mybatisstep01.dao.IUserDao;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public class ApiTest {

    @Test
    public void mapperProxyFactoryTest() {

        // 1. 创建工厂
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        // 2. 模拟sqlSession
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.emcikem.mybatisstep01.dao.IUserDao", "模拟执行mapper.xml里的sql语句，操作：查询用户名称");

        // 3. 通过factory创建代理类对象
        IUserDao iUserDao = factory.newInstance(sqlSession);

        System.out.println(iUserDao.queryUserName("121"));
    }

}
