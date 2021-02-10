package dao;

import java.util.List;
import model.User;

public interface UserDao {
    void add(User user);

    List<User> getAll();

    User get(Long id);
}
