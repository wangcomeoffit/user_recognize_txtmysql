package user_recognize_txt;

import java.util.HashMap;
import java.util.Map;

public class Recognize {
    private Map<String, String> _id;
    private String model;
    private Map<String, String> upd_time;
    private String content;
    private String result;
    private Map<String, String> user_id;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //private String user_id;

    public Map<String, String> getUpd_time() {
        return upd_time;
    }

    public void setUpd_time(Map<String, String> upd_time) {
        this.upd_time = upd_time;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public Map<String, String> get_id() {
        return _id;
    }

    public void set_id(Map<String, String> _id) {
        this._id = _id;
    }

    /*public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }*/

    public Map<String, String> getUser_id() {
        return user_id;
    }

    public void setUser_id(Map<String, String> user_id) {
        this.user_id = user_id;
    }
}
