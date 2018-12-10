package com.wct.mybatis.main;

import com.wct.mybatis.entity.Student;
import com.wct.mybatis.mappers.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        testInsert();
        testUpdate();
    }

    private static void testInsert(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

//        接口方式调用
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = new Student("王晨韬","710889210@qq.com",new Date());
//        studentMapper.insertStudent(student);

        Student student2 = new Student("潘文昕","710889210@qq.com",new Date());
        int result = sqlSession.insert("com.wct.mybatis.mappers.StudentMapper.insertStudent",student2);
        System.out.println("影响的行数："+result);

        sqlSession.commit();
        sqlSession.close();
    }

    private static void testUpdate(){
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findStudentById(1);
        student.setName("王王");
        studentMapper.update(student);

        sqlSession.commit();
        sqlSession.close();
    }
}
