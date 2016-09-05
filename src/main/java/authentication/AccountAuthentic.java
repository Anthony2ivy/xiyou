package authentication;

import java.util.*;

/**
 * Created by zwx729915632 on 2016/9/5.
 */
public class AccountAuthentic {
    private HashMap<String,AccountToken> tokenList;
    public AccountAuthentic()
    {
        this.tokenList=new HashMap<String,AccountToken>();
    }
    public void addToken(String token,String id)
    {
        AccountToken accountToken=new AccountToken(id,token);
        tokenList.put(token,accountToken);
    }
    public String checkToken(String token)
    {
        AccountToken accountToken=tokenList.get(token);
        if (accountToken==null)
        {
            return null;
        }else
        {
            accountToken.setCreateTime(new Date());
            return accountToken.getStuId();
        }
    }
    public static void main(String[] args) {
        AccountAuthentic accountAuthentic=new AccountAuthentic();
        accountAuthentic.addToken("asas","123");
        System.out.println(accountAuthentic.checkToken("asas"));
        System.out.println(accountAuthentic.checkToken("as"));
    }
}
