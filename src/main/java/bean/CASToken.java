package bean;

/**
 * Created by lzw on 16-9-5.
 */
public class CASToken {
    private String access_token;
    private int expires;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }
}
