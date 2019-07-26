package com.wct.mybatis.mappers;

import com.wct.mybatis.entity.Student;
import org.apache.ibatis.annotations.Select;

public interface AnnotationBasedMapper {
    @Select("select * from student where stud_id = #{id}")
    Student selectOne(int id);
}
