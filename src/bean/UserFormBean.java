package bean;

import java.util.HashMap;
import java.util.Map;

public class UserFormBean {
    private  String username;
    private  String password;
    private  String repassword;
    private Map<String,String> errors=new HashMap<>();

    public  Map<String,String>getErrors(){
        return errors;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    public  boolean validate(){
        if (username.trim().equals("")){
          errors.put("username","输入为空");
          return false;
        }else{
            if (!username.matches("[a-zA-Z]{3,8}")){
                errors.put("username","请输入3-8位字母");
                return false;
            }
        }
        if (password.trim().equals("")){
            errors.put("password","密码不可为空");
            return false;
        }
        if (!password.equals(repassword)){
            errors.put("repassword","两次密码必须相同");
            return false;
        }
        return  true;
    }
}
