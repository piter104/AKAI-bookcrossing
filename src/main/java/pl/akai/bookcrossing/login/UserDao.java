package pl.akai.bookcrossing.login;

import pl.akai.bookcrossing.model.User;

public interface UserDao {

    User getUserById(int userId);

    User getUserByEmail(String email);

    void insertNewUser(User user);

}
