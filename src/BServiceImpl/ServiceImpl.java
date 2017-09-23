package BServiceImpl;

import bean.User;
import dao.UserDao;
import daoImpl.UserDaoImpl;
import service.Service;
import  Exception.UserHasExistException;
import util.DaoFactory;

public class ServiceImpl  implements Service{
    private UserDao dao= new UserDaoImpl();
    @Override
    public void regist(User user) throws UserHasExistException {
    User dbUser=dao.findByUsername(user.getUsername());
    if (dbUser!=null)
        throw new UserHasExistException("用户名"+user.getUsername()+"已存在");
        dao.save(user);
    }

    @Override
    public User login(String username, String password) {
        return dao.findUser(username,password);
    }
}
