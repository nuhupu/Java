package model;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public DeleteAction() {
    }
    public String execute() throws Exception {
        DAL dal = new DAL();
        if (dal.delete(username)) {
            return "success";
        } else {
            return "error";
        }
    }

}
