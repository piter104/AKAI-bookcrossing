package pl.akai.bookcrossing.user;

import pl.akai.bookcrossing.model.User;

public interface UserDao {

    User getUserById(int userId);

    void insertNewUser(User user);

}
