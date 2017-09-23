package service;

import common.Page;
import damain.Comment;
import damain.Blog;

import java.util.List;
import Exception.IdIsNullException;

/**
 * Created by asus on 2017/8/4.
 */
public interface BService {
    List<Comment>findAllComment(String customerId);

    List<Blog> findAllCustomer();

    void saveCustomer(Blog c);

    Blog findCustomerById(String customerId);

    Blog findCustomerById2(String customerId);

    void updateCustomer(Blog c)throws  IdIsNullException;

    void updateCustomer2(Blog c)throws  IdIsNullException;

    void deleteCustomerById(String customerId) throws Exception;
/*
* 根据用户的页码，查询所有分页的page实例
* */
    Page findPage(String  pageNum);

    void updateCustomer3(Comment c) throws IdIsNullException;
}
