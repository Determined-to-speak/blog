package util;

import dao.UserDao;

import java.util.ResourceBundle;

public class DaoFactory {
    public  static UserDao getUserDao(){
        try {
        ResourceBundle rb=ResourceBundle.getBundle("dao");
        String className=rb.getString("UserDao");

            return (UserDao) Class.forName(className).newInstance();
        } catch  (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
