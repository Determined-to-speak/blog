package util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by asus on 2017/8/15.
 */
public class FormBeanUtil {
    public  static  <T>T  fillBean(HttpServletRequest request,Class<T> clazz){
        try {
            T bean=clazz.newInstance();
            BeanUtils.populate(bean,request.getParameterMap());
            return  bean;
        }  catch (Exception e) {
           throw new RuntimeException();
        }
    }
}
