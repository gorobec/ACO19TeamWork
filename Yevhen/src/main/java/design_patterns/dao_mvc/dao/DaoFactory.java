package design_patterns.dao_mvc.dao;

import design_patterns.dao_mvc.exceptions.UnsupportedDaoException;

/**
 * Created by gorobec on 21.05.17.
 */
public class DaoFactory {

    public static UserDao getInstance(String dao) {
        switch (dao){
            case "json":
                return new UserJsonDao();
            case "static":
                return new StaticUserDaoImpl();
            default:
                throw new UnsupportedDaoException();
        }
    }
}
