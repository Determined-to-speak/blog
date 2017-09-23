package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2017/8/15.
 */
public class BlogFormBean {
    private  String photo;
    private  String id;
    private  String  name;
    private  String description;
    private String type;
    private  String content;

    private Map<String,String> errors=new HashMap<String,String>();



    public Map<String, String> getErrors() {
        return errors;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
