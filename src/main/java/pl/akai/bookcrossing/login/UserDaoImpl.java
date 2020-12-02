package pl.akai.bookcrossing.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.akai.bookcrossing.model.User;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserDaoMapper userMapper;

//    @Autowired
//    UserDaoImpl(UserDaoMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    @Override
    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userMapper.getUserByEmail(email);
    }

    @Override
    public void insertNewUser(User user) {
        userMapper.insertUser(user);
    }


}
