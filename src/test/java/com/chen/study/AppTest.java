package com.chen.study;

import static org.junit.Assert.assertTrue;

import com.chen.study.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testCount() throws IOException {
//        1.通过配置文件获取SqlSessionFactory
        String resource = "configuration.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        2.通过sqlSessionFactory构建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3.通过sqlSession操作数据库
        int count = sqlSession.getMapper(UserMapper.class).count();
        System.out.println(count);
//        4.关闭会话
        sqlSession.close();
    }
}
