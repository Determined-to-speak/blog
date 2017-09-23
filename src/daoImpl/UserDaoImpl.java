package daoImpl;

import bean.User;
import dao.UserDao;
import util.JdbcUtil;
import util.JdbcUtil1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl implements UserDao{
    @Override
    public User findByUsername(String username) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtil1.getConnection();
            stmt=conn.prepareStatement("SELECT username,password FROM user WHERE  username=?");
            stmt.setString(1,username);
            rs=stmt.executeQuery();
            if (rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return  user;
            }
            return null;
        } catch (Exception e) {
         throw new  RuntimeException(e);
        }finally{
            JdbcUtil1.release(rs,stmt,conn);
        }

    }

    @Override
    public void save(User user) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil1.getConnection();
            stmt=conn.prepareStatement("INSERT into user (username,password) values (?,?)");
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getPassword());
            stmt.executeUpdate();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }finally {
            JdbcUtil1.release(rs,stmt,conn);
        }

    }

    @Override
    public User findUser(String username, String password) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil1.getConnection();
            stmt=conn.prepareStatement("SELECT username,password FROM user where username=? and password=?");
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            if (rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            return null;
        } catch (Exception e) {
         throw new RuntimeException(e);
        }finally {
            JdbcUtil1.release(rs,stmt,conn);
        }

    }
}
