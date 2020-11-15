package com.chen.mybatis;

import static org.junit.Assert.assertTrue;

import com.chen.mybatis.entity.Student;
import com.chen.mybatis.mapper.StudentMapper;
import com.chen.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void testQuery(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // mybatis利用反射获取mapper对象，执行sql语句
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.queryAllStudents();
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }
}
