package service;

import bean.User;
import  Exception.UserHasExistException;


public interface Service {
    void regist(User user) throws  UserHasExistException;



    User login(String username,String password);


}
