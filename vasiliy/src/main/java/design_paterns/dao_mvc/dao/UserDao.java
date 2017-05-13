package design_paterns.dao_mvc.dao;

import design_paterns.dao_mvc.Model.User;

public interface UserDao {
    boolean addUser (User user);
    User removeUser (User user);
    User findUser (User user);
    User updateUser(User user, User newUser);
}
