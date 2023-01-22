package com.emcikem.mybatisstep02;

import com.emcikem.mybatisstep02.binding.MapperRegistry;
import com.emcikem.mybatisstep02.dao.ISchoolDao;
import com.emcikem.mybatisstep02.dao.IUserDao;
import com.emcikem.mybatisstep02.session.SqlSession;
import com.emcikem.mybatisstep02.session.SqlSessionFactory;
import com.emcikem.mybatisstep02.session.defaults.DefaultSqlSessionFactory;
import org.junit.jupiter.api.Test;


/**
 * @author Emcikem
 * @create 2022/12/31
 * @desc
 */
public class ApiTest {

    @Test
    public void mapperProxyFactoryTest() {

        // 1. 注册mapper
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.emcikem.mybatisstep02.dao");

        // 2. 从SqlSession工厂获取Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        System.out.println(userDao.queryUserName("121"));

        ISchoolDao schoolDao = sqlSession.getMapper(ISchoolDao.class);
        System.out.println(schoolDao.querySchoolName(1L));
    }

}
