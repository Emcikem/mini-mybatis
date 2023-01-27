package com.emcikem.mybatisstep04;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.emcikem.mybatisstep04.dao.IUserDao;
import com.emcikem.mybatisstep04.datasource.pooled.PooledDataSource;
import com.emcikem.mybatisstep04.io.Resources;
import com.emcikem.mybatisstep04.po.User;
import com.emcikem.mybatisstep04.session.SqlSession;
import com.emcikem.mybatisstep04.session.SqlSessionFactory;
import com.emcikem.mybatisstep04.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

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


    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3.测试验证
        for (int i = 0; i < 50; i++) {
            User user = userDao.queryUserInfoById(1L);
            System.out.printf("%s, 测试结果：%s\n", i, user);
        }
    }


    @Test
    public void test_pooled() throws SQLException, InterruptedException {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://localhost:3306/mybatis?useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=false&amp;serverTimezone=Asia/Shanghai");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("lct09051415");

        while (true) {
            Connection connection = pooledDataSource.getConnection();
            System.out.println(connection);
            Thread.sleep(1000);
            connection.close();
        }
    }
}
