package BServiceImpl;

import common.Page;
import damain.Comment;
import damain.Blog;
import dao.BlogDao;
import daoImpl.BlogDaoImpl;
import service.BService;
import util.IdGenertor;
import Exception.IdIsNullException;

import java.util.List;

/**
 * Created by asus on 2017/8/4.
 */
public class BServiceImpl implements BService{
    private BlogDao dao= (BlogDao) new BlogDaoImpl();

    @Override
    public List<Comment> findAllComment(String customerId) {
        return dao.findAllComment(customerId);
    }

    @Override
    public List<Blog> findAllCustomer() {
        return dao.findAll();
    }

    @Override
    public void saveCustomer(Blog c) {
        if (c==null)
            throw new IllegalArgumentException("数据不全");
         c.getId(IdGenertor.genGUID());
            dao.save(c);
    }

    @Override
    public Blog findCustomerById(String customerId) {
        return dao.findById(customerId);
    }

    @Override
    public Blog findCustomerById2(String customerId) {
        return dao.findById2(customerId);
    }

    @Override
    public void updateCustomer(Blog c) throws IdIsNullException {
        if(c==null)
            throw  new IllegalArgumentException("参数不全");
        if (c.getId()==null||c.getId().trim().equals("")){
            throw new IdIsNullException("id不可为空");
        }
        dao.update(c);

    }

    @Override
    public void updateCustomer2(Blog c) throws IdIsNullException {
        if(c==null)
            throw  new IllegalArgumentException("参数不全");
        if (c.getId()==null||c.getId().trim().equals("")){
            throw new IdIsNullException("id不可为空");
        }
        dao.update2(c);

    }


    @Override
    public void updateCustomer3(Comment c) throws IdIsNullException {
        if(c==null)
            throw  new IllegalArgumentException("参数不全");
        dao.update3(c);

    }
    @Override
    public void deleteCustomerById(String customerId) throws Exception {

              if (customerId==null||customerId.trim().equals("")){
                  throw new Exception("id不可为空");
              }
              dao.delete(customerId);
    }


    @Override
    public Page findPage(String pageNum) {
        int num=1;//用户要看的页码
        if(pageNum!=null&&!pageNum.trim().equals("")){//解析用户要看的页码
            num=Integer.parseInt(pageNum);
        }
        int totalRecords=dao.getTotalRecordsNum();//得到总记录的条数
        Page page=new Page(num,totalRecords);
      //查询分页记录
        List records=dao.getPageRecords(page.getStartIndex(),page.getPageSize());
        page.setRecords(records);
        return page;
    }


}