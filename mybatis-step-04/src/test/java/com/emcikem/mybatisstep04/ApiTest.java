package com.emcikem.mybatisstep04;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.emcikem.mybatisstep04.dao.IUserDao;
import com.emcikem.mybatisstep04.io.Resources;
import com.emcikem.mybatisstep04.po.User;
import com.emcikem.mybatisstep04.session.SqlSession;
import com.emcikem.mybatisstep04.session.SqlSessionFactory;
import com.emcikem.mybatisstep04.session.SqlSessionFactoryBuilder;
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
        User user = userDao.queryUserInfoById(1L);
        System.out.println(JSONUtil.toJsonStr(user));
    }
}