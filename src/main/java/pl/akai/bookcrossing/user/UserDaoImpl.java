package pl.akai.bookcrossing.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.akai.bookcrossing.model.User;
import pl.akai.bookcrossing.user.UserDao;
import pl.akai.bookcrossing.user.UserDaoMapper;

@Component
public class UserDaoImpl implements UserDao {

    private final UserDaoMapper userMapper;

    @Autowired
    UserDaoImpl(UserDaoMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public void insertNewUser(User user) {
        userMapper.insertNewUser(user);
    }
}
