package design_patterns.dao_mvc.dao;

import design_patterns.dao_mvc.model.User;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public interface UserDao {
    boolean addUser(User user);
    User removeUser(User user);
    User findUser(User user);
    User updateUser(User user, User newUser);
}
