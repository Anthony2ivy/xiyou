package service;

import model.User;
import model.UserExample;
import model.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Anthony on 2017/2/26.
 */
@Service
public class UserService {
    public static final int SUCCESS=200;
    public static final int USER_NOT_EXITED=301;
    public static final int PASSWD_WRONG=302;
    public static final int TOKEN_TIME_OUT_DAY=10;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public User getUserByUserName(String userName) {
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.selectByPrimaryKey(userName);
        sqlSession.close();
        return user;
    }

    public int insertUser(User inputUser) {
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int result=userMapper.insert(inputUser);
        sqlSession.close();
        return  result;
    }

    public int updateUser(User user)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int result=userMapper.updateByPrimaryKey(user);
        sqlSession.close();
        return  result;
    }

    public String updateUserToken(User user)
    {
        Date currentDate=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,TOKEN_TIME_OUT_DAY);
        String token=(user.getUsername()+user.getPassword()+ currentDate.toString()).hashCode()+"";
        user.setToken(token);
        user.setTokentimeout(calendar.getTime());
        return token;
    }

    public int checkUserPasswd(String userName, String passwd) {
        User user=getUserByUserName(userName);
        if(user==null)
        {
            return USER_NOT_EXITED;
        }else
        {
            if(passwd.equals(user.getPassword()))
            {
                return SUCCESS;
            }
            else{
                return PASSWD_WRONG;
            }
        }
    }

    public User getUserByToken(String Token)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        UserExample userExample=new UserExample();
        userExample.createCriteria().andTokenEqualTo(Token);
        List<User> users=userMapper.selectByExample(userExample);
        if(users.size()==0)
        {
            return null;
        }else
        {
            User user=users.get(0);
            Date timeoutDate=user.getTokentimeout();
            if(timeoutDate.after(new Date()))
            {
                return user;
            }else
            {
                return null;
            }
        }
    }
}
