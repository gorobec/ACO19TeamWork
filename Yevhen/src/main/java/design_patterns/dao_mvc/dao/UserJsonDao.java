package design_patterns.dao_mvc.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import design_patterns.dao_mvc.model.User;
import design_patterns.dao_mvc.utils.FileUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class UserJsonDao implements UserDao {


    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String USERS_PATH = "./Yevhen/src/main/resources/user/users.txt";

    public UserJsonDao() {
    }

    @Override
    public boolean addUser(User user) {

        String usersJson = FileUtils.readJsonFromFile(USERS_PATH);
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();

        List<User> users = gson.fromJson(usersJson, listType);
        if(users == null) users = new LinkedList<>();
        users.add(user);
        usersJson = gson.toJson(users, listType);

        return FileUtils.writeJsonToFile(USERS_PATH, usersJson);
    }

    @Override
    public User removeUser(User user) {


        String usersJson = FileUtils.readJsonFromFile(USERS_PATH);
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();

        List<User> users = gson.fromJson(usersJson, listType);

        int userID = users.indexOf(user);
        if(userID == -1) return null;
        User removed = users.remove(userID);
        usersJson = gson.toJson(users, listType);
        FileUtils.writeJsonToFile(USERS_PATH, usersJson);

        return removed;
    }

    @Override
    public User findUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user, User newUser) {
        return null;
    }
}
