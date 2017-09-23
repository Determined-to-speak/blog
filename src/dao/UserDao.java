package dao;

import bean.User;

public interface UserDao {
    User findByUsername(String Username);

    void save(User user);

    User findUser(String username,String password);
}
