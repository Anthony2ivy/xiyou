package service;

import model.Student;
import model.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Anthony on 2016/8/9.
 */

@Service
public class StudentSession {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public Student findStudentById(int id){
        SqlSession sqlSession =sqlSessionFactory.openSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        return studentMapper.selectByPrimaryKey(id);
    }
}
