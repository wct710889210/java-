package com.wct.mybatis.main;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSqlSessionFactory {
    private static SqlSessionFactory factory;

    public static SqlSessionFactory getSqlSessionFactory(){
        if(factory == null){
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
                factory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return factory;
    }

    public static SqlSession openSession(){
        return getSqlSessionFactory().openSession();
    }
}
