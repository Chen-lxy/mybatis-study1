package com.chen.mybatis;

import static org.junit.Assert.assertTrue;

import com.chen.mybatis.entity.Student;
import com.chen.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    public void test() throws IOException {
//        //1.获取主配置文件路径
//        String config = "mybatis/mybatis.xml";
//        //2.获取主配置文件输入流
//        InputStream is = Resources.getResourceAsStream(config);
//        //3.获取sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //4.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //5.要执行的sqlId
        String sqlId = "com.chen.mybatis.mapper.StudentMapper" + "." + "queryAllStudents";
        //6.执行sql语句
        List<Student> students = sqlSession.selectList(sqlId);
        //7.遍历结果
        students.forEach(stu -> System.out.println(stu));
        //8.关闭资源
        sqlSession.close();
    }


    @Test
    public void testAdd() throws IOException {
        //4.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //5.要执行的sqlId
        String sqlId = "com.chen.mybatis.mapper.StudentMapper" + "." + "addStudent";
        Student student = new Student();
        student.setId(1002);
        student.setName("李四");
        student.setEmail("ls@163.com");
        student.setAge(20);
        //6.执行sql语句
        int result = sqlSession.insert(sqlId, student);
        //7.mybatis默认是不提交事务的，我们需要手动提交
        sqlSession.commit();
        //8.遍历结果
        System.out.println(result);
        //9.关闭资源
        sqlSession.close();
    }
}
