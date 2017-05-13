package design_paterns.dao_mvc.dao;

import design_paterns.dao_mvc.Model.User;
import design_paterns.dao_mvc.db.UserDb;

public class StaticUserDaoImpl implements UserDao{

    @Override
    public boolean addUser(User user) {
        return UserDb.users.add(user);
    }

    @Override
    public User removeUser(User user) {
        int userID = UserDb.users.indexOf(user);
        if (userID == -1){
            return null;
        }
        return UserDb.users.remove(userID);
    }

    @Override
    public User findUser(User user) {
        int userID = UserDb.users.indexOf(user);
        return UserDb.users.get(userID);
    }

    @Override
    public User updateUser(User user, User newUser) {
        int userID = UserDb.users.indexOf(user);
        return UserDb.users.set(userID, newUser);
    }
}
