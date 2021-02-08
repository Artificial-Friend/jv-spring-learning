package service;

import dao.UserDao;
import java.util.List;
import model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Qualifier(value = "userDaoImpl")
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.getAll();
    }
}