package model;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
public class ShowAction extends ActionSupport {
    List<employee> list;
    public List<employee> getList() {
        return list;
    }
    public void setList(List<employee> list) {
        this.list = list;
    }    
    public ShowAction() {    }    
    public String execute() throws Exception {
       DAL dal = new DAL();
       list = dal.show();
       return "success";
    }
    
}
