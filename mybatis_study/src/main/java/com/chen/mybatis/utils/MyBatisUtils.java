package com.chen.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private  static SqlSessionFactory sqlSessionFactory = null;

    static {
        //1.获取主配置文件路径
        String config = "mybatis/mybatis.xml";
        try {
            //2.获取主配置文件输入流
            InputStream is = Resources.getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (sqlSessionFactory != null){
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }
}
