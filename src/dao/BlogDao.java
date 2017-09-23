package dao;

import damain.Comment;
import damain.Blog;

import java.util.List;

/**
 * Created by asus on 2017/8/4.
 */
public interface BlogDao {

     List<Blog> findAll();

     void save(Blog c);

    Blog findById(String customerId);

    Blog findById2(String customerId);

    void update(Blog c);

    void  update2(Blog c);

    void delete(String customerId);
/*
*得到总记录的条数
* */
    int getTotalRecordsNum();
/*
* 分页查询
* */
    List<Blog> getPageRecords(int startIndex, int offset);

    void update3(Comment c);

    List<Comment> findAllComment(String customerId);
}
