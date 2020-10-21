package pl.akai.bookcrossing.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.akai.bookcrossing.model.User;

@Mapper
public interface UserDaoMapper {

    User getUserById(@Param("id") int id);

    void insertNewUser(@Param("user") User user);
}
