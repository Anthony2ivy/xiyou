package authentication;

import java.util.Date;

/**
 * Created by zwx729915632 on 2016/9/5.
 */
public class AccountToken {
    private String stuId;
    private String token;
    private Date createTime;
    public AccountToken(String stuId,String token){
        this.stuId=stuId;
        this.token=token;
        this.createTime=new Date();
    }

    public String getStuId() {
        return stuId;
    }

    public String getToken() {
        return token;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
