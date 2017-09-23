package daoImpl;

import damain.Comment;
import damain.Blog;
import dao.BlogDao;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/8/4.
 */
public class BlogDaoImpl implements BlogDao {
    @Override
    public List<Blog> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM customer");
            rs = stmt.executeQuery();
            List<Blog> cs = new ArrayList<Blog>();
            while (rs.next()) {
                Blog c = new Blog();
                c.setId(rs.getString("id"));
                c.setName(rs.getString("name"));
                c.setType(rs.getString("type"));
                c.setDescription(rs.getString("description"));
                cs.add(c);
            }
            return cs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }
    }

    @Override
    public void save(Blog c) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("INSERT INTO customer(name,type,description,number,photo) VALUES (?,?,?,?,?)");
//           stmt.setString(1, c.getId());
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getType());
            stmt.setString(3, c.getDescription());
            stmt.setInt(4,1);
            stmt.setInt(5,c.getPhoto());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
           JdbcUtil.release(rs, stmt, conn);
        }
    }

    @Override
    public Blog findById(String customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM customer WHERE id=?");
            stmt.setString(1, customerId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Blog c = new Blog();
                c.setId(rs.getString("id"));
                c.setType(rs.getString("type"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setNumber(rs.getInt("number"));
                return c;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }
    }

    @Override
    public Blog findById2(String customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM customer WHERE id=?");
            stmt.setString(1, customerId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Blog c = new Blog();
                c.setId(rs.getString("id"));
                c.setType(rs.getString("type"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setNumber(rs.getInt("number"));
                return c;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }

    }
    @Override
    public List<Comment> findAllComment(String customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("select * from comment WHERE customer_id=?");
            stmt.setString(1, customerId);
            rs = stmt.executeQuery();
            List<Comment> cs = new ArrayList<>();
            while(rs.next()){
                Comment c = new Comment();
                c.setContent(rs.getString("content"));
                c.setCustomer_id(rs.getInt("customer_id"));
                cs.add(c);
            }
            return cs;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.release(rs, stmt, conn);
        }
    }


    @Override
    public void update(Blog c) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("UPDATE customer SET name =?,type=?,description=?,photo=? WHERE id=?");

            stmt.setString(1, c.getName());
            stmt.setString(2, c.getType());
            stmt.setString(3, c.getDescription());
            stmt.setInt(4,c.getPhoto());
            stmt.setString(5, c.getId());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }
    }

    @Override
    public void update2(Blog c) {  //阅读量
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int num=c.getNumber();
        num++;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("UPDATE customer SET number=? WHERE id=?");
            stmt.setInt(1, num);
            stmt.setString(2, c.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }

    }
    @Override
    public void update3(Comment c) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comment cs=new Comment();
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("INSERT comment SET customer_id=?,content=? ");
            stmt.setString(1, String.valueOf(c.getCustomer_id()));
            stmt.setString(2, c.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }

    }



    @Override
    public void delete(String customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("delete from customer where id=?");
            stmt.setString(1, customerId);
            stmt.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            JdbcUtil.release(rs, stmt, conn);
        }

    }

    @Override
    public int getTotalRecordsNum() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("SELECT count(*) FROM customer");
            rs=stmt.executeQuery();
            if (rs.next()) {
            return  rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }
    }

    @Override
    public List<Blog> getPageRecords(int startIndex, int offset) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM customer limit ?,?");
            stmt.setInt(1,startIndex);
            stmt.setInt(2,offset);
            rs = stmt.executeQuery();
            List<Blog> cs = new ArrayList<Blog>();
            while (rs.next()) {
                Blog c = new Blog();
                c.setId(rs.getString("id"));
                c.setType(rs.getString("type"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setNumber(rs.getInt("number"));
                c.setPhoto(rs.getInt("photo"));
                cs.add(c);
            }
            return cs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.release(rs, stmt, conn);
        }

    }

}