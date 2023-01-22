package com.emcikem.mybatisstep03;

import com.emcikem.mybatisstep03.dao.IUserDao;
import com.emcikem.mybatisstep03.io.Resources;
import com.emcikem.mybatisstep03.session.SqlSession;
import com.emcikem.mybatisstep03.session.SqlSessionFactory;
import com.emcikem.mybatisstep03.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author Emcikem
 * @create 2023/1/1
 * @desc
 */
public class ApiTest {

    @Test
    public void sqlSessionFactoryTest() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        //
        String result = userDao.queryUserInfoById("1213");
        System.out.println(result);
    }
}
